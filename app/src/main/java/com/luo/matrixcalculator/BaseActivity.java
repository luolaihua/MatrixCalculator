package com.luo.matrixcalculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class BaseActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.test,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.two:
                Intent intent = new Intent(MyApplication.getContext(),TwoCompute.class);
                startActivity(intent);finish();break;
            case R.id.three:
                Intent intent1 = new Intent(MyApplication.getContext(),ThreeCompute.class);
                startActivity(intent1);finish();break;
            case R.id.four:
                Intent intent2 = new Intent(MyApplication.getContext(),FourCompute.class);
                startActivity(intent2);finish();break;

        }
        return super.onOptionsItemSelected(item);
    }

}
