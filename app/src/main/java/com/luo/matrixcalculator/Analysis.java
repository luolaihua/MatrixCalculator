package com.luo.matrixcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Analysis extends AppCompatActivity {
    private TextView tv_rank,tv_det,tv_tran,tv_eigD,tv_eigV,tv_inver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

        tv_det = (TextView) findViewById(R.id.det);
        tv_rank = (TextView) findViewById(R.id.rank);
        tv_tran = (TextView) findViewById(R.id.transpose);
        tv_eigD = (TextView) findViewById(R.id.eigD);
        tv_eigV = (TextView) findViewById(R.id.eigV);
        tv_inver = (TextView) findViewById(R.id.inverse);

        Intent intent = getIntent();

        double r = intent.getDoubleExtra("rank",666);
        double d = intent.getDoubleExtra("det",999);
        double[] tran = intent.getDoubleArrayExtra("transpose");
        double[] eigV = intent.getDoubleArrayExtra("eigV");
        double[] eigD = intent.getDoubleArrayExtra("eigD");

        StringBuilder sb_tran = MyJama.output(tran);
        StringBuilder sb_eigV = MyJama.output(eigV);
        StringBuilder sb_eigD = MyJama.output(eigD);

        tv_rank.setText(r+"");
        tv_det.setText(d+"");
        tv_tran.setText(sb_tran.toString());
        tv_eigV.setText(sb_eigV.toString());
        tv_eigD.setText(sb_eigD.toString());
        if (r != 0) {
            double[] inver = intent.getDoubleArrayExtra("inverse");
            StringBuilder sb_inver = MyJama.output(inver);
            tv_inver.setText(sb_inver.toString());
        }else {
            tv_inver.setText("不可逆");
        }



        /*double[] k =intent.getDoubleArrayExtra("data2_A");
        double[][] result = MyJama.OneToTwo(k);

        textView.setText(

                        String.format("%.2f", result[0][0])+"    "+
                        String.format("%.2f", result[0][1])+"    \n"+
                        String.format("%.2f", result[1][0])+"    "+
                        String.format("%.2f", result[1][1])+"    "
        );*/
    }
}
