package week10;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();

        pStudio.J055();
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

    public void J053(){
        Scanner sc = new Scanner(System.in);
        System.out.print("How many students ? : ");
        int num = sc.nextInt();
        Score s = new Score(num);
        s.getScore();
        System.out.println("Which student's information do you need? : 1 - " + num);
        int n;
        while(true){
            n = sc.nextInt();
            if(n>=1 && n<=num) break;
            else System.out.println("range 1 - " + num);
        }
        s.printScore(n);
        sc.close();
    }

    public void J054(){
        Scanner sc = new Scanner(System.in);
        System.out.print("How many students ? : ");
        int num = sc.nextInt();
        Score s = new Score(num);
        s.getScore();
        System.out.println("Which student's information do you need? : 1 - " + num);
        int n;
        while(true){
            n = sc.nextInt();
            if(n>=1 && n<=num) break;
            else System.out.println("range 1 - " + num);
        }
        System.out.println("Which subject's score information do you need? (Korean, Math, English) : ");
        String input;
        input = sc.next();

        s.printScore(n, input);
        sc.close();
    }

    public void J055(){
        BMICalculator bmiCal = new BMICalculator();
        bmiCal.getHW();
        bmiCal.printBMI();
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

    int[] sum_class;
    double[] average_class;

    public Score(int count){
        this.count = count;
        jumsu = new int[count][3];
        sum_student = new int[count];
        average_student = new double[count];
        sum_class = new int[count];
        average_class = new double[count];
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

        for(int a=0; a<count; a++){
            for(int b=0; b<subject.length; b++){
                if(b==0){
                    sum_class[0]+=jumsu[a][b];
                }else if(b==1){
                    sum_class[1]+=jumsu[a][b];
                }else if(b==2){
                    sum_class[2]+=jumsu[a][b];
                }
            }
        }

        for(int i=0; i<average_class.length; i++){
            average_class[i] = sum_class[i]/3.0;
        }

    }
    public void printScore(){
        String[] subject = {"Korean", "Math", "English"};

        System.out.println();

        for(int i=0; i<subject.length; i++){
            System.out.println(">> Total score of " + subject[i] + " : " + sum_class[i]);
            System.out.println(">> Average score of " + subject[i] + " : " + Math.round(average_class[i]*10.0)/10.0);
        }

        for(int i=0; i<count; i++){
            System.out.println("\nScore information for Student #" + (i+1));
            for(int j=0; j<jumsu[0].length; j++){
                System.out.print("=> ");
                System.out.println(subject[j] + " " + jumsu[i][j]);
            }
            System.out.println("Total score : " + sum_student[i]);
            System.out.print("Average score : " + Math.round(average_student[i]*10.0)/10.0);
            if(average_student[i]>=90) System.out.println(" (A)");
            else if(average_student[i]>=80) System.out.println(" (B)");
            else if(average_student[i]>=70) System.out.println(" (C)");
            else if(average_student[i]>=60) System.out.println(" (D)");
            else System.out.println(" (F)");
        }
    }

    public void printScore(int num){
        String[] subject = {"Korean", "Math", "English"};
        System.out.println("\nScore information for Student #" + num);
        for(int j=0; j<jumsu[0].length; j++){
            System.out.print("=> ");
            System.out.println(subject[j] + " " + jumsu[num-1][j]);
        }
        System.out.println("Total score : " + sum_student[num-1]);
        System.out.print("Average score : " + Math.round(average_student[num-1]*10.0)/10.0);
        if(average_student[num-1]>=90) System.out.println(" (A)");
        else if(average_student[num-1]>=80) System.out.println(" (B)");
        else if(average_student[num-1]>=70) System.out.println(" (C)");
        else if(average_student[num-1]>=60) System.out.println(" (D)");
        else System.out.println(" (F)");
    }

    public void printScore(int num, String classname){
        String[] subject = {"Korean", "Math", "English"};
        System.out.println("\nScore information for Student #" + num);
        for(int j=0; j<jumsu[0].length; j++){
            System.out.print("=> ");
            System.out.println(subject[j] + " " + jumsu[num-1][j]);
        }
        System.out.println("Total score : " + sum_student[num-1]);
        System.out.print("Average score : " + Math.round(average_student[num-1]*10.0)/10.0);
        if(average_student[num-1]>=90) System.out.println(" (A)");
        else if(average_student[num-1]>=80) System.out.println(" (B)");
        else if(average_student[num-1]>=70) System.out.println(" (C)");
        else if(average_student[num-1]>=60) System.out.println(" (D)");
        else System.out.println(" (F)");

        for(int i=0; i<subject.length; i++){
            if(subject[i].equals(classname)){
                System.out.println(">> Total score of " + subject[i] + " : " + sum_class[i]);
                System.out.println(">> Average score of " + subject[i] + " : " + Math.round(average_class[i]*10.0)/10.0);
            }
        }
    }

}

class BMICalculator{
    int height, weight;
    double bmi;
    int level;
    String name;

    public BMICalculator(){

    }

    public void getHW(){
        Scanner sc = new Scanner(System.in);
        System.out.print("> Name? : ");
        name = sc.next();
        System.out.print("> Height? (cm) : ");
        height = sc.nextInt();
        System.out.print("> Weight? (kg) : ");
        weight = sc.nextInt();
    }

    public void printBMI(){
        bmi = weight/Math.pow(height/100.0, 2);
        if(bmi<18.5) level=1;
        else if(bmi<25) level=2;
        else if(bmi<30) level=3;
        else level=4;

        if(level==1){
            System.out.println(name + ": " + "BMI - " + Math.round(bmi*100.0)/100.0 + ", BMI level - " + level + ", Underweight.");
        }else if(level==2){
            System.out.println(name + ": " + "BMI - " + Math.round(bmi*100.0)/100.0 + ", BMI level - " + level + ", Healthy Weight.");
        }else if(level==3){
            System.out.println(name + ": " + "BMI - " + Math.round(bmi*100.0)/100.0 + ", BMI level - " + level + ", Overweight.");
        }else{
            System.out.println(name + ": " + "BMI - " + Math.round(bmi*100.0)/100.0 + ", BMI level - " + level + ", Obesity.");
        }
    }
}