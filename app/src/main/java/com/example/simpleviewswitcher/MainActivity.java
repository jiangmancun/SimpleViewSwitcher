package com.example.simpleviewswitcher;

import android.app.Activity;
import android.os.Bundle;

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

        // 水平滚动滚动
        HorizontalViewSwitcher horizontalViewSwitcher = (HorizontalViewSwitcher) findViewById(R.id.horizontal_view_switcher);
        horizontalViewSwitcher.setData(titles);
        horizontalViewSwitcher.start();

        // 垂直滚动
        VerticalViewSwitcher verticalViewSwitcher = (VerticalViewSwitcher) findViewById(R.id.vertical_view_switcher);
        verticalViewSwitcher.setData(titles);
        verticalViewSwitcher.start();

    }
}
