package fragment.bwie.com.rikao5;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private CustomProgrssView customProgrssView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.saomiao);
        customProgrssView = (CustomProgrssView) findViewById(R.id.custom);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customProgrssView.start();
            }
        });


        setNavigationTitle("首页");
    }


    private void setNavigationTitle(String title) {
        CustomNavigationBar navigationBar = (CustomNavigationBar) findViewById(R.id.custom_navigation_bar);
        navigationBar.setNavigationTitle(title);


        //实现组件上的按钮的接口回调
        navigationBar.setCallBackListener(new CustomNavigationBar.OnClickCallBackListener() {
            @Override
            public void OnClickButton(View v) {
                Intent intent = new Intent(MainActivity.this,TiaoZhuan.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
