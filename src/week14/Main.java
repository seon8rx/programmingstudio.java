package week14;

import java.io.*;

import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();
        pStudio.j091();
    }

    public void j091(){
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("./data091.txt"));
            ScoreManager scoreManager = new ScoreManager(bufferedReader);
            Scanner sc = new Scanner(System.in);
            int menu;
            String tmpName;
            while(true){
                System.out.print("1.점수통계출력, 2.학생검색 3.학생점수수정 4.종료 > ");
                menu = sc.nextInt();
                switch (menu){
                    case 1:
                        scoreManager.printSubjectInfo();
                        System.out.println("=================================");
                        scoreManager.printStudentsInfo();
                        System.out.println("=================================");
                        scoreManager.printTopStudentInfo();
                        break;
                    case 2:
                        sc.nextLine();
                        System.out.print("Name ? > (capitalization matters) ");
                        tmpName = sc.nextLine();
                        if(scoreManager.searchStudent(tmpName))
                            System.out.println("Student \"" + tmpName + "\" exists in the hashmap.");
                        else
                            System.out.println("Student \"" + tmpName + "\" does NOT exist in the hashmap.");
                        break;
                    case 3:
                        sc.nextLine();
                        System.out.print("Name ? > (capitalization matters) ");
                        tmpName = sc.nextLine();
                        scoreManager.changeStudentScore(tmpName);
                        break;
                    default:
                        break;
                }
                if(menu == 4) break;
                System.out.println();
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void j092(){
        ParkingLot parkinglot = new ParkingLot();
        Scanner sc = new Scanner(System.in);
        int menu;

        while(true){
            System.out.print("1) enter, 2) exit, 3) list, 4) quit > ");
            menu = sc.nextInt();

            switch (menu){
                case 1:
                    parkinglot.enter();
                    break;
                case 2:
                    parkinglot.exit();
                    break;
                case 3:
                    System.out.println("================================================");
                    System.out.println("num\t\ttype\t\ttime");
                    parkinglot.list();
                    break;
                default:
                    break;
            }

            if(menu == 4) break;
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

class ScoreManager{
//    static ArrayList<Score> array = new ArrayList<>();
    static HashMap<String, Score> hashmap = new HashMap<>();
    private int[] classSum = {0, 0, 0};
    private double[] classAvg = {0.0, 0.0, 0.0};
    private String[] subject = {"Kor", "Eng", "Math"};

    public ScoreManager(BufferedReader bf) throws IOException {
        String line;

        while((line = bf.readLine()) != null){
            Score student = new Score(line.split(" ")[0], Integer.parseInt(line.split(" ")[1]), Integer.parseInt(line.split(" ")[2]), Integer.parseInt(line.split(" ")[3]));

            classSum[0] += Integer.parseInt(line.split(" ")[1]);
            classSum[1] += Integer.parseInt(line.split(" ")[2]);
            classSum[2] += Integer.parseInt(line.split(" ")[3]);

            hashmap.put(student.getName(), student);
        }
    }

    public void printSubjectInfo(){
        for(int i=0; i<subject.length; i++){
            classAvg[i] = 1.0*classSum[i]/hashmap.size();
            System.out.println(subject[i] + ": 총점 - " + classSum[i] + ", 평균 - " + Math.round(classAvg[i]*10)/10.0);
        }
    }

    public void printStudentsInfo(){
        for (Map.Entry<String, Score> entry : hashmap.entrySet()) {
            System.out.println(entry.getKey() + ": 총점 - " + entry.getValue().getSum() + ", 평균 - " + Math.round(entry.getValue().getAverage()*10)/10.0);
        }
    }

    public void printTopStudentInfo(){
        String name = "";
        double topAvg = Double.MIN_VALUE;

        for (Map.Entry<String, Score> entry : hashmap.entrySet()) {
            if(topAvg < entry.getValue().getAverage()){
                name = entry.getKey();
                topAvg = entry.getValue().getAverage();
            }
        }
        System.out.print("가장 높은 평균 점수를 받은 학생: ");
        System.out.println(hashmap.get(name).toString());
    }

    public boolean searchStudent(String name){
        for(Map.Entry<String, Score> entry : hashmap.entrySet()){
            if(entry.getValue().getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public void changeStudentScore(String name){
        if(searchStudent(name)){
            Scanner sc = new Scanner(System.in);
            int tmp;
            int tmpSum = 0;

            classSum[0] -= hashmap.get(name).getKor();
            System.out.print("Kor ? > ");
            tmp = sc.nextInt();
            tmpSum += tmp;
            hashmap.get(name).setKor(tmp);
            classSum[0] += hashmap.get(name).getKor();

            classSum[1] -= hashmap.get(name).getEng();
            System.out.print("Eng ? > ");
            tmp = sc.nextInt();
            tmpSum += tmp;
            hashmap.get(name).setEng(tmp);
            classSum[1] += hashmap.get(name).getEng();

            classSum[2] -= hashmap.get(name).getMath();
            System.out.print("Math ? > ");
            tmp = sc.nextInt();
            tmpSum += tmp;
            hashmap.get(name).setMath(tmp);
            classSum[2] += hashmap.get(name).getMath();

            hashmap.get(name).setSum(tmpSum);
            hashmap.get(name).setAverage(tmpSum/3.0);
            for(int i=0; i<subject.length; i++){
                classAvg[i] = 1.0*classSum[i]/hashmap.size();
            }

            System.out.println("Score information for " + name + " is successfully changed.");
        }else{
            System.out.println("Student " + name + " does NOT exist in the hashmap.");
        }
    }
}

class ParkingInformation{
    private String carNumber;
    private String carType;
    private Date enterTime;

    ParkingInformation(String carNumber, String carType, Date enterTime){
        this.carNumber = carNumber;
        this.carType = carType;
        this.enterTime = enterTime;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public String getCarType() {
        return carType;
    }

    public Date getEnterTime() {
        return enterTime;
    }
}

class ParkingLot{
    private static HashMap<String, ParkingInformation> hashmap = new HashMap<>();
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd hhmm");

    public void enter(){
        Scanner sc = new Scanner(System.in);
        String carNumber = "";
        String carType = "";
        while(carNumber.length() != 4){
            System.out.print("Enter number, type > ");
            carNumber = sc.next();
            carType = sc.next();
            if(carNumber.length() != 4){
                System.out.println("Car Number has to be 4 digit in integer.");
            }
        }
        ParkingInformation newcar = new ParkingInformation(carNumber, carType, new Date());
        hashmap.put(carNumber, newcar);
    }

    public void exit(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter car number to exit > ");
        String carNumber = sc.next();

        Date exit = new Date();
        long parkingTime = exit.getTime() - hashmap.get(carNumber).getEnterTime().getTime();
        long minutes = parkingTime / (1000 * 60);
        long fee = (minutes/10)*500;

        System.out.println(carNumber + " " + hashmap.get(carNumber).getCarType() + " " + minutes + "min, "
                + "Parking fee " + fee + " (current time " + simpleDateFormat.format(exit) + ")");

        hashmap.remove(carNumber);
    }

    public void list(){
        int i = 1;
        for (Map.Entry<String, ParkingInformation> entry : hashmap.entrySet()) {
            System.out.println("[" + i + "]" + entry.getValue().getCarNumber() + "\t\t" + entry.getValue().getCarType()
                    + "\t\t" + simpleDateFormat.format(entry.getValue().getEnterTime()));
            i++;
        }
    }
}