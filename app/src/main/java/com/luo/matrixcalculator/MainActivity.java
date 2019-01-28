package com.luo.matrixcalculator;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Spinner spinner_row_a, spinner_column_a,spinner_row_b, spinner_column_b;
    private TextView tv_result,tv_equal,tv_add,tv_sub,tv_mult,tv_sovle,tv_sovleTran;
    private EditText et_a,et_b;
    private String input_a,input_b;
    private List<String> row_a = new ArrayList<>();
    private List<String> column_a = new ArrayList<>();
    private List<String> row_b = new ArrayList<>();
    private List<String> column_b = new ArrayList<>();
    private int num_row_a=1,num_row_b=1,num_column_a=1,num_column_b=1;
    private  int flag = 1;
    private double[][] result,eigD,eigV,inverse,transpose;
    private double rank,det;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_result = (TextView) findViewById(R.id.main_tv_result);
        tv_add =(TextView) findViewById(R.id.main_tv_add);
        tv_sub = (TextView) findViewById(R.id.main_tv_sub);
        tv_mult = (TextView) findViewById(R.id.main_tv_mult);
        tv_equal = (TextView) findViewById(R.id.main_tv_equal);
        tv_sovle = (TextView) findViewById(R.id.main_sovle);
        tv_sovleTran = (TextView) findViewById(R.id.main_sovleTran);

        spinner_row_a = (Spinner) findViewById(R.id.row_a);
        spinner_column_a = (Spinner) findViewById(R.id.column_a);
        et_a = (EditText) findViewById(R.id.et_a);
        spinner_row_b = (Spinner) findViewById(R.id.row_b);
        spinner_column_b = (Spinner) findViewById(R.id.column_b);
        et_b = (EditText) findViewById(R.id.et_b);



        tv_add.setOnClickListener(this);
        tv_sub.setOnClickListener(this);
        tv_mult.setOnClickListener(this);
        tv_sovle.setOnClickListener(this);
        tv_sovleTran.setOnClickListener(this);

        row_a.add("1行");
        row_a.add("2行");
        row_a.add("3行");
        row_a.add("4行");
        row_a.add("5行");
        column_a.add("1列");
        column_a.add("2列");
        column_a.add("3列");
        column_a.add("4列");
        column_a.add("5列");
        row_b.add("1行");
        row_b.add("2行");
        row_b.add("3行");
        row_b.add("4行");
        row_b.add("5行");
        column_b.add("1列");
        column_b.add("2列");
        column_b.add("3列");
        column_b.add("4列");
        column_b.add("5列");

        ArrayAdapter<String> adapter_row_a =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,row_a);
        ArrayAdapter<String> adapter_column_a =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,column_a);

        ArrayAdapter<String> adapter_row_b =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,row_b);
        ArrayAdapter<String> adapter_column_b =
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,column_b);


        adapter_row_a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_row_a.setAdapter(adapter_row_a);
        adapter_column_a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_column_a.setAdapter(adapter_column_a);

        adapter_row_b.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_row_b.setAdapter(adapter_row_b);
        adapter_column_b.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_column_b.setAdapter(adapter_column_b);



        spinner_row_a.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                num_row_a = position + 1;
                if (num_row_a != num_row_b || num_column_a != num_column_b) {
                    tv_add.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_sub.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_add.setClickable(false);
                    tv_sub.setClickable(false);
                }else {
                    tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_add.setClickable(true);
                    tv_sub.setClickable(true);
                }
                if (num_row_a != num_column_b || num_column_a != num_row_b ) {
                    tv_mult.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_mult.setClickable(false);
                }else {
                    tv_mult.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_mult.setClickable(true);
                }

                //----------A*X=B----ac*cb=ab
                if (num_row_a  != num_row_b  ) {
                    tv_sovle.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_sovle.setClickable(false);
                }else {
                    tv_sovle.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_sovle.setClickable(true);
                }
                //----------X*A=B----ac*cb=ab
                if (num_column_a  != num_column_b  ) {
                    tv_sovleTran.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_sovleTran.setClickable(false);
                }else {
                    tv_sovleTran.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_sovleTran.setClickable(true);
                }

               /* if (num_row_a * num_column_a != num_row_b * num_column_b ) {
                    tv_sovle.setBackgroundColor(Color.parseColor("#001D20"));
                    tv_sovleTran.setBackgroundColor(Color.parseColor("#001D20"));
                    tv_sovle.setClickable(false);
                    tv_sovleTran.setClickable(false);
                }else {
                    tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_sovle.setClickable(true);
                    tv_sovleTran.setClickable(true);
                }*/
                //Toast.makeText(MainActivity.this, num_row_a+"", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_column_a.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                num_column_a = position + 1;
                if (num_row_a != num_row_b || num_column_a != num_column_b) {
                    tv_add.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_sub.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_add.setClickable(false);
                    tv_sub.setClickable(false);
                }else {
                    tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_add.setClickable(true);
                    tv_sub.setClickable(true);
                }
                if (num_row_a != num_column_b || num_column_a != num_row_b ) {
                    tv_mult.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_mult.setClickable(false);
                }else {
                    tv_mult.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_mult.setClickable(true);
                }
                //----------A*X=B----ac*cb=ab
                if (num_row_a  != num_row_b  ) {
                    tv_sovle.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_sovle.setClickable(false);
                }else {
                    tv_sovle.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_sovle.setClickable(true);
                }
                //----------X*A=B----ac*cb=ab
                if (num_column_a  != num_column_b  ) {
                    tv_sovleTran.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_sovleTran.setClickable(false);
                }else {
                    tv_sovleTran.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_sovleTran.setClickable(true);
                }
               // Toast.makeText(MainActivity.this, num_column_a+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_row_b.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                num_row_b = position+1;
                if (num_row_a != num_row_b || num_column_a != num_column_b) {
                    tv_add.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_sub.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_add.setClickable(false);
                    tv_sub.setClickable(false);
                }else {
                    tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_add.setClickable(true);
                    tv_sub.setClickable(true);
                }
                if (num_row_a != num_column_b || num_column_a != num_row_b ) {
                    tv_mult.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_mult.setClickable(false);
                }else {
                    tv_mult.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_mult.setClickable(true);
                }
                //----------A*X=B----ac*cb=ab
                if (num_row_a  != num_row_b  ) {
                    tv_sovle.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_sovle.setClickable(false);
                }else {
                    tv_sovle.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_sovle.setClickable(true);
                }
                //----------X*A=B----ac*cb=ab
                if (num_column_a  != num_column_b  ) {
                    tv_sovleTran.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_sovleTran.setClickable(false);
                }else {
                    tv_sovleTran.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_sovleTran.setClickable(true);
                }
                //Toast.makeText(MainActivity.this, num_row_b+"", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        spinner_column_b.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                num_column_b = position+1;
                if (num_row_a != num_row_b || num_column_a != num_column_b) {
                    tv_add.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_sub.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_add.setClickable(false);
                    tv_sub.setClickable(false);
                }else {
                    tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_add.setClickable(true);
                    tv_sub.setClickable(true);
                }
                if (num_row_a != num_column_b || num_column_a != num_row_b ) {
                    tv_mult.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_mult.setClickable(false);
                }else {
                    tv_mult.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_mult.setClickable(true);
                }
                //----------A*X=B----ac*cb=ab
                if (num_row_a  != num_row_b  ) {
                    tv_sovle.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_sovle.setClickable(false);
                }else {
                    tv_sovle.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_sovle.setClickable(true);
                }
                //----------X*A=B----ac*cb=ab
                if (num_column_a  != num_column_b  ) {
                    tv_sovleTran.setBackgroundColor(Color.parseColor("#F3978F"));
                    tv_sovleTran.setClickable(false);
                }else {
                    tv_sovleTran.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                    tv_sovleTran.setClickable(true);
                }
                //  Toast.makeText(MainActivity.this,num_column_b+"", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        tv_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               input_a = et_a.getText().toString();
               input_b = et_b.getText().toString();
               try {
                   double[] a = MyJama.StrToNum(input_a);
                   double[] b = MyJama.StrToNum(input_b);
                   double[][] m = MyJama.OneToTwo(a, num_row_a, num_column_a);
                   double[][] n = MyJama.OneToTwo(b, num_row_b, num_column_b);
                   result = MyJama.getResult(m, n, flag);
                   tv_result.setText(MyJama.output(result).toString());
               }catch (Exception e){
                   e.printStackTrace();
                   Toast.makeText(MainActivity.this,"输入错误！", Toast.LENGTH_SHORT).show();
               }

            }
        });





    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.main_tv_add:
                tv_add.setBackgroundColor(Color.parseColor("#B0D6F5"));
                tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_mult.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_sovle.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_sovleTran.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                flag = 1;break;
            case R.id.main_tv_sub:
                tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_sub.setBackgroundColor(Color.parseColor("#B0D6F5"));
                tv_mult.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_sovle.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_sovleTran.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                flag = 2;break;
            case R.id.main_tv_mult:
                tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_mult.setBackgroundColor(Color.parseColor("#B0D6F5"));
                tv_sovle.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_sovleTran.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                flag = 3;break;
            case R.id.main_sovle:
                tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_mult.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_sovle.setBackgroundColor(Color.parseColor("#B0D6F5"));
                tv_sovleTran.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                flag = 4;break;
            case R.id.main_sovleTran:
                tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_mult.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_sovle.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_sovleTran.setBackgroundColor(Color.parseColor("#B0D6F5"));
                flag = 5;break;
/*            case R.id.two_analysisA:
                m[0][0] = Double.parseDouble(edt_0.getText().toString());
                m[0][1] = Double.parseDouble(edt_1.getText().toString());
                m[1][0] = Double.parseDouble(edt_2.getText().toString());
                m[1][1] = Double.parseDouble(edt_3.getText().toString());
                Intent intent = new Intent(TwoCompute.this, Analysis.class);

                rank = MyJama.matrixRank(m);
                det = MyJama.matrixDet(m);
                transpose = MyJama.matrixTranspose(m);
                eigD = MyJama.matrixEigD(m);
                eigV = MyJama.matrixEigV(m);

                double[] tranOne = MyJama.TwotoOne(transpose);
                double[] eigDOne = MyJama.TwotoOne(eigD);
                double[] eigVOne = MyJama.TwotoOne(eigV);


                intent.putExtra("rank",rank);
                intent.putExtra("det", det);
                intent.putExtra("transpose", tranOne);
                intent.putExtra("eigD", eigDOne);
                intent.putExtra("eigV", eigVOne);

                if(det != 0){
                    inverse = MyJama.matrixInverse(m);
                    double[] inverseOne = MyJama.TwotoOne(inverse);
                    intent.putExtra("inverse", inverseOne);
                }

                startActivity(intent);break;

            case R.id.two_analysisB:
                n[0][0] = Double.parseDouble(edt2_0.getText().toString());
                n[0][1] = Double.parseDouble(edt2_1.getText().toString());
                n[1][0] = Double.parseDouble(edt2_2.getText().toString());
                n[1][1] = Double.parseDouble(edt2_3.getText().toString());

                Intent intent1 = new Intent(TwoCompute.this, Analysis.class);

                rank = MyJama.matrixRank(n);
                det = MyJama.matrixDet(n);
                transpose = MyJama.matrixTranspose(n);
                eigD = MyJama.matrixEigD(n);
                eigV = MyJama.matrixEigV(n);

                double[] tranOne1 = MyJama.TwotoOne(transpose);
                double[] eigDOne1 = MyJama.TwotoOne(eigD);
                double[] eigVOne1 = MyJama.TwotoOne(eigV);


                intent1.putExtra("rank",rank);
                intent1.putExtra("det", det);
                intent1.putExtra("transpose", tranOne1);
                intent1.putExtra("eigD", eigDOne1);
                intent1.putExtra("eigV", eigVOne1);

                if(det != 0){
                    inverse = MyJama.matrixInverse(n);
                    double[] inverseOne = MyJama.TwotoOne(inverse);
                    intent1.putExtra("inverse", inverseOne);
                }
                startActivity(intent1);break;*/
        }
    }










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
                startActivity(intent);break;
            case R.id.three:
                Intent intent1 = new Intent(MyApplication.getContext(),ThreeCompute.class);
                startActivity(intent1);break;
            case R.id.four:
                Intent intent2 = new Intent(MyApplication.getContext(),FourCompute.class);
                startActivity(intent2);break;

        }
        return super.onOptionsItemSelected(item);
    }

}
