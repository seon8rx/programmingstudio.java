package week6;

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();

//        pStudio.J021();
//        pStudio.J022();
//        pStudio.J023();
//        pStudio.J024();
//        pStudio.J025();
//        pStudio.J027();
//        pStudio.J029();
    }

    void J021(){
        int height, weight;
        double bmi;
        int people=0;
        int count;

        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();

        for(int i=0; i<count; i++){
            height = sc.nextInt();
            weight = sc.nextInt();

            bmi = weight / Math.pow(height/100.0, 2);
            if(bmi>=25){
                people++;
            }
        }

        System.out.println(people);

        sc.close();
    }

    void J022(){
        double m2_area;
        double pyung_area;
        int count1=0;
        int count2=0;
        int count3=0;
        int count4=0;

        int apartment = 10;

        Scanner sc = new Scanner(System.in);

        for(int i=0; i<apartment; i++){
            m2_area = sc.nextDouble();
            pyung_area = m2_area / 3.305;
            if(pyung_area>=50){
                count4++;
            }else if(pyung_area>=30){
                count3++;
            }else if(pyung_area>=15){
                count2++;
            }else{
                count1++;
            }
        }

        System.out.println("small - " + count1);
        System.out.println("normal - " + count2);
        System.out.println("large - " + count3);
        System.out.println("huge - " + count4);

        sc.close();
    }

    void J023(){
        int count;
        int number;
        int totalsum=0;
        double average;

        Scanner sc = new Scanner(System.in);
        count = sc.nextInt();

        for(int i=0; i<count; i++){
            number = sc.nextInt();
            totalsum += number;
        }
        average = 1.0*totalsum/count;
        System.out.println(totalsum + " " + average);

        sc.close();
    }

    void J024(){
        int[] numbers = new int[10];
        int first=0;
        int second=0;
        int second_max_index=0;
        int first_max_index=0;

        Scanner sc = new Scanner(System.in);
        for(int i=0; i<numbers.length; i++){
            numbers[i] = sc.nextInt();

            if(numbers[i] > first) {
                second = first;
                first = numbers[i];
                second_max_index = first_max_index;
                first_max_index = i+1;
            }else{
                if(numbers[i]>=second){
                    second = numbers[i];
                    second_max_index=i+1;
                }
            }
        }

        System.out.println("[" + second_max_index + "] " + second);
        sc.close();
    }

    void J025(){
        int[] monthdays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int month, day;
        int day_count = 0;

        Scanner sc = new Scanner(System.in);
        month = sc.nextInt();
        day = sc.nextInt();
        day_count+=day;

        if(month>12 || month <1 || day<1 || day>31){
            System.out.println("Wrong date!");
        }else if((month==4||month==6||month==9||month==11)&&day>30){
            System.out.println("Wrong date!");
        }else if(month==2 && day>28){
            System.out.println("Wrong date!");
        }else{
            for(int i=0; i<month-1; i++){
                day_count+=monthdays[i];
            }
            System.out.println(day_count);
        }

        sc.close();
    }

    void J027(){
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int[] height = new int[total];
        int[] weight = new int[total];
        double[] bmi = new double[total];
        int count=0;

        for(int i=0; i<total; i++){
            height[i] = sc.nextInt();
            weight[i] = sc.nextInt();
            bmi[i] = weight[i] / Math.pow(height[i]/100.0, 2);
            if(bmi[i]>=25) count++;
        }

        System.out.print("Overweight person -");
        for(int i=0; i<total; i++){
            if(bmi[i]>=25) {
                System.out.print(' ');
                System.out.print(i+1);
            }
        }
        System.out.println("\nTotal - " + count);

        sc.close();
    }

    void J029(){
        int[] number = new int[10];
        int count=0;

        Scanner sc = new Scanner(System.in);

        for(int i=0; i<10; i++){
            System.out.print("Enter #" + (i+1) + " number > ");
            number[i] = sc.nextInt();
            count++;
            if(i!=0) {
                for (int a = 0; a < i; a++) {
                    if (number[i] == number[a]) {
                        System.out.println("Duplicated! Retry.");
                        count--;
                        i--;
                        break;
                    }
                }
            }
        }
        System.out.print("Numbers -");
        for(int i=0; i<10; i++){
            System.out.print(" " + number[i]);;
        }
        sc.close();
    }
}
