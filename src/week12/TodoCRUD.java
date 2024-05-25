package week12;

import java.util.*;


public class TodoCRUD implements iCRUD {
    private ArrayList<TodoItem> list;

    public TodoCRUD() {
        this.list = new ArrayList<TodoItem>();
    }

    @Override
    public Object createItem() {
        return null;
    }

    @Override
    public int addItem() {
        String title, desc;
        Scanner sc = new Scanner(System.in);

        System.out.print("Add a Todo Item\n" + "Enter the title: ");

        title = sc.nextLine().trim();
        if (isDuplicated(title)) {
            return 1;
        }

        System.out.print("Enter the detail: ");
        desc = sc.nextLine().trim();

        TodoItem t = new TodoItem(title, desc);
        this.list.add(t);
        System.out.println("item added.");
        return 0;
    }

    @Override
    public int updateItem() {
        String titleToEdit;
        Scanner sc = new Scanner(System.in);
        System.out.println("Edit a Todo Item");
        System.out.print("Enter the title of of the item to edit: ");
        titleToEdit = sc.nextLine().trim();

        for (TodoItem item : this.list) {
            if (titleToEdit.equals(item.getTitle())) {
                System.out.println(item.toString());
                System.out.print("Enter the detail: ");
                String newDetail = sc.nextLine().trim();
                item.setDetail(newDetail);
                item.setReg_date(new Date()); // Update the registration date
                System.out.println("item updated.");
                return 0;
            }
        }
        return 1;
    }

    @Override
    public int deleteItem() {
        Scanner sc = new Scanner(System.in);
        String titleToRemove;
        System.out.println("Delete a Todo Item");
        System.out.print("Enter the title of the item to remove: ");
        titleToRemove = sc.nextLine().trim();

        for (TodoItem item : this.list) {
            if (titleToRemove.equals(item.getTitle())) {
                System.out.println(item.toString());
                this.list.remove(item);
                System.out.println("item deleted.");
                return 0;
            }
        }
        return 1;
    }

    boolean isDuplicated(String title) {
        for (TodoItem item : this.list) {
            if (title.equals(item.getTitle())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int printItem() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Total " + this.list.size() + " items");
        for (TodoItem item : this.list) {
            System.out.println(item.toString());
        }
        return 0;
    }

    public void sortByName() {
        Collections.sort(this.list, new TodoitemNameComparator());
    }

    public void sortByDate() {
        Collections.sort(this.list, new TodoitemDateComparator());
    }

    public void reverseList() {
        Collections.reverse(this.list);
    }
}

class TodoitemNameComparator implements Comparator<TodoItem> {
    @Override
    public int compare(TodoItem o1, TodoItem o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}

class TodoitemDateComparator implements Comparator<TodoItem>{
    @Override
    public int compare(TodoItem o1, TodoItem o2) {
        return o1.getReg_date().compareTo(o2.getReg_date());
    }
}