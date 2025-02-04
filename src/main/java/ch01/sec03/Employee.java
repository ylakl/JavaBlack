package ch01.sec03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Employee implements Measurable {
    private double salary;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public double getMeasure() {
        return getSalary();
    }

    public Employee(double salary) {
        this.salary = salary;
    }

    public static double average(Measurable[] objects) {
        double measurable = 0;
        int count = 0;
        for (Measurable o : objects) {
            measurable = measurable + o.getMeasure();
            count = count + 1;
        }
        return measurable / count;

    }

    public Employee(double salary, String name) {
        this.salary = salary;
        this.name = name;
    }

    public static String Measurablelargest(Measurable[] objects) {
        Arrays.sort(objects, Comparator.comparing(Measurable::getMeasure));
        Employee employee = (Employee) objects[objects.length-1];
        return employee.getName();

    }
    public  static Employee[] sort (Employee[] employees) {
        Arrays.sort(employees, Comparator.comparing(Employee::getSalary).thenComparing(Employee::getName));
        return employees;
    }

}
