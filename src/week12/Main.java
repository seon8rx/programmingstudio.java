package week12;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();
        pStudio.j071();
    }

    public void displayHelp(){
        System.out.println("Usage of commands");
        System.out.println("1. Add a new item ( add )\n" +
                "2. Delete an existing item ( del)\n" +
                "3. Update an item ( edit )\n" +
                "4. List all items ( Is )\n" +
                "5. sort the list by name ( Is name )\n" +
                "6. sort the list by na,e descending ( Is name desc )\n" +
                "7. sor the list by date ( Is date )\n" +
                "8. sort the list by date descending ( Is date desc )\n" +
                "9. show command guidelines ( ? )\n" +
                "10. quit program ( exit )\n");

    }

    public void j071(){
        Scanner sc = new Scanner(System.in);
        TodoCRUD manager = new TodoCRUD();
        boolean quit = false;
        int check=0;
        do{
            System.out.print("> ");
            String line = sc.nextLine();
//            System.out.println(line);
            String choice = line.split(" ")[0];
//            System.out.println(choice);
            switch (choice){
                case "add":
                    check = manager.addItem();
                    if(check==1) System.out.println("Title can't be duplicated.");
                    break;

                case "del":
                    check = manager.deleteItem();
                    if(check==1) System.out.println("Not found.");
                    break;

                case "edit":
                    check = manager.updateItem();
                    if(check==1) System.out.println("Not found.");
                    break;

                case "ls":
                    if(line.contains("name"))
                        manager.sortByName();
                    if(line.contains("date"))
                        manager.sortByDate();
                    if(line.contains("desc"))
                        manager.reverseList();
                    manager.printItem();
                    break;

                case "?":
                    displayHelp();
                    break;

                case "exit":
                    quit = true;
                    break;

                default:
                    System.out.println("? for Help");
                    break;
            }
        }while(!quit);
    }
}
