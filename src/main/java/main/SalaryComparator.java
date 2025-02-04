package main;

import java.util.Comparator;

public class SalaryComparator implements Comparator<Employe> {
    @Override
    public int compare(Employe o1, Employe o2) {
        return o1.getSalary()- o2.getSalary();
    }
}
