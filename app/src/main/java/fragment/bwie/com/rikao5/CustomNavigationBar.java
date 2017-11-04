package fragment.bwie.com.rikao5;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by CZ on 2017/11/4.
 */
public class CustomNavigationBar extends FrameLayout {


    public static interface OnClickCallBackListener {
        public void OnClickButton(View v);
    }


    private OnClickCallBackListener callBackListener;            //声明接口对象


    public String navigationTitle = "标题栏";


    /*
32      * 设置标题栏的标题
33      */
    public void setNavigationTitle(String navigationTitle) {
        this.navigationTitle = navigationTitle;
        TextView textView = (TextView) findViewById(R.id.navigation_title);
        textView.setText(navigationTitle);
    }


    public void setCallBackListener(OnClickCallBackListener callBackListener) {
        this.callBackListener = callBackListener;
    }


    /*
45      *自定义组件的构造方法
46      */
    public CustomNavigationBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.custom_navigation, this);     //加载布局文件
        onClickBackButton();
        callBackButton();
    }

    /*
54      * 点击返回按钮方法
55      */
    private void onClickBackButton() {
        ImageView button = (ImageView) findViewById(R.id.back_title);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
    }


    /*
67      *点击按钮时执行接口回调
68      */
    private void callBackButton() {
        ImageView button = (ImageView) findViewById(R.id.call_back);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callBackListener != null) {
                    callBackListener.OnClickButton(v);
                }
            }
        });
    }
}


