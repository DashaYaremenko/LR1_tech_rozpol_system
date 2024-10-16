package org.example.lr1_tech_rozpol_system;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField fieldA,fieldB,fieldN,fieldTHR;
    @FXML
    private Label resultLab, timeLab, proc;

    private Function function=new Function();
    private IntegralCalculate calculateIntegral=new IntegralCalculate();

    @FXML
    private void handCompute(){
        try {
            double a=Double.parseDouble(fieldA.getText());
            double b=Double.parseDouble(fieldB.getText());
            int n=Integer.parseInt(fieldN.getText());
            int thr=Integer.parseInt(fieldTHR.getText());
            long startT=System.currentTimeMillis();
            double res=calculateIntegral.calculateIntegral(a,b,n,thr,function);
            long endT=System.currentTimeMillis();
            proc.setText("Кількість ядер: "+Runtime.getRuntime().availableProcessors());
            resultLab.setText("Відповідь: " + res);
            timeLab.setText("Час: " + (endT - startT) + " мс");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}