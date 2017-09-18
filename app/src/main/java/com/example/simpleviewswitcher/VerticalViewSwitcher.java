package com.example.simpleviewswitcher;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.yuntianhe.library.IAnimationFactory;
import com.yuntianhe.library.SimpleViewSwitcher;
import com.yuntianhe.library.VerticalSwitchAnimation;

/**
 * @author dwj  2017/9/11 10:23
 */

public class VerticalViewSwitcher extends SimpleViewSwitcher<String> {

    public VerticalViewSwitcher(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected IAnimationFactory onCreateAnimation() {
        return new VerticalSwitchAnimation();
    }

    @Override
    public int getGravity() {
        return Gravity.LEFT | Gravity.CENTER_VERTICAL;
    }

    @Override
    protected View onCreateView(LayoutInflater inflater) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        textView.setTextColor(Color.parseColor("#808080"));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        textView.setGravity(Gravity.CENTER_VERTICAL);
        return textView;
    }

    @Override
    protected void onBindView(View view, String title) {
        TextView textView = (TextView) view;
        textView.setText(title);
    }

}
