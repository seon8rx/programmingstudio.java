package week9;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();

//        pStudio.J041();
//        pStudio.J042();
//        pStudio.J043();
//        pStudio.J044();
//        pStudio.J045();
    }

    public void J041(){
        Lotto lotto = new Lotto();
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.println("================================================================================");
            System.out.println("Menu\np for print 6 random numbers, r for 6 different random numbers, any key for exit");
            String input = sc.next();
            if(input.equals("p")){
                lotto.printNumbers();
            }
            else if(input.equals("r")){
                lotto.remakeAuto();
                System.out.println(">>6 new random numbers have been generated.<<");
            }
            else break;
        }

        sc.close();
    }

    public void J042(){
        Lotto lotto = new Lotto();

        lotto.printNumbers();
        System.out.println("Enter 6 new random numbers you want from 1 to 45 (Each of the numbers must be distinct from one another).");
        lotto.remake();
        lotto.printNumbers();
    }

    public void J043(){
        Lotto lotto = new Lotto();

        lotto.printNumbers();
        System.out.println("Enter 6 new random numbers you want from 1 to 45 (Each of the numbers must be distinct from one another).");
        lotto.remake();
        if(lotto.checkLotto(lotto.getNumbers())==6) {
            System.out.println("당첨");
        }else{
            System.out.println("낙첨");
        }
    }

    public void J044(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the length of the password you want (must be integer).");
        int n = sc.nextInt();
        sc.close();
        MakePW mpw = new MakePW();
        mpw.make(n);
    }

    public void J045(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the length of the alphabet part of the code (must be integer).");
        int n1 = sc.nextInt();
        System.out.println("Please enter the length of the number part of the code (must be integer).");
        int n2 = sc.nextInt();
        sc.close();
        MakePW mpw = new MakePW();
        mpw.makeCode(n1, n2);
    }
}

class Lotto{
    private int[] numbers;

    public int[] getNumbers() {
        return numbers;
    }

    public Lotto(){
        numbers = new int[6];
        remakeAuto();
    }

    public void remakeAuto(){
        Random random = new Random();
        for(int i=0; i<numbers.length; i++){
            numbers[i] = random.nextInt(45) + 1;
            for(int j=0; j<i; j++){
                if(numbers[j] == numbers[i]){
                    i--;
                    break;
                }
            }
        }
    }

    public void remake(){
        Scanner scx = new Scanner(System.in);
        for(int i=0; i<numbers.length; i++){
            numbers[i] = scx.nextInt();
            if(numbers[i]>45 || numbers[i]<0){
                i--;
                System.out.println("the number has to be 1~45");
                continue;
            }
            for(int j=0; j<i; j++){
                if(numbers[j] == numbers[i]){
                    System.out.println("Each of the numbers must be distinct from one another.");
                    i--;
                    break;
                }
            }
        }
    }

    public int checkLotto(int[] check){
        Scanner scx = new Scanner(System.in);
        int[] lotteryThisWeek = new int[check.length];
        System.out.println("Please enter this week's Lotto numbers.");
        for(int i=0; i<lotteryThisWeek.length; i++){
            lotteryThisWeek[i] = scx.nextInt();
            if(lotteryThisWeek[i]>45 || lotteryThisWeek[i]<0){
                i--;
                System.out.println("the number has to be 1~45");
                continue;
            }
            for(int j=0; j<i; j++){
                if(lotteryThisWeek[j] == lotteryThisWeek[i]){
                    System.out.println("Each of the numbers must be distinct from one another.");
                    i--;
                    break;
                }
            }
        }
        int count=0;
        for(int i=0; i<lotteryThisWeek.length; i++){
            for(int j=0; j<check.length; j++){
                if(lotteryThisWeek[i] == check[j]) count++;
            }
        }
        return count;
    }

    public void printNumbers() {
        System.out.print(">> ");
        for(int x : numbers){
            System.out.print(x + " ");
        }
        System.out.println("<<");
    }
}

class MakePW{
    public MakePW(){};

    public void make(int num){
        int ASCIIMAX = 126;
        int ASCIIMIN = 33;
        Random random = new Random();
        System.out.print("new random password is \" ");
        for(int i=0; i<num; i++){
            int tmp = random.nextInt(ASCIIMAX-ASCIIMIN+1)+ASCIIMIN;
            if(tmp!=34 && tmp!=39 && tmp!= 40 && tmp!=41 && tmp!=42 && tmp!=43 && tmp!=44 && tmp!=45 && tmp!=46 && tmp!=47 && tmp!=58 && tmp!=59 && tmp!=91 && tmp!=92 && tmp!=93 && tmp!=95 && tmp!=96 && tmp!=123 && tmp!=124 && tmp!=125 && tmp!=126){
                System.out.print((char) tmp);
            }else{
                i--;
            }
        }
        System.out.println(" \"");
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
