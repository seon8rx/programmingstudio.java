package oop_quiz;

public class Child extends Human implements Swimmable{

    public Child(String name, int age, int locationX, int locationY) {
        super(name, age, locationX, locationY);
        setSpeed(5);
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
    public void swimToX(int direction) {
        setLocationX(getLocationX() + ((getSpeed()+1)*direction));
    }

    @Override
    public void swimToY(int direction) {
        setLocationY(getLocationY() + ((getSpeed()+1)*direction));
    }

    @Override
    public void swimTo(int x, int y) {
        setLocationX(x);
        setLocationY(y);
    }

    @Override
    public String toString() {
        return "oop_quiz.Child{" + super.toString() +
                " speed=" + getSpeed() +
                '}';
    }
}
