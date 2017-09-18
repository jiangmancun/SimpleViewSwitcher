# 自定义广告View

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
        android:id="@+id/horizontal_view_switcher"
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
            android:id="@+id/vertical_view_switcher"
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
```

# 如何联系我：

QQ：129830085，QQ群：83936534