package com.example.simpleviewswitcher;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.yuntianhe.library.HorizontalSwitchAnimation;
import com.yuntianhe.library.IAnimationFactory;
import com.yuntianhe.library.SimpleViewSwitcher;

/**
 * @author dwj  2017/9/11 10:23
 */

public class HorizontalViewSwitcher extends SimpleViewSwitcher<String> {

    public HorizontalViewSwitcher(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public int getGravity() {
        return Gravity.CENTER;
    }

    @Override
    protected IAnimationFactory onCreateAnimation() {
        return new HorizontalSwitchAnimation();
    }

    @Override
    protected View onCreateView(LayoutInflater inflater) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(Color.parseColor("#808080"));
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 14);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }

    @Override
    protected void onBindView(View view, String title) {
        TextView textView = (TextView) view;
        textView.setText(title);
    }

}
