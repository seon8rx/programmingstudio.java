package week11;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main pStudio = new Main();
        pStudio.hashset();
    }

    public void hashset(){
        SetHashObject sh = new SetHashObject();
        sh.add("Number 1");
        sh.add("Number 2");
        sh.add("Number 2");
        sh.add("Number 3");
        System.out.println("Size ? > " + sh.size());
        System.out.print("now we have : ");
        for(int i=0; i<sh.size(); i++){
            System.out.print(sh.sethash[i]);
            if(i!=sh.size()-1) System.out.print(" ");
        }
        System.out.println();
        System.out.println("does is have \"Number 4\" ? > " + sh.contains("Number 4"));
        System.out.println("does is have \"Number 2\" ? > " + sh.contains("Number 2"));
        System.out.println("Remove \"Number 2\"");
        sh.remove("Number 2");
        System.out.print("now we have : ");
        for(int i=0; i<sh.size(); i++){
            System.out.print(sh.sethash[i]);
            if(i!=sh.size()-1) System.out.print(" ");
        }
        System.out.println("Cleared and added \"cleared\"");
        sh.clear();
        sh.add("cleared");
        System.out.print("now we have : ");
        for(int i=0; i<sh.size(); i++){
            System.out.print(sh.sethash[i]);
            if(i!=sh.size()-1) System.out.print(" ");
        }
        System.out.println();

    }

    public void j061(){
        int menu, quit=0;
        Scanner sc = new Scanner(System.in);
        WordCRUD manager = new WordCRUD();
        while(true){
            System.out.println("Menu> 1 Add 2 Edit 3 List 4 Delete 0 Exit");
            menu = sc.nextInt();
            switch(menu){
                case 1: manager.addWord(); break;
                case 2: manager.editWord(); break;
                case 3: manager.listWord(); break;
                case 4: manager.deleteWord(); break;
                default: quit = 1;
            }
            if(quit == 1) break;
        }
        sc.close();
    }

    public void j062(){
        int menu, quit=0;
        Scanner sc = new Scanner(System.in);
        BookCRUD manager = new BookCRUD();
        while(true){
            System.out.println("Menu> 1 Add 2 Edit 3 List 4 Delete 0 Exit");
            menu = sc.nextInt();
            switch(menu){
                case 1: manager.addBook(); break;
                case 2: manager.editBook(); break;
                case 3: manager.listBook(); break;
                case 4: manager.deleteBook(); break;
                default: quit = 1;
            }
            if(quit == 1) break;
        }
        sc.close();
    }

    public void j063(){
        int menu, quit=0;
        Scanner sc = new Scanner(System.in);
        TodoCRUD manager = new TodoCRUD();
        while(true){
            System.out.println("Menu> 1 Add 2 Edit 3 List 4 Delete 0 Exit");
            menu = sc.nextInt();
            switch(menu){
                case 1: manager.addTodo(); break;
                case 2: manager.editTodo(); break;
                case 3: manager.listTodo(); break;
                case 4: manager.deleteTodo(); break;
                default: quit = 1;
            }
            if(quit == 1) break;
        }
        sc.close();
    }
}



class Word{
    private String english;
    private String korean;
    private int level;

    Word(String en, String kor, int lev){
        english = en;
        korean = kor;
        this.level = lev;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getKorean() {
        return korean;
    }

    public void setKorean(String korean) {
        this.korean = korean;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Word{" +
                "english='" + english + '\'' +
                ", korean='" + korean + '\'' +
                ", level=" + level +
                '}';
    }
}

class WordCRUD{
    ArrayList<Word> list;

    public WordCRUD(){
        list = new ArrayList<Word>();
    }

    void addWord(){
        String english, korean;
        int level;
        Scanner sc = new Scanner(System.in);
        System.out.print("English > ");
        english = sc.next();
        sc.nextLine();
        System.out.print("Korean > ");
        korean = sc.nextLine();
        System.out.print("Level (1~3) > ");
        level = sc.nextInt();
        Word new_word = new Word(english, korean, level);
        list.add(new_word);
    }

    void editWord(){
        Scanner sc = new Scanner(System.in);

        boolean check = false;
        while(!check){
            System.out.print("Which english word are you looking for to edit its meaning ? > ");
            String input = sc.next();
            sc.nextLine();
            for(Word w : list){
                if(w.getEnglish().equalsIgnoreCase(input)){
                    System.out.print("New meaning of " + w.getEnglish() + " is > ");
                    String newMeaning = sc.next();
                    sc.nextLine();
                    w.setKorean(newMeaning);
                    check = true;
                    break;
                }
            }

            if(!check) System.out.println(input + " is not found.");
        }
    }

    void listWord(){
        for(int i=0; i<list.size(); i++){
            System.out.printf("%d - %s\n", i+1, list.get(i).toString());
        }
    }

    void deleteWord(){
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        while(true){
            System.out.print("Which english word do you want to delete ? > ");
            String input = sc.next();
            sc.nextLine();
            for(Word w : list){
                if(w.getEnglish().equalsIgnoreCase(input)){
                    list.remove(w);
                    System.out.println(input + " is deleted.");
                    check = true;
                    break;
                }
            }
            if(!check) System.out.println(input + " is not found.");
            else break;
        }
    }
}

class Book{
    private String bookName;
    private String author;
    private String category;
    private int price;
    private int publishedYear;

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book(String bookName, String author, String category, int price, int publishedYear) {
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.price = price;
        this.publishedYear = publishedYear;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public void setPublishedYear(int publishedYear) {
        this.publishedYear = publishedYear;
    }

    @Override
    public String toString() {
        if(author==null) {
            return "Book{" +
                    "bookName='" + bookName + '\'' +
                    '}';
        }
        return "Book{" +
                "bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", publishedYear=" + publishedYear +
                '}';
    }
}

class BookCRUD{
    ArrayList<Book> list;

    public BookCRUD(){
        list = new ArrayList<Book>();
    }

    void addBook(){
        Scanner sc = new Scanner(System.in);
        System.out.print("추가하고 싶은 도서명은 ? > ");
        String bookName = sc.nextLine();
        System.out.print("저자, 카테고리, 가격, 출간년도를 모두 알고있나요 ? (1: 네, 2: 아니요) > ");
        int check = sc.nextInt();
        while(!(check==1 || check==2)){
            System.out.print("(1: 네, 2: 아니요) > ");
            check = sc.nextInt();
        }
        if(check==2){
            Book newBook = new Book(bookName);
            list.add(newBook);
        }else if(check==1){
            sc.nextLine();
            System.out.print("저자의 이름은 ? > ");
            String author = sc.nextLine();
            System.out.print("카테고리는 ? > ");
            String category = sc.nextLine();
            System.out.print("가격은 ? > ");
            int price = sc.nextInt();
            System.out.print("출간년도는 ? > ");
            int publishedYear = sc.nextInt();
            Book newBook = new Book(bookName, author,category, price, publishedYear);
            list.add(newBook);
        }
    }

    void editBook(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("수정하고 싶은 도서의 도서명은 ? > ");
            String bname = sc.nextLine();
            boolean found = false;
            for(Book b : list){
                if(b.getBookName().equalsIgnoreCase(bname)){
                    while(true){
                        System.out.print("수정하고 싶은 내용은 ? (1:도서명, 2:저자, 3:카테고리, 4:가격, 5:출간년도) > ");
                        int selection = sc.nextInt();
                        sc.nextLine();
                        if(selection==1){
                            System.out.print(b.getBookName() + " --> " );
                            String newInfo = sc.nextLine();
                            b.setBookName(newInfo);
                        }else if(selection==2){
                            System.out.print(b.getAuthor() + " --> " );
                            String newInfo = sc.nextLine();
                            b.setAuthor(newInfo);
                        }else if(selection==3){
                            System.out.print(b.getCategory() + " --> " );
                            String newInfo = sc.nextLine();
                            b.setCategory(newInfo);
                        }else if(selection==4){
                            System.out.print("가격 : " + b.getPrice() + " --> " );
                            int newInfo = sc.nextInt();
                            b.setPrice(newInfo);
                        }else if(selection==5){
                            System.out.print("출간년도 : " + b.getPublishedYear() + " --> " );
                            int newInfo = sc.nextInt();
                            b.setPublishedYear(newInfo);
                        }else{
                            System.out.println("선택지에 없는 내용입니다.");
                        }

                        System.out.print("또 수정할 내용이 있나요 ? (1:네, 2:아니요) > ");
                        int again = sc.nextInt();
                        if(again!=1){
                            found = true;
                            break;
                        }

                    }
                }
                if(found) break;
            }
            if(found) break;
            else{
                System.out.println(bname + "가 목록에 없습니다..");
            }
        }
    }

    void listBook(){
        for(int i=0; i<list.size(); i++){
            System.out.printf("%d - %s\n", i+1, list.get(i).toString());
        }
    }

    void deleteBook(){
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        while(true){
            System.out.print("지우고 싶은 도서의 도서명은 ? > ");
            String input = sc.nextLine();
            for(Book w : list){
                if(w.getBookName().equalsIgnoreCase(input)){
                    list.remove(w);
                    System.out.println(input + "가 목록에서 제거되었습니다.");
                    check = true;
                    break;
                }
            }
            if(!check) System.out.println(input + "가 목록에 없습니다.");
            else break;
        }
    }
}

class Todo{
    private String title;
    private String content;
    private String deadline;
    private String category;

    public Todo(String title) {
        this.title = title;
    }

    public Todo(String title, String content, String deadline, String category) {
        this.title = title;
        this.content = content;
        this.deadline = deadline;
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        if(content == null){
            if(deadline == null && category == null){
                return "Todo{" +
                        "title='" + title + '\'' +
                        '}';
            }else if(deadline != null && category == null){
                return "Todo{" +
                        "title='" + title + '\'' +
                        ", deadline='" + deadline + '\'' +
                        '}';
            }else if(deadline == null && category != null){
                return "Todo{" +
                        "title='" + title + '\'' +
                        ", category='" + category + '\'' +
                        '}';
            }else{
                return "Todo{" +
                        "title='" + title + '\'' +
                        ", deadline='" + deadline + '\'' +
                        ", category='" + category + '\'' +
                        '}';
            }
        }else{
            if(deadline == null && category == null){
                return "Todo{" +
                        "title='" + title + '\'' +
                        ", content='" + content + '\'' +
                        '}';
            }else if(deadline != null && category == null){
                return "Todo{" +
                        "title='" + title + '\'' +
                        ", content='" + content + '\'' +
                        ", deadline='" + deadline + '\'' +
                        '}';
            }else if(deadline == null && category != null){
                return "Todo{" +
                        "title='" + title + '\'' +
                        ", content='" + content + '\'' +
                        ", category='" + category + '\'' +
                        '}';
            }else{
                return "Todo{" +
                        "title='" + title + '\'' +
                        ", content='" + content + '\'' +
                        ", deadline='" + deadline + '\'' +
                        ", category='" + category + '\'' +
                        '}';
            }
        }
    }
}

class TodoCRUD{
    ArrayList<Todo> list;

    public TodoCRUD(){
        list = new ArrayList<Todo>();
    }

    void addTodo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("추가하고 싶은 일정의 title ? > ");
        String title = sc.nextLine();
        System.out.print("일정의 내용, 마감일, 카테고리를 모두 추가하겠습니까 ? (1: 네, 2: 아니요) > ");
        int check = sc.nextInt();
        while(!(check==1 || check==2)){
            System.out.print("(1: 네, 2: 아니요) > ");
            check = sc.nextInt();
        }
        if(check==2){
            Todo newTodo = new Todo(title);
            list.add(newTodo);
        }else{
            sc.nextLine();
            System.out.print("일정의 내용은 ? > ");
            String content = sc.nextLine();
            System.out.print("일정의 마감일은 ? > ");
            String deadline = sc.nextLine();
            System.out.print("카테고리는 ? > ");
            String category = sc.nextLine();
            Todo newTodo = new Todo(title, content, deadline, category);
            list.add(newTodo);
        }
    }

    void editTodo(){
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("수정하고 싶은 일정의 title은 ? > ");
            String title = sc.nextLine();
            boolean found = false;
            for(Todo t : list){
                if(t.getTitle().equalsIgnoreCase(title)){
                    while(true){
                        System.out.print("수정하고 싶은 내용은 ? (1:제목, 2:내용, 3:마감일, 4:카테고리) > ");
                        int selection = sc.nextInt();
                        sc.nextLine();
                        if(selection==1){
                            System.out.print(t.getTitle() + " --> " );
                            String newInfo = sc.nextLine();
                            t.setTitle(newInfo);
                        }else if(selection==2){
                            System.out.print(t.getContent() + " --> " );
                            String newInfo = sc.nextLine();
                            t.setContent(newInfo);
                        }else if(selection==3){
                            System.out.print(t.getDeadline() + " --> " );
                            String newInfo = sc.nextLine();
                            t.setDeadline(newInfo);
                        }else if(selection==4){
                            System.out.print("가격 : " + t.getCategory() + " --> " );
                            String newInfo = sc.nextLine();
                            t.setCategory(newInfo);
                        }else{
                            System.out.println("선택지에 없는 내용입니다.");
                        }

                        System.out.print("또 수정할 내용이 있나요 ? (1:네, 2:아니요) > ");
                        int again = sc.nextInt();
                        if(again!=1){
                            found = true;
                            break;
                        }

                    }
                }
                if(found) break;
            }
            if(found) break;
            else{
                System.out.println(title + "가 목록에 없습니다..");
            }
        }
    }

    void listTodo(){
        for(int i=0; i<list.size(); i++){
            System.out.printf("%d - %s\n", i+1, list.get(i).toString());
        }
    }

    void deleteTodo(){
        Scanner sc = new Scanner(System.in);
        boolean check = false;
        while(true){
            System.out.print("지우고 싶은 일정의 제목은 ? > ");
            String input = sc.nextLine();
            for(Todo t : list){
                if(t.getTitle().equalsIgnoreCase(input)){
                    list.remove(t);
                    System.out.println(input + "가 목록에서 제거되었습니다.");
                    check = true;
                    break;
                }
            }
            if(!check) System.out.println(input + "가 목록에 없습니다.");
            else break;
        }
    }
}