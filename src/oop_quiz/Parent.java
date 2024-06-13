package oop_quiz;

public class Parent extends Human implements Runnable{

    public Parent(String name, int age, int locationX, int locationY) {
        super(name, age, locationX, locationY);
        setSpeed(3);
    }

    @Override
    public void runToX(int direction) {
        setLocationX(getLocationX() + ((getSpeed()+2)*direction));
    }

    @Override
    public void runToY(int direction) {
        setLocationY(getLocationY() + ((getSpeed()+2)*direction));
    }

    @Override
    public String toString() {
        return  "oop_quiz.Parent{" + super.toString() +
                " speed=" + getSpeed() +
                '}';
    }
}