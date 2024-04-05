package week5;

import java.util.Scanner;
import java.lang.Math;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();
        pStudio.J004();
        pStudio.J005();
        pStudio.J011();
        pStudio.J014();
        pStudio.J015();
    }

    void J004(){
        double x1, y1;
        double x2, y2;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input1 ? :");
        x1 = keyboard.nextDouble();
        y1 = keyboard.nextDouble();
        System.out.println("Input2 ? :");
        x2 = keyboard.nextDouble();
        y2 = keyboard.nextDouble();

        double d;
        d = Math.sqrt(Math.pow(x1-x2, 2)+Math.pow(y1-y2, 2));
        System.out.println(d);


    }
    void J005(){
        int month, day;
        int day_count;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Month ? : ");
        month = keyboard.nextInt();
        System.out.println("Day ? : ");
        day = keyboard.nextInt();

        int[] day_m = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        day_count = 0;

        for(int i=0; i<month-1; i++){
            day_count += day_m[i];
        }
        day_count+=day;

        System.out.println(day_count);

    }

    void J011(){
        int height, weight;
        double bmi;

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Height ? :");
        height = keyboard.nextInt();
        System.out.println("Weight ? :");
        weight = keyboard.nextInt();

        double height_m = height/100.0;

        bmi = weight / Math.pow(height_m, 2);

        if(bmi>=25){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }

    void J014(){
        int income;
        double tax;
        double[] t = {0.095, 0.19, 0.28, 0.37};

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Income ? :");
        income = keyboard.nextInt();

        int tM = 10000000;

        if(income>=8*tM){
            tax = income * t[3];
        }else if(income>=4*tM){
            tax = income * t[2];
        }else if(income>=tM){
            tax = income * t[1];
        }else{
            tax = income * t[0];
        }

        DecimalFormat d = new DecimalFormat("#");
        System.out.println(d.format(tax));
//        System.out.println(tax);

    }

    void J015(){
        int num1, num2, num3;
        int max, min;

        Scanner keyboard = new Scanner(System.in);
        System.out.println("N1 ? :");
        num1 = keyboard.nextInt();
        System.out.println("N2 ? :");
        num2 = keyboard.nextInt();
        System.out.println("N3 ? :");
        num3 = keyboard.nextInt();

        max = num1;
        min = num1;
        if(max<num2){
            max = num2;
        }
        if(max<num3){
            max = num3;
        }
        if(min>num2){
            min = num2;
        }
        if(min>num3){
            min = num3;
        }

        System.out.println("Max : " + max);
        System.out.println("Min : " + min);

    }
}
