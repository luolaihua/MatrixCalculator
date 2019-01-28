package com.luo.matrixcalculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ThreeCompute extends BaseActivity implements View.OnClickListener{
    private TextView tv_result,tv_equal,tv_add,tv_sub,tv_mult,sovle,sovleTran,tv_analysisA,tv_analysisB;
    private EditText edt_0,edt_1,edt_2,edt_3,edt_4,edt_5,edt_6,edt_7,edt_8,
            edt2_0,edt2_1,edt2_2,edt2_3,edt2_4,edt2_5,edt2_6,edt2_7,edt2_8;

    private int flag = 1;

    private double[][] m = new double[3][3];
    private double[][] n = new double[3][3];
    private double[][] result,eigD,eigV,inverse,transpose;
    private double rank,det;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_compute);

        tv_result = (TextView) findViewById(R.id.tv_result);
        tv_add =(TextView) findViewById(R.id.tv_add);
        tv_sub = (TextView) findViewById(R.id.tv_sub);
        tv_mult = (TextView) findViewById(R.id.tv_mult);
        tv_equal = (TextView) findViewById(R.id.tv_equal);
        sovle = (TextView) findViewById(R.id.sovle);
        sovleTran = (TextView) findViewById(R.id.sovleTran);
        tv_analysisA = (TextView) findViewById(R.id.three_analysisA);
        tv_analysisB = (TextView) findViewById(R.id.three_analysisB);

        tv_add.setOnClickListener(this);
        tv_sub.setOnClickListener(this);
        tv_mult.setOnClickListener(this);
        sovle.setOnClickListener(this);
        sovleTran.setOnClickListener(this);
        tv_analysisA.setOnClickListener(this);
        tv_analysisB.setOnClickListener(this);

        edt2_0 = (EditText) findViewById(R.id.edtInput2_0);
        edt2_1 = (EditText) findViewById(R.id.edtInput2_1);
        edt2_2 = (EditText) findViewById(R.id.edtInput2_2);
        edt2_3 = (EditText) findViewById(R.id.edtInput2_3);
        edt2_4 = (EditText) findViewById(R.id.edtInput2_4);
        edt2_5 = (EditText) findViewById(R.id.edtInput2_5);
        edt2_6 = (EditText) findViewById(R.id.edtInput2_6);
        edt2_7 = (EditText) findViewById(R.id.edtInput2_7);
        edt2_8 = (EditText) findViewById(R.id.edtInput2_8);

        edt_0 = (EditText) findViewById(R.id.edtInput_0);
        edt_1 = (EditText) findViewById(R.id.edtInput_1);
        edt_2 = (EditText) findViewById(R.id.edtInput_2);
        edt_3 = (EditText) findViewById(R.id.edtInput_3);
        edt_4 = (EditText) findViewById(R.id.edtInput_4);
        edt_5 = (EditText) findViewById(R.id.edtInput_5);
        edt_6 = (EditText) findViewById(R.id.edtInput_6);
        edt_7 = (EditText) findViewById(R.id.edtInput_7);
        edt_8 = (EditText) findViewById(R.id.edtInput_8);



        tv_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n[0][0] = Double.parseDouble(edt2_0.getText().toString());
                n[0][1] = Double.parseDouble(edt2_1.getText().toString());
                n[0][2] = Double.parseDouble(edt2_2.getText().toString());
                n[1][0] = Double.parseDouble(edt2_3.getText().toString());
                n[1][1] = Double.parseDouble(edt2_4.getText().toString());
                n[1][2] = Double.parseDouble(edt2_5.getText().toString());
                n[2][0] = Double.parseDouble(edt2_6.getText().toString());
                n[2][1] = Double.parseDouble(edt2_7.getText().toString());
                n[2][2] = Double.parseDouble(edt2_8.getText().toString());

                m[0][0] = Double.parseDouble(edt_0.getText().toString());
                m[0][1] = Double.parseDouble(edt_1.getText().toString());
                m[0][2] = Double.parseDouble(edt_2.getText().toString());
                m[1][0] = Double.parseDouble(edt_3.getText().toString());
                m[1][1] = Double.parseDouble(edt_4.getText().toString());
                m[1][2] = Double.parseDouble(edt_5.getText().toString());
                m[2][0] = Double.parseDouble(edt_6.getText().toString());
                m[2][1] = Double.parseDouble(edt_7.getText().toString());
                m[2][2] = Double.parseDouble(edt_8.getText().toString());


                result = MyJama.getResult(m, n, flag);
                /*switch (flag){
                    case 1:
                        result = MyJama.matrixAdd(m,n);break;
                    case 2:
                        result = MyJama.matrixSub(m,n);break;
                    case 3:
                        result = MyJama.matrixMult(m,n);break;
                    case 4:
                        result = MyJama.matrixSolve(m,n);break;
                    case 5:
                        result = MyJama.matrixSolveTran(m,n);break;

                }*/



                tv_result.setText(

                        String.format("%.2f", result[0][0])+"    "+
                        String.format("%.2f", result[0][1])+"    "+
                        String.format("%.2f", result[0][2])+"\n"+
                        String.format("%.2f", result[1][0])+"    "+
                        String.format("%.2f", result[1][1])+"    "+
                        String.format("%.2f", result[1][2])+"\n"+
                        String.format("%.2f", result[2][0])+"    "+
                        String.format("%.2f", result[2][1])+"    "+
                        String.format("%.2f", result[2][2])+"    "
                );



            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_add:
                tv_add.setBackgroundColor(Color.parseColor("#B0D6F5"));
                tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_mult.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                sovle.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                sovleTran.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                flag = 1;break;
            case R.id.tv_sub:
                tv_sub.setBackgroundColor(Color.parseColor("#B0D6F5"));
                tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_mult.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                sovle.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                sovleTran.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                flag = 2;break;
            case R.id.tv_mult:
                tv_mult.setBackgroundColor(Color.parseColor("#B0D6F5"));
                tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                sovle.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                sovleTran.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                flag = 3;break;
            case R.id.sovle:
                tv_mult.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                sovle.setBackgroundColor(Color.parseColor("#B0D6F5"));
                sovleTran.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                flag = 4;break;
            case R.id.sovleTran:
                tv_mult.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                sovle.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                sovleTran.setBackgroundColor(Color.parseColor("#B0D6F5"));
                flag = 5;break;
            case R.id.three_analysisA:
                m[0][0] = Double.parseDouble(edt_0.getText().toString());
                m[0][1] = Double.parseDouble(edt_1.getText().toString());
                m[0][2] = Double.parseDouble(edt_2.getText().toString());
                m[1][0] = Double.parseDouble(edt_3.getText().toString());
                m[1][1] = Double.parseDouble(edt_4.getText().toString());
                m[1][2] = Double.parseDouble(edt_5.getText().toString());
                m[2][0] = Double.parseDouble(edt_6.getText().toString());
                m[2][1] = Double.parseDouble(edt_7.getText().toString());
                m[2][2] = Double.parseDouble(edt_8.getText().toString());

                Intent intent = new Intent(ThreeCompute.this, Analysis.class);

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

        }
    }
}
