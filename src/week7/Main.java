package week7;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();

//        pStudio.J031();
//        pStudio.J032();
//        pStudio.J033();
//        pStudio.J034();
        pStudio.J035();
    }

    public void J031(){
        String userid;
        String password;
        String name;

        Scanner sc = new Scanner(System.in);
        userid = sc.next();
        password = sc.nextLine();
        password = sc.next();
        name = sc.nextLine();
        name = sc.nextLine();

        if(password.length()<3) {
            System.out.println("Error! password is too short.");
        }else{
            System.out.println("User ID: " + userid);
            System.out.print("Password: ");
            for(int i=0; i<password.length(); i++){
                if(i<=1) System.out.print(password.charAt(i));
                else System.out.print("*");
            }
            System.out.println();
            System.out.println("User Name: " + name);
        }

        sc.close();
    }

    public void J032(){
        String str;
        String reverse;

        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();

//        reverse = new StringBuilder(str).reverse().toString();

        char[] tmp = str.toCharArray();
        char[] rev = str.toCharArray();
        for(int i=0; i<str.length(); i++){
            rev[i] = tmp[str.length()-1-i];
        }
        reverse = new String(rev);

        System.out.println(reverse);

        sc.close();
    }

    public void J033(){
        int count;
        String name;
        String longest = null, shortest = null;

        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();
        sc.nextLine();

        for(int i=0; i<count; i++){
            name = sc.nextLine();
            if(i==0){
                longest = name;
                shortest = name;
            }else{
                if(name.length() > longest.length()) longest = name;
                if(name.length() < shortest.length()) shortest = name;
            }
        }

        System.out.println("Longest: " + longest);
        System.out.println("Shortest: " + shortest);

        sc.close();
    }

    public void J034(){
        String[] usernames = {"kim", "lee", "park", "hong", "choi"};
        String[] passwords = {"1111", "1234", "3456", "3535", "7777"};

        String usernameInput;
        String passwordsInput;

        Scanner sc = new Scanner(System.in);

        usernameInput = sc.next();
        sc.nextLine();
        passwordsInput = sc.next();

        int index=-1;

        for(int i=0; i<usernames.length; i++){
            if(usernames[i].equals(usernameInput)){
                index = i;
                break;
            }
        }

        if(index == -1){
            System.out.println("No user!");
        }else{
            if(passwords[index].equals(passwordsInput)){
                System.out.println("Login OK!");
            }else{
                System.out.println("Incorrect password!");
            }
        }

        sc.close();
    }

    public void J035(){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        int sum=0;

//        int tmp = Integer.parseInt(input);
//        sum += tmp%100;
//        tmp = tmp/100;
//        sum += tmp%100;
//        tmp = tmp/100;
//        for(int i=0; i<4; i++){
//            sum+=tmp%10;
//            tmp = tmp/10;
//        }

        int y = Integer.parseInt(input.substring(0,4));
        int m = Integer.parseInt(input.substring(4,6));
        int d = Integer.parseInt(input.substring(6,8));

        sum += m+d;
        for(int i=0; i<4; i++){
            sum += y%10;
            y = y/10;
        }


        System.out.println(sum);

        sc.close();

    }

//    public void practice(){
//        String userid;
//        String password;
//        String name;
//
//        Scanner sc = new Scanner(System.in);
//        int check=0;
//        while(true) {
//            userid = sc.nextLine();
//            for(int i=0; i<userid.length(); i++) {
//                if (!(userid.charAt(i) <= 122 && userid.charAt(i) >= 97) && !(userid.charAt(i)>=48&&userid.charAt(i)<=57)) {
//                    check = 1;
//                    System.out.println("userid error");
//                    break;
//                }else{
//                    check=0;
//                }
//            }
//            if(check==0) break;
//        }
//
//        while(true) {
//            password = sc.nextLine();
//            if(password.length()<3) {
//                System.out.println("Error! password is too short.");
//                break;
//            }
//            for(int i=0; i<password.length(); i++) {
//                if(!(password.charAt(i) <= 122 && password.charAt(i) >= 97) && !(password.charAt(i)>=48&&password.charAt(i)<=57) && !(password.charAt(i)>=65&&password.charAt(i)<=90) && (password.charAt(i)!='!') && (password.charAt(i)!='_') && (password.charAt(i)!='&')) {
//                    check = 1;
//                    System.out.println("password error");
//                    break;
//                }else{
//                    check=0;
//                }
//            }
//            if(check == 0) break;
//        }
//
//        name = sc.nextLine();
//
//
//            System.out.println("User ID: " + userid);
//            System.out.print("Password: ");
//            for(int i=0; i<password.length(); i++){
//                if(i%2==0) System.out.print("*");
//                else System.out.print(password.charAt(i));
//            }
//            System.out.println();
//            System.out.println("User Name: " + name);
//        }
}
