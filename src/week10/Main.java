package week10;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();

        pStudio.J052();
    }

    public void J051(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the length of the password you want (must be integer).");
        int n = sc.nextInt();
        System.out.println("How many passwords you want to make (must be integer).");
        int m = sc.nextInt();
        sc.close();
        MakePW mpw = new MakePW();
        mpw.make(n, m);
    }

    public void J052(){
        Scanner sc = new Scanner(System.in);
        System.out.print("How many students ? : ");
        int num = sc.nextInt();
        Score s = new Score(num);
        s.getScore();
        s.printScore();
        sc.close();
    }
}

class MakePW{
    public MakePW(){};

    public void make(int length){
        int ASCIIMAX = 126;
        int ASCIIMIN = 33;
        Random random = new Random();
        System.out.print("new random password is \" ");
        for(int i=0; i<length; i++){
            int tmp = random.nextInt(ASCIIMAX-ASCIIMIN+1)+ASCIIMIN;
            if(tmp!=34 && tmp!=39 && tmp!= 40 && tmp!=41 && tmp!=42 && tmp!=43 && tmp!=44 && tmp!=45 && tmp!=46 && tmp!=47 && tmp!=58 && tmp!=59 && tmp!=91 && tmp!=92 && tmp!=93 && tmp!=95 && tmp!=96 && tmp!=123 && tmp!=124 && tmp!=125 && tmp!=126){
                System.out.print((char) tmp);
            }else{
                i--;
            }
        }
        System.out.println(" \"");
    }

    public void make(int length, int num){
        int ASCIIMAX = 126;
        int ASCIIMIN = 33;
        Random random = new Random();
        if(num > 1) System.out.println("new random passwords are : ");
        else System.out.println("new random password is :");
        for(int n=0; n<num; n++){
            System.out.print("=> \" ");
            for(int i=0; i<length; i++){
                int tmp = random.nextInt(ASCIIMAX-ASCIIMIN+1)+ASCIIMIN;
                if(tmp!=34 && tmp!=39 && tmp!= 40 && tmp!=41 && tmp!=42 && tmp!=43 && tmp!=44 && tmp!=45 && tmp!=46 && tmp!=47 && tmp!=58 && tmp!=59 && tmp!=91 && tmp!=92 && tmp!=93 && tmp!=95 && tmp!=96 && tmp!=123 && tmp!=124 && tmp!=125 && tmp!=126){
                    System.out.print((char) tmp);
                }else{
                    i--;
                }
            }
            System.out.println(" \"");
        }
    }

    public void makeCode(int length1, int length2){
        Random random = new Random();
        char[] alphabet = new char[length1];
        int[] number = new int[length2];

        int tmp;
        for(int i=0; i<length1; i++){
            tmp = random.nextInt(2);
            switch (tmp){
                case 0:
                    alphabet[i] = (char)(random.nextInt(26)+65);
                    break;
                case 1:
                    alphabet[i] = (char)(random.nextInt(26)+97);
                    break;
            }
        }

        for(int i=0; i<length2; i++){
            if(i!=0) {
                number[i] = random.nextInt(9);
            }else{
                number[i] = random.nextInt(8)+1;
            }
        }

        System.out.print("Created Code is \" ");
        for(int i=0; i<length1; i++){
            System.out.print(alphabet[i]);
        }
        System.out.print('-');
        for(int i=0; i<length2; i++){
            System.out.print(number[i]);
        }
        System.out.println(" \"");
    }

}

class Score{
    int count;
    int[][] jumsu;
    int[] sum_student;
    double[] average_student;

    public Score(int count){
        this.count = count;
        jumsu = new int[count][3];
        sum_student = new int[count];
        average_student = new double[count];
    }

    public void getScore(){
        String[] subject = {"Korean", "Math", "English"};
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<count; i++){
            System.out.println("Student #" + (i+1));
            for(int j=0; j<jumsu[0].length; j++){
                System.out.print(subject[j] + " score (0~100) ? : ");
                jumsu[i][j] = sc.nextInt();
                sum_student[i]+=jumsu[i][j];
            }
            average_student[i] = sum_student[i] / 3.0;
        }
        sc.close();
    }
    public void printScore(){
        String[] subject = {"Korean", "Math", "English"};
        for(int i=0; i<count; i++){
            System.out.println("\nScore information for Student #" + (i+1));
            for(int j=0; j<jumsu[0].length; j++){
                System.out.print("=> ");
                System.out.print(subject[j] + " " + jumsu[i][j]);
                if(jumsu[i][j]>=95) System.out.println(" (A+)");
                else if(jumsu[i][j]>=90) System.out.println(" (A0)");
                else if(jumsu[i][j]>=85) System.out.println(" (B+)");
                else if(jumsu[i][j]>=80) System.out.println(" (B0)");
                else if(jumsu[i][j]>=75) System.out.println(" (C+)");
                else if(jumsu[i][j]>=70) System.out.println(" (C0)");
                else if(jumsu[i][j]>=65) System.out.println(" (D+)");
                else if(jumsu[i][j]>=60) System.out.println(" (D0)");
                else System.out.println(" (F)");
            }
            System.out.println("Total score : " + sum_student[i]);
            System.out.println("Average score : " + Math.round(average_student[i]*10.0)/10.0);
        }
    }

}