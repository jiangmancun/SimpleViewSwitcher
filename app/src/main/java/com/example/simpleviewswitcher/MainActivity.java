package com.example.simpleviewswitcher;

import android.app.Activity;
import android.os.Bundle;

import com.yuntianhe.simpleviewswitcher.FromBottomToTopIn;
import com.yuntianhe.simpleviewswitcher.FromLeftToRightIn;
import com.yuntianhe.simpleviewswitcher.FromRightToLeftIn;
import com.yuntianhe.simpleviewswitcher.FromTopToBottomIn;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] titles = {
                "元旦大礼包，速速来抢",
                "情人节专属，还在等什么？",
                "端午、中秋来相聚"
        };

        // 从左往右进入
        HorizontalViewSwitcher fromLeftToRightIn = (HorizontalViewSwitcher) findViewById(R.id.from_left_to_right_in);
        fromLeftToRightIn.setAnimationFactory(new FromLeftToRightIn());
        fromLeftToRightIn.setData(titles);
        fromLeftToRightIn.start();

        // 从右边往左进入
        HorizontalViewSwitcher fromRightToLeftIn = (HorizontalViewSwitcher) findViewById(R.id.from_right_to_left_in);
        fromRightToLeftIn.setAnimationFactory(new FromRightToLeftIn());
        fromRightToLeftIn.setData(titles);
        fromRightToLeftIn.start();

        // 从上往下进入
        VerticalViewSwitcher fromTopToBottomIn = (VerticalViewSwitcher) findViewById(R.id.from_top_to_bottom_in);
        fromTopToBottomIn.setAnimationFactory(new FromTopToBottomIn());
        fromTopToBottomIn.setData(titles);
        fromTopToBottomIn.start();

        // 从下往上进入
        VerticalViewSwitcher fromBottomToTopIn = (VerticalViewSwitcher) findViewById(R.id.from_bottom_to_top_in);
        fromBottomToTopIn.setAnimationFactory(new FromBottomToTopIn());
        fromBottomToTopIn.setData(titles);
        fromBottomToTopIn.start();

    }
}
