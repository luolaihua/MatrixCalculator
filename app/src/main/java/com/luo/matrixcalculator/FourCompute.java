package com.luo.matrixcalculator;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FourCompute extends BaseActivity implements View.OnClickListener{
    private TextView tv_result,tv_equal,tv_add,tv_sub,tv_mult,tv_solve,tv_solveTran,tv_analysisA,tv_analysisB;
    private EditText edt_0,edt_1,edt_2,edt_3,edt_4,edt_5,edt_6,edt_7,edt_8,
            edt_9,edt_10,edt_11,edt_12,edt_13,edt_14,edt_15,
            edt2_0,edt2_1,edt2_2,edt2_3,edt2_4,edt2_5,edt2_6,edt2_7,edt2_8,
            edt2_9,edt2_10,edt2_11,edt2_12,edt2_13,edt2_14,edt2_15;

    private int flag = 1;

    private double[][] m = new double[4][4];
    private double[][] n = new double[4][4];
    private double[][] result,eigD,eigV,inverse,transpose;
    private double rank,det;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_compute);

        tv_result = (TextView) findViewById(R.id.four_tv_result);
        tv_add =(TextView) findViewById(R.id.four_tv_add);
        tv_sub = (TextView) findViewById(R.id.four_tv_sub);
        tv_mult = (TextView) findViewById(R.id.four_tv_mult);
        tv_equal = (TextView) findViewById(R.id.four_tv_equal);
        tv_solve = (TextView) findViewById(R.id.four_sovle);
        tv_solveTran = (TextView) findViewById(R.id.four_sovleTran);
        tv_analysisA = (TextView) findViewById(R.id.four_analysisA);
        tv_analysisB = (TextView) findViewById(R.id.four_analysisB);


        tv_add.setOnClickListener(this);
        tv_sub.setOnClickListener(this);
        tv_mult.setOnClickListener(this);
        tv_solve.setOnClickListener(this);
        tv_solveTran.setOnClickListener(this);
        tv_analysisA.setOnClickListener(this);
        tv_analysisB.setOnClickListener(this);

        edt2_0 = (EditText) findViewById(R.id.four_edtInput2_0);
        edt2_1 = (EditText) findViewById(R.id.four_edtInput2_1);
        edt2_2 = (EditText) findViewById(R.id.four_edtInput2_2);
        edt2_3 = (EditText) findViewById(R.id.four_edtInput2_3);
        edt2_4 = (EditText) findViewById(R.id.four_edtInput2_4);
        edt2_5 = (EditText) findViewById(R.id.four_edtInput2_5);
        edt2_6 = (EditText) findViewById(R.id.four_edtInput2_6);
        edt2_7 = (EditText) findViewById(R.id.four_edtInput2_7);
        edt2_8 = (EditText) findViewById(R.id.four_edtInput2_8);
        edt2_9 = (EditText) findViewById(R.id.four_edtInput2_9);
        edt2_10 = (EditText) findViewById(R.id.four_edtInput2_10);
        edt2_11 = (EditText) findViewById(R.id.four_edtInput2_11);
        edt2_12 = (EditText) findViewById(R.id.four_edtInput2_12);
        edt2_13 = (EditText) findViewById(R.id.four_edtInput2_13);
        edt2_14 = (EditText) findViewById(R.id.four_edtInput2_14);
        edt2_15 = (EditText) findViewById(R.id.four_edtInput2_15);



        edt_0 = (EditText) findViewById(R.id.four_edtInput_0);
        edt_1 = (EditText) findViewById(R.id.four_edtInput_1);
        edt_2 = (EditText) findViewById(R.id.four_edtInput_2);
        edt_3 = (EditText) findViewById(R.id.four_edtInput_3);
        edt_4 = (EditText) findViewById(R.id.four_edtInput_4);
        edt_5 = (EditText) findViewById(R.id.four_edtInput_5);
        edt_6 = (EditText) findViewById(R.id.four_edtInput_6);
        edt_7 = (EditText) findViewById(R.id.four_edtInput_7);
        edt_8 = (EditText) findViewById(R.id.four_edtInput_8);
        edt_9 = (EditText) findViewById(R.id.four_edtInput_9);
        edt_10 = (EditText) findViewById(R.id.four_edtInput_10);
        edt_11 = (EditText) findViewById(R.id.four_edtInput_11);
        edt_12 = (EditText) findViewById(R.id.four_edtInput_12);
        edt_13 = (EditText) findViewById(R.id.four_edtInput_13);
        edt_14 = (EditText) findViewById(R.id.four_edtInput_14);
        edt_15 = (EditText) findViewById(R.id.four_edtInput_15);




        tv_equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                n[0][0] = Double.parseDouble(edt2_0.getText().toString());
                n[0][1] = Double.parseDouble(edt2_1.getText().toString());
                n[0][2] = Double.parseDouble(edt2_2.getText().toString());
                n[0][3] = Double.parseDouble(edt2_3.getText().toString());
                n[1][0] = Double.parseDouble(edt2_4.getText().toString());
                n[1][1] = Double.parseDouble(edt2_5.getText().toString());
                n[1][2] = Double.parseDouble(edt2_6.getText().toString());
                n[1][3] = Double.parseDouble(edt2_7.getText().toString());
                n[2][0] = Double.parseDouble(edt2_8.getText().toString());
                n[2][1] = Double.parseDouble(edt2_9.getText().toString());
                n[2][2] = Double.parseDouble(edt2_10.getText().toString());
                n[2][3] = Double.parseDouble(edt2_11.getText().toString());
                n[3][0] = Double.parseDouble(edt2_12.getText().toString());
                n[3][1] = Double.parseDouble(edt2_13.getText().toString());
                n[3][2] = Double.parseDouble(edt2_14.getText().toString());
                n[3][3] = Double.parseDouble(edt2_15.getText().toString());



                m[0][0] = Double.parseDouble(edt_0.getText().toString());
                m[0][1] = Double.parseDouble(edt_1.getText().toString());
                m[0][2] = Double.parseDouble(edt_2.getText().toString());
                m[0][3] = Double.parseDouble(edt_3.getText().toString());
                m[1][0] = Double.parseDouble(edt_4.getText().toString());
                m[1][1] = Double.parseDouble(edt_5.getText().toString());
                m[1][2] = Double.parseDouble(edt_6.getText().toString());
                m[1][3] = Double.parseDouble(edt_7.getText().toString());
                m[2][0] = Double.parseDouble(edt_8.getText().toString());
                m[2][1] = Double.parseDouble(edt_9.getText().toString());
                m[2][2] = Double.parseDouble(edt_10.getText().toString());
                m[2][3] = Double.parseDouble(edt_11.getText().toString());
                m[3][0] = Double.parseDouble(edt_12.getText().toString());
                m[3][1] = Double.parseDouble(edt_13.getText().toString());
                m[3][2] = Double.parseDouble(edt_14.getText().toString());
                m[3][3] = Double.parseDouble(edt_15.getText().toString());




                result = MyJama.getResult(m, n, flag);
               /* switch (flag){
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
                                String.format("%.2f", result[0][2])+"    "+
                                String.format("%.2f", result[0][3])+"    \n"+
                                String.format("%.2f", result[1][0])+"    "+
                                String.format("%.2f", result[1][1])+"    "+
                                String.format("%.2f", result[1][2])+"    "+
                                String.format("%.2f", result[1][3])+"    \n"+
                                String.format("%.2f", result[2][0])+"    "+
                                String.format("%.2f", result[2][1])+"    "+
                                String.format("%.2f", result[2][2])+"    "+
                                String.format("%.2f", result[2][3])+"    \n"+
                                String.format("%.2f", result[3][0])+"    "+
                                String.format("%.2f", result[3][1])+"    "+
                                String.format("%.2f", result[3][2])+"    "+
                                String.format("%.2f", result[3][3])+"    "

                );



            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.four_tv_add:
                tv_add.setBackgroundColor(Color.parseColor("#B0D6F5"));
                tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_mult.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_solve.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_solveTran.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                flag = 1;break;
            case R.id.four_tv_sub:
                tv_sub.setBackgroundColor(Color.parseColor("#B0D6F5"));
                tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_mult.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_solve.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_solveTran.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                flag = 2;break;
            case R.id.four_tv_mult:
                tv_mult.setBackgroundColor(Color.parseColor("#B0D6F5"));
                tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_solve.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_solveTran.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                flag = 3;break;
            case R.id.four_sovle:
                tv_mult.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_solve.setBackgroundColor(Color.parseColor("#B0D6F5"));
                tv_solveTran.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                flag = 4;break;
            case R.id.four_sovleTran:
                tv_mult.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_sub.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_add.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_solve.setBackgroundColor(Color.parseColor("#6FE2EDF5"));
                tv_solveTran.setBackgroundColor(Color.parseColor("#B0D6F5"));
                flag = 5;break;
            case R.id.four_analysisA:
                m[0][0] = Double.parseDouble(edt_0.getText().toString());
                m[0][1] = Double.parseDouble(edt_1.getText().toString());
                m[0][2] = Double.parseDouble(edt_2.getText().toString());
                m[0][3] = Double.parseDouble(edt_3.getText().toString());
                m[1][0] = Double.parseDouble(edt_4.getText().toString());
                m[1][1] = Double.parseDouble(edt_5.getText().toString());
                m[1][2] = Double.parseDouble(edt_6.getText().toString());
                m[1][3] = Double.parseDouble(edt_7.getText().toString());
                m[2][0] = Double.parseDouble(edt_8.getText().toString());
                m[2][1] = Double.parseDouble(edt_9.getText().toString());
                m[2][2] = Double.parseDouble(edt_10.getText().toString());
                m[2][3] = Double.parseDouble(edt_11.getText().toString());
                m[3][0] = Double.parseDouble(edt_12.getText().toString());
                m[3][1] = Double.parseDouble(edt_13.getText().toString());
                m[3][2] = Double.parseDouble(edt_14.getText().toString());
                m[3][3] = Double.parseDouble(edt_15.getText().toString());

                Intent intent = new Intent(FourCompute.this, Analysis.class);

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

                startActivity(intent);
                break;

        }
    }
}
