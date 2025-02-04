package main;

import java.util.Comparator;

public class Employe implements Comparable<Employe> {
    private int id;
    private String name;
    private String lastName;
    private int salary;

    public Employe(int id, String name, String lastName, int salary) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Employe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }


    @Override
    public int compareTo(Employe o) {
//        if(this.id == o.id){
//            return 0;
//        } else if( this.id < o.id){
//            return -1;
//        }else {
//            return 1;
//        }
        return this.id - o.id;
//        int res = this.name.compareTo(o.name);
//        if (res == 0){
//            res = this.lastName.compareTo(o.lastName);
//        };
//        return res;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}

