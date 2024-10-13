package org.example.lr1_tech_rozpol_system;

public class IntegralCalculate {
    private class IntegralThread extends Thread {
        private double a, h;
        private int st, en;
        private Function fun;
        private double result=0;
        public IntegralThread(double a, int st, int en, double h, Function f) {
            this.a=a;
            this.st=st;
            this.en=en;
            this.h=h;
            this.fun=f;
        }
        public void run() {
            for (int i=st; i<en; i++) {
                double x=a+i*h;
                result += fun.calculate(x)*h;
            }
        }
        public double getResult() {
            return result;
        }
    }
    public double calculateIntegral(double a, double b, int n, int thr, Function f) throws InterruptedException {
        double h=(b-a)/n;
        IntegralThread[] threads=new IntegralThread[thr];
        int w=n/thr;
        for(int i=0;i<thr;i++){
            int start=i*w;
            int end=(i==thr-1)?n:start+w;
            threads[i]=new IntegralThread(a,start,end,h,f);
            threads[i].start();
        }
        double total=0;
        for (IntegralThread thread:threads) {
            thread.join();
            total+=thread.getResult();
        }
        return total;
    }
}

