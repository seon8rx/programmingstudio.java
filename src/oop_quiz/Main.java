package oop_quiz;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GrandParent grandParent = new GrandParent("Alex Kim",72,0,0);
        Parent parent = new Parent("Josh Kim", 45,0,0);
        Child child = new Child("Ben Kim", 20,0,0);

        System.out.println(grandParent + "\n" + parent + "\n" + child + "\n");

        grandParent.setLocationX(1);
        grandParent.setLocationY(1);
        parent.setLocationX(1);
        parent.setLocationY(1);
        child.setLocationX(1);
        child.setLocationY(1);
        System.out.println("After set location (1,1) whom can walk");
        System.out.println(grandParent + "\n" + parent + "\n" + child + "\n");

        parent.setLocationX(2);
        parent.setLocationY(2);
        child.setLocationX(2);
        child.setLocationY(2);
        System.out.println("After set location (1,1) whom can run");
        System.out.println(grandParent + "\n" + parent + "\n" + child + "\n");

        child.setLocationX(3);
        child.setLocationY(-1);
        System.out.println("After set location (1,1) whom can swim");
        System.out.println(grandParent + "\n" + parent + "\n" + child + "\n");

        int menu, option, direction;
        while(true){
            System.out.print("Who do you want to move ? (1.oop_quiz.GrandParent, 2.oop_quiz.Parent, 3.oop_quiz.Child, AnyNumberToExit) >");
            menu = sc.nextInt();
            switch (menu){
                case 1:{
                    System.out.println("WALK");
                    System.out.print("For oop_quiz.GrandParent's direction X - move to right : 1, move to left : -1 > ");
                    direction = sc.nextInt();
                    if(direction == 1 || direction == -1) grandParent.walkToX(direction);
                    System.out.print("For oop_quiz.GrandParent's direction Y - move up : 1, move down : -1 > ");
                    direction = sc.nextInt();
                    if(direction == 1 || direction == -1) grandParent.walkToY(direction);
                    break;
                }
                case 2: {
                    System.out.print("Do you want to make oop_quiz.Parent run or walk ? (1.walk, 2.run) > ");
                    option = sc.nextInt();
                    if(option == 1){
                        System.out.println("WALK");
                        System.out.print("For oop_quiz.Parent's direction X - move to right : 1, move to left : -1 > ");
                        direction = sc.nextInt();
                        if(direction == 1 || direction == -1) parent.walkToX(direction);
                        System.out.print("For oop_quiz.Parent's direction Y - move up : 1, move down : -1 > ");
                        direction = sc.nextInt();
                        if(direction == 1 || direction == -1) parent.walkToY(direction);
                    }else if(option == 2){
                        System.out.println("RUN");
                        System.out.print("For oop_quiz.Parent's direction X - move to right : 1, move to left : -1 > ");
                        direction = sc.nextInt();
                        if(direction == 1 || direction == -1) parent.runToX(direction);
                        System.out.print("For oop_quiz.Parent's direction Y - move up : 1, move down : -1 > ");
                        direction = sc.nextInt();
                        if(direction == 1 || direction == -1) parent.runToY(direction);
                    }
                    break;
                }
                case 3: {
                    System.out.print("Do you want to make oop_quiz.Child run, walk, or swim ? (1.walk, 2.run, 3.swim) > ");
                    option = sc.nextInt();
                    if(option == 1){
                        System.out.println("WALK");
                        System.out.print("For oop_quiz.Child's direction X - move to right : 1, move to left : -1 > ");
                        direction = sc.nextInt();
                        if(direction == 1 || direction == -1) child.walkToX(direction);
                        System.out.print("For oop_quiz.Child's direction Y - move up : 1, move down : -1 > ");
                        direction = sc.nextInt();
                        if(direction == 1 || direction == -1) child.walkToY(direction);
                    }else if(option == 2){
                        System.out.println("RUN");
                        System.out.print("For oop_quiz.Child's direction X - move to right : 1, move to left : -1 > ");
                        direction = sc.nextInt();
                        if(direction == 1 || direction == -1) child.runToX(direction);
                        System.out.print("For oop_quiz.Child's direction Y - move up : 1, move down : -1 > ");
                        direction = sc.nextInt();
                        if(direction == 1 || direction == -1) child.runToY(direction);
                    }else if(option == 3){
                        int choice;
                        System.out.print("Do you want to make oop_quiz.Child swim to specific location ? (1.YES, 2.No, just swim) > ");
                        choice = sc.nextInt();
                        System.out.println("SWIM");
                        if(choice == 1){
                            int x, y;
                            System.out.print("Which Location for x ? > ");
                            x = sc.nextInt();
                            System.out.print("Which Location for y ? > ");
                            y = sc.nextInt();
                            child.swimTo(x,y);
                        }else if(choice == 2){
                            System.out.print("For oop_quiz.Child's direction X - move to right : 1, move to left : -1 > ");
                            direction = sc.nextInt();
                            if(direction == 1 || direction == -1) child.swimToX(direction);
                            System.out.print("For oop_quiz.Child's direction Y - move up : 1, move down : -1 > ");
                            direction = sc.nextInt();
                            if(direction == 1 || direction == -1) child.swimToY(direction);
                        }
                    }
                    break;
                }
                default:
                    break;
            }

            System.out.println("\n" + grandParent + "\n" + parent + "\n" + child + "\n");
            if(menu != 1 && menu != 2 && menu != 3) break;
        }
    }
}
