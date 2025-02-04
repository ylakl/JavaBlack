package ch01.sec03;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary) {
        super( salary, name);
        bonus = 500;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getSalary() { // Overrides superclass method
        return super.getSalary() + bonus;
    }
}
