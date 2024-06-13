package oop_quiz;

public interface Swimmable extends Runnable {
    void swimToX(int direction);
    void swimToY(int direction);
    void swimTo(int x, int y);
}
