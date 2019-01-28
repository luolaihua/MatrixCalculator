package com.luo.matrixcalculator;

public class MatrixTest {


        public static void main(String[] args) {
            // TODO Auto-generated method stub
            double[][] m = {
                    {1,2,3},
                    {4,5,6},
                    {7,8,9}
            };

            double[][] n ={
                    {0,2,4},
                    {1,4.5,2.2},
                    {1.1,4.3,5.2}
            };
            System.out.println("The determinant of m: "+matrixDet(m));
            System.out.println("The determinant of n: "+matrixDet(n));
            dispMatrix(m);
            System.out.println("************************************");
            dispMatrix(n);
            System.out.println("addtion*****************************");

            double[][] sum=new double[3][3];
            double[][] sub=new double[3][3];
            double[][] mult=new double[3][3];
            sum = matrixAdd(m, n);
            dispMatrix(sum);

            System.out.println("subtraction**********************");

            sub = matrixSub(m, n);
            dispMatrix(sub);
            System.out.println("multiplication**********************");

            mult = matrixMult(m, n);
            dispMatrix(mult);
        }


        //********************************************************
        public static void dispMatrix(double[][] m) {
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length; j++) {
                    System.out.printf("%-15.2f",m[i][j]);
                }
                System.out.println();
            }
        }
        public static double[][] matrixAdd(double[][] m,double[][] n) {
            int a = m.length;
            double[][] sum=new double[a][a];
            for (int i = 0; i < sum.length; i++) {
                for (int j = 0; j < sum.length; j++) {
                    sum[i][j] = m[i][j]+n[i][j];
                }
            }
            return sum;
        }
        public static double[][] matrixSub(double[][] m,double[][] n) {
            int a = m.length;
            double[][] sub=new double[a][a];
            for (int i = 0; i < sub.length; i++) {
                for (int j = 0; j < sub.length; j++) {
                    sub[i][j] = m[i][j]-n[i][j];
                }
            }
            return sub;
        }
        public static double[][] matrixMult(double[][] m,double[][] n) {
            int a = m.length;
            double[][] ans=new double[a][a];
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans.length; j++) {
                    ans[i][j] = m[i][0]*n[0][j]+m[i][2]*n[2][j]+m[i][1]*n[1][j];
                }
            }
            return ans;
        }
        public static double[][] matrixInverse(double[][] m) {
            int a = m.length;
            double[][] ans=new double[a][a];
            if(a==2) {
                ans[0][0] = m[1][1];
                ans[0][1] =-m[0][1];
                ans[1][0] =-m[1][0];
                ans[1][1] = m[0][0];
            }else {
                //double det = matrixDet(m);

            }

            return ans;
        }
        public static double matrixDet(double[][] m) {
            double ans ;
            ans = m[0][0]*m[1][1]*m[2][2]+ m[2][0]*m[0][1]*m[1][2]+
                    m[0][2]*m[1][0]*m[2][1]- m[0][2]*m[1][1]*m[2][0]-
                    m[0][0]*m[1][2]*m[2][1]- m[0][1]*m[1][0]*m[2][2];
            return ans;
        }
    }
