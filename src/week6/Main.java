package week6;

import java.util.Scanner;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();

        pStudio.J021();
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
    }
}
