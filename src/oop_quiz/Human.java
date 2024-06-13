package oop_quiz;

public class Human implements Walkable {
    private String name;
    private int age;
    private int locationX, locationY;
    private int speed = 1;

    public Human() {
        this.name = " - ";
        this.age = -1;
        this.locationX = 0;
        this.locationY = 0;
    }

    public Human(String name, int age, int locationX, int locationY) {
        this.name = name;
        this.age = age;
        this.locationX = locationX;
        this.locationY = locationY;
    }

    public void walkToX(int direction) {
        locationX += speed*direction;
    }

    public void walkToY(int direction) {
        locationY += speed*direction;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLocationX() {
        return locationX;
    }

    public void setLocationX(int locationX) {
        this.locationX = locationX;
    }

    public int getLocationY() {
        return locationY;
    }

    public void setLocationY(int locationY) {
        this.locationY = locationY;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", age=" + age +
                ", locationX=" + locationX +
                ", locationY=" + locationY;
    }
}
