package week15;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();
        pStudio.j101();
    }

    public void j101(){
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        int menu = 0;

        do {
            System.out.println("\n\t1. Create a book to the list \t\t 2. Read the list\n" +
                    "\t3. Update book info \t\t\t 4. Delete a book from the list\n" +
                    "\t5. Search a book from the list \t\t 6. Search the same type of Books\n" +
                    "\t7. Save the list to 'data.txt'\t\t 0. exit");
            System.out.print("\t >>> ");
            menu = sc.nextInt();
            switch (menu) {
                case 0:
                    break;
                case 1:
                    library.create();
                    break;
                case 2:
                    library.read();
                    break;
                case 3:
                    library.update();
                    break;
                case 4:
                    library.delete();
                    break;
                case 5:
                    System.out.print("\tTo Search - ");
                    Book toSearch = library.search();
                    if(toSearch != null){
                        System.out.println("\t" + toSearch.getIdNum() + " is found :\n" + toSearch);
                    }else{
                        System.out.println("\tCouldn't find the book from the list.");
                    }
                    break;
                case 6:
                    library.searchSameType();
                    break;
                case 7:
                    library.save();
                    break;
                default:
                    System.out.println("\t>> " + menu + " is not in the menu option <<");
                    break;
            }

        } while (menu != 0);
    }
}

class Book{
    private int idNum;
    private String title;
    private String author;
    private int type;
    private int numOfSameBook;

    public Book(int idNum, String title, String author, int type, int count){
        this.idNum = idNum;
        this.title = title;
        this.author = author;
        this.type = type;
        numOfSameBook = count;
    }

    public Book(int idNum, String title, String author, int type){
        this.idNum = idNum;
        this.title = title;
        this.author = author;
        this.type = type;
        numOfSameBook = 1;
    }

    public Book(int idNum, String title){
        this(idNum, title, null, 0);
    }

    public Book(int idNum, String title, String author){
        this(idNum,title, author, 0);
    }

    public Book(int idNum, String title, int type){
        this(idNum, title, null, type);
    }

    public int getIdNum() {
        return idNum;
    }

    public void setIdNum(int idNum) {
        this.idNum = idNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNumOfSameBook() {
        return numOfSameBook;
    }

    public void setNumOfSameBook() {
        this.numOfSameBook++;
    }

    public void setNumOfSameBook(int newCount) {
        this.numOfSameBook = newCount;
    }

    @Override
    public String toString() {
        if(author == null){
            return "\t<" + type + "> " + idNum + "-" + title + " - count: " + numOfSameBook;
        }

        return "\t<" + type + "> " + idNum + "-" + title + " by " + author + " - count: " + numOfSameBook;
    }
}

interface LibraryCRUD{
    void create();
    void read();
    void update();
    void delete();
    Book search();
    void searchSameType();
    void save();
}

class Library implements  LibraryCRUD{
    private List<Book> bookList;
    private static final String FILE = "data.txt";

    public Library() {
        this.bookList = new ArrayList<>();
        infoFromFile();
    }

    @Override
    public void create() {
        Scanner sc = new Scanner(System.in);
        int idNum; String title;
        boolean skip = false;

        System.out.print("\tID Number of the Book > ");
        idNum = sc.nextInt();
        sc.nextLine();
        System.out.print("\tTitle of the Book > ");
        title = sc.nextLine();

        for(Book b : bookList){
            if(b.getIdNum() == idNum){
                if(b.getTitle().equalsIgnoreCase(title)){
                    b.setNumOfSameBook();
                    System.out.println("\tThe number of book (\"" + title + "\") has been increased.");
                }else{
                    System.out.println("\tDifferent books MUST have different ID Number.");
                }
                skip = true;
                break;
            }
        }

        if(!skip){
            System.out.print("\tDo you want to add information of Author OR Type of the Book ?\n" +
                    "\t(0. None 1. Author info. 2. Type of the Book 3. Both) > ");
            int additional;
            additional = sc.nextInt();
            sc.nextLine();

            if(additional == 0){
                bookList.add(new Book(idNum, title));
            }else{
                String author; int type;
                if(additional == 1){
                    System.out.print("\tName of the Author > ");
                    author = sc.nextLine();
                    bookList.add(new Book(idNum, title, author));
                }else if(additional == 2){
                    System.out.print("\tType of the Book > ");
                    type = sc.nextInt();
                    bookList.add(new Book(idNum, title, type));
                }else if(additional == 3){
                    System.out.print("\tName of the Author > ");
                    author = sc.nextLine();
                    System.out.print("\tType of the Book > ");
                    type = sc.nextInt();
                    bookList.add(new Book(idNum, title, author, type));
                }
            }
            System.out.println("\t\"" + title + "\" is added to the list.");
        }

    }

    @Override
    public void read() {
        if(bookList.isEmpty()){
            System.out.println("\tNothing is in the list.");
            return;
        }
        for(Book b : bookList){
            System.out.println(b);
        }
    }

    @Override
    public void update() {
        System.out.print("\tTo Update - ");
        Book toUpdate = search();
        Scanner sc = new Scanner(System.in);
        int choice = 1;
        int idNumCheck = 0;

        if(toUpdate == null){
            System.out.println("\tCouldn't find the book from the list.");
            return;
        }

        while(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5){
            System.out.print("\tWhich information do you want to update ?\n" +
                    "\t1.  ID Number, 2. Title, 3. Author, 4. Type of the book 5. Count 0. Done > ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    int idNum;
                    System.out.print("\tID Number of the Book > ");
                    idNum = sc.nextInt();
                    for(Book b : bookList){
                        if(b.getIdNum() == idNum){
                            System.out.println("\tThe ID Number already exist.");
                            idNumCheck = 1;
                            break;
                        }
                    }

                    if(idNumCheck == 1)
                        idNumCheck = 0;
                    else
                        toUpdate.setIdNum(idNum);

                    break;
                case 2:
                    String title;
                    System.out.print("\tTitle of the Book > ");
                    title = sc.nextLine();
                    toUpdate.setTitle(title);
                    break;
                case 3:
                    String author;
                    System.out.print("\tName of the Author > ");
                    author = sc.nextLine();
                    toUpdate.setAuthor(author);
                    break;
                case 4:
                    int type;
                    System.out.print("\tType of the Book > ");
                    type = sc.nextInt();
                    toUpdate.setType(type);
                    break;
                case 5:
                    int newCount;
                    System.out.print("\tThe number of the Book > ");
                    newCount = sc.nextInt();
                    toUpdate.setNumOfSameBook(newCount);
                    break;
                default:
                    break;
            }
            if(choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5)
                System.out.println("\tCompletely updated.\n");
        }
    }

    @Override
    public void delete() {
        System.out.print("\tTo Delete - ");
        Book toDelete = search();
        if(toDelete != null) {
            System.out.println("\t" + toDelete.getTitle() + " is delete from the list.");
            bookList.remove(toDelete);
        }
        else System.out.println("\tCouldn't find the book from the list.");
    }

    @Override
    public Book search() {
        Scanner sc = new Scanner(System.in);
        int idNumToSearch;
        System.out.print("ID Number of the book > ");
        idNumToSearch = sc.nextInt();
        for(Book b : bookList){
            if(b.getIdNum() == idNumToSearch){
                return b;
            }
        }
        return null;
    }

    @Override
    public void searchSameType() {
        Scanner sc = new Scanner(System.in);
        int typeToSearch;
        int count = 0;
        System.out.print("\tType of the book > ");
        typeToSearch = sc.nextInt();
        for(Book b : bookList){
            if(b.getType() == typeToSearch){
                System.out.println(b);
                count++;
            }
        }
        if(count == 0) System.out.println("\tCouldn't find the book from the list.");
    }

    @Override
    public void save() {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE))) {
            for (Book book : bookList) {
                bufferedWriter.write(book.getIdNum() + "-" + book.getTitle() + "-" + book.getAuthor() + "-" + book.getType() + "-" + book.getNumOfSameBook());
                bufferedWriter.newLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\tSaved to " + FILE);
    }

    private void infoFromFile(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] info = line.split("-");
                if (info.length == 5) {
                    bookList.add(new Book(Integer.parseInt(info[0]), info[1], info[2], Integer.parseInt(info[3]), Integer.parseInt(info[4])));
                }
            }
            System.out.println("\tList is updated.");
        } catch (FileNotFoundException e) {
            System.out.println("\tNothing is in the list.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}