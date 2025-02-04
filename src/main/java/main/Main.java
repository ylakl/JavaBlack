package main;

import ch01.sec03.Employee;
import ch01.sec03.Greeter;
import ch01.sec03.Manager;

import java.io.File;
import javax.imageio.stream.ImageOutputStream;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Employe> list = new ArrayList<>();
        Employe emp = new Employe(45, "Маша", "Петрова", 2000);
        Employe emp1 = new Employe(35, "Маша", "Астафьева", 3000);
        Employe emp2 = new Employe(95, "Коля", "Петрова", 1000);
        list.add(emp);
        list.add(emp1);
        list.add(emp2);
        System.out.println("Перед");
        System.out.println(list);
        Collections.sort(list, new SalaryComparator());
        System.out.println("После");
        System.out.println(list);
    }
}







