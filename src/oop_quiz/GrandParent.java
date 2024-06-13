package oop_quiz;

public class GrandParent extends Human{

    public GrandParent(String name, int age, int locationX, int locationY) {
        super(name, age, locationX, locationY);
    }

    @Override
    public String toString() {
        return "oop_quiz.GrandParent{" + super.toString() +
                " speed=" + getSpeed() +
                '}';
    }
}
