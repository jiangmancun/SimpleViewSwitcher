package com.yuntianhe.simpleviewswitcher;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ViewSwitcher;

import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

/**
 * 垂直滚动切换效果的 ViewGroup
 *
 * @author dwj  2017/9/7 14:40
 */

public abstract class SimpleViewSwitcher<Data> extends ViewSwitcher
        implements ViewSwitcher.ViewFactory, Runnable, View.OnClickListener {

    public interface OnItemClickListener<Data> {
        void onItemClick(View view, int position, Data data);
    }

    private OnItemClickListener<Data> mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener<Data> onItemClickListener) {
        setOnClickListener(onItemClickListener != null ? this : null);
        this.mOnItemClickListener = onItemClickListener;
    }

    @Override
    public void setOnClickListener(@Nullable View.OnClickListener l) {
        if (l == null || l == this) {
            super.setOnClickListener(l);
        } else {
            throw new IllegalArgumentException("Not support setOnClickListener, call setOnItemClickListener instead!");
        }
    }

    @Override
    public void setFactory(ViewFactory factory) {
        if (factory == null || factory == this) {
            super.setFactory(factory);
        } else {
            throw new IllegalArgumentException("Not support setFactory!");
        }
    }

    private Handler mHandler;

    private final int SWITCH_DURATION = 3000;
    private int mSwitchDuration = SWITCH_DURATION;
    private int mGravity = Gravity.LEFT | Gravity.CENTER_VERTICAL;

    private List<Data> mData;
    private int mSize = 0, mIndex = 0;

    public SimpleViewSwitcher(Context context) {
        this(context, null);
    }

    public SimpleViewSwitcher(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFactory(this);
        
        mHandler = new Handler();
        mSwitchDuration = getDuration();
        mGravity = getGravity();

        setAnimationFactory(onCreateAnimation());
    }

    public void setData(List<Data> list) {
        this.mData = list;
    }

    public void setData(Data... array) {
        this.mData = Arrays.asList(array);
    }

    @Override
    public View makeView() {
        View view = onCreateView(LayoutInflater.from(getContext()));
        LayoutParams lp = (LayoutParams) view.getLayoutParams();
        if (lp == null) {
            lp = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        }
        lp.gravity = mGravity;
        view.setLayoutParams(lp);
        return view;
    }

    protected abstract IAnimationFactory onCreateAnimation();

    protected abstract View onCreateView(LayoutInflater inflater);

    protected abstract void onBindView(View view, Data data);

    /**
     * @return the gravity of the content view in ViewSwitcher.
     * @see Gravity
     */
    public int getGravity() {
        return mGravity;
    }

    /**
     * @param gravity the gravity of the content view in ViewSwitcher.
     * @see Gravity
     */
    public void setGravity(int gravity) {
        mGravity = gravity;
    }

    public int getDuration() {
        return mSwitchDuration;
    }

    public void setDuration(int switchDuration) {
        mSwitchDuration = switchDuration;
    }

    public void setAnimationFactory(IAnimationFactory factory) {
        if (factory != null) {
            setInAnimation(factory.in());
            setOutAnimation(factory.out());
        }
    }

    // 执行滚动动画
    public void start() {
        mHandler.removeCallbacksAndMessages(null);
        mSize = mIndex = 0;
        if (mData != null && mData.size() != 0) {
            mSize = mData.size();
            onBindView(getCurrentView(), mData.get(0));
            if (mSize > 1) {
                mHandler.postDelayed(this, mSwitchDuration);
            }
        } else {
            throw new IllegalArgumentException("Data is null or empty!");
        }
    }

    public void stop() {
        mHandler.removeCallbacksAndMessages(null);
    }

    @Override
    public void run() {
        mIndex++;
        mIndex %= mSize;
        showNext();
        onBindView(getCurrentView(), mData.get(mIndex));
        mHandler.postDelayed(this, mSwitchDuration);
    }

    @Override
    public void onClick(View v) {
        if (mData != null && mData.size() != 0) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(getCurrentView(), mIndex, mData.get(mIndex));
            }
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mHandler.removeCallbacksAndMessages(null);
    }
}
