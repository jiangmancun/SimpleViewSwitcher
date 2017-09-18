# 自定义广告View

#### 效果图：  
<image src="./image/view_switcher.gif" />

**布局中使用**

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context="com.example.simpleviewswitcher.MainActivity">

    <com.example.simpleviewswitcher.HorizontalViewSwitcher
        android:id="@+id/from_left_to_right_in"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_marginTop="20dp"
        android:background="#f7f7f7" />

    <com.example.simpleviewswitcher.HorizontalViewSwitcher
        android:id="@+id/from_right_to_left_in"
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:layout_marginTop="20dp"
        android:background="#f7f7f7" />

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:background="#f7f7f7"
        android:gravity="center_vertical"
        android:layout_marginTop="20dp"
        android:orientation="horizontal"
        android:paddingLeft="15dp">

        <ImageView
            android:layout_width="17dp"
            android:layout_height="18dp"
            android:src="@mipmap/icon_activity_ring" />

        <com.example.simpleviewswitcher.VerticalViewSwitcher
            android:id="@+id/from_top_to_bottom_in"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_marginLeft="10dp" />
    </LinearLayout>

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="50dp"
        android:background="#f7f7f7"
        android:gravity="center_vertical"
        android:layout_marginTop="20dp"
        android:orientation="horizontal"
        android:paddingLeft="15dp">

        <ImageView
            android:layout_width="17dp"
            android:layout_height="18dp"
            android:src="@mipmap/icon_activity_ring" />

        <com.example.simpleviewswitcher.VerticalViewSwitcher
            android:id="@+id/from_bottom_to_top_in"
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:layout_marginLeft="10dp" />
    </LinearLayout>


</LinearLayout>
```

**代码中使用**

```java
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
```

# 如何联系我：

QQ：1298300385，QQ群：83936534
