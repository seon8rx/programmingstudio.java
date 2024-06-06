package week13;

import javax.annotation.processing.Filer;
import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();

        pStudio.j083();
    }
    public void j081(){
        try{
            FileInputStream fileinputstream = new FileInputStream("data081.txt");
            BufferedInputStream bufferedinputstream = new BufferedInputStream(fileinputstream);
            String data = "";
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int i;
            while((i= bufferedinputstream.read())!=-1){
                data += (char)i;
            }

            String[] input = data.split(" ");
            for(String x : input){
                int y=Integer.parseInt(x);
                if(y > max) max =  y;
                if(y < min) min = y;
            }
            System.out.println("Maximum number: " + max);
            System.out.println("Minimum number: " + min);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void j082(){
        try{
            File file = new File("data082.txt");
            Scanner sc = new Scanner(file);

            int i=0;
            int allcount=0;
            int ovwcount=0;

            while(sc.hasNextLine()){
                allcount++;
                String tmp = sc.nextLine();
                int h = Integer.parseInt(tmp.split(" ")[0]);
                int w = Integer.parseInt(tmp.split(" ")[1]);
                double bmi = 1.0*w/(Math.pow(h/100.0, 2));
                if(bmi>=25) ovwcount++;
            }
            int percent = 100*ovwcount/allcount;
            System.out.println("All " + allcount + " persons.");
            System.out.println("Total overweight persons: " + ovwcount + " (" + percent + "%)");
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void j083(){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("data083.txt"));
            String line;
            ArrayList<Score> array = new ArrayList<>();

            int[] classSum = {0, 0, 0};
            double[] classAvg = {0.0, 0.0, 0.0};

            while((line = bufferedReader.readLine()) != null){
                Score student = new Score(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]), Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]));

                classSum[0] += Integer.parseInt(line.split(" ")[1]);
                classSum[1] += Integer.parseInt(line.split(" ")[2]);
                classSum[2] += Integer.parseInt(line.split(" ")[3]);

                array.add(student);
            }
            String[] subject = {"Kor", "Eng", "Math"};
            for(int i=0; i<classSum.length; i++){
                classAvg[i] = 1.0*classSum[i]/array.size();
                System.out.println(subject[i] + ": 총점 - " + classSum[i] + ", 평균 - " + Math.round(classAvg[i]*10)/10.0);
            }
            System.out.println("=================================");

            int index = 0;
            double topAvg = Double.MIN_VALUE;
            for(Score s : array){
                System.out.println(s.getName() + ": 총점 - " + s.getSum() + ", 평균 - " + Math.round(s.getAverage()*10)/10.0);
                if(topAvg < s.getAverage()) {
                    index = array.indexOf(s);
                    topAvg = s.getAverage();
                }
            }
            System.out.println("=================================");
            System.out.print("가장 높은 평균 점수를 받은 학생: ");
            System.out.println(array.get(index));

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void j084(){
        try{
            File file = new File("data084.txt");
            Scanner sc = new Scanner(file);
            String line;
            int count=0;
            int longestCount = Integer.MIN_VALUE;
            int shortestCount = Integer.MAX_VALUE;
            String longest="", shortest="";
            while(sc.hasNext()){
                line = sc.nextLine();
                count++;
                if(line.length() > longestCount) {
                    longest = line;
                    longestCount = line.length();
                }
                else if(line.length() < shortestCount) {
                    shortest = line;
                    shortestCount = line.length();
                }
            }

            System.out.println("Count : " + count);
            System.out.println("Longest name : " + longest);
            System.out.println("Shortest name : " + shortest);

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void j085(){
        try{
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("data085.txt"));
            int[] count = {0, 0, 0};
            String data = "";
            int input;
            while((input = bufferedInputStream.read())!=-1){
                data += (char)input;
            }
            for(int i=0; i<data.length(); i++){
                char ch = data.charAt((i));
                if((int) ch >= 65 && (int) ch <= 90) count[0]++;
                else if((int) ch >= 97 && (int) ch <= 122) count[1]++;
                else if(ch == ' ') count[2]++;
            }

            System.out.println("A~Z - " + count[0]);
            System.out.println("a~z - " + count[1]);
            System.out.println("spaces - " + count[2]);

        }catch(Exception e){
            System.out.println(e);
        }
    }
}

class Score{
    private String name;
    private int kor, eng, math;
    private int sum;
    private double average;

    public Score(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
        sum = kor + eng + math;
        average = sum / 3.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    @Override
    public String toString() {
        return "{name='" + name + '\'' +
                ", kor=" + kor +
                ", eng=" + eng +
                ", math=" + math +
                ", sum=" + sum +
                ", average=" + Math.round(average*10)/10.0 +
                '}';
    }
}
