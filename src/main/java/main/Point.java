package main;

/**
 * класс Точка
 **/
public class Point {
   private int x;
    private  int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {

        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Point() {
    }

    /**
     * Создает новую точку на растоянии от текущей
     * @param x
     * @param y
     * @return
     */
    public Point translat(int x, int y) {
        Point p = this;
        p.x = this.x + x;
        p.y = this.y + y;
        return p;

    }
    /**
     * Перемещает текущую точку
     * @param x
     * @param y
     * @return
     */
    public Point translatThis(int x, int y) {
        this.x = this.x + x;
        this.y = this.y + y;
        return this;

    }
}
