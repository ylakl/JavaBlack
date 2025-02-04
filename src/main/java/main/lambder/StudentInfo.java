package main.lambder;

import jdk.nashorn.internal.ir.debug.JSONWriter;
import jdk.nashorn.internal.parser.JSONParser;
import netscape.javascript.JSObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

//public class StudentInfo {
//    void testStudent(ArrayList<Student>list, StudentCheck sc){
//        for (Student s: list){
//            if(sc.check(s)){
//                System.out.println((s));
//            }
//        }
//    }
//}
public class StudentInfo {
    void testStudent(ArrayList<Student>list, Predicate<Student> sc){
        for (Student s: list){
            if(sc.test(s)){
                System.out.println((s));
            }
        }
    }


    void createStudent(Supplier<Student> sc){
        List<Student>students = new ArrayList<>();
        students.add(sc.get());
         System.out.println(students);

    }
    void changeStudent(Student student, Consumer<Student> sc){
         sc.accept(student);
        System.out.println(student);
    }
    void avgStudent(List<Student> student, Function<Student, Double> sc){
        Double so = 0d;
        for (Student s:student) {
            so = so + sc.apply(s);
        }

        System.out.println(so/student.size());
    }
}
class Test{
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", 25, 8.5,"m",2  );
        Student st2 = new Student("Petr", 30, 7.5,"m",4  );
        Student st3 = new Student("Masha", 35, 8.1,"f",5  );
        Student st4 = new Student("Kata", 19, 9.5,"f",1  );
        Student st5 = new Student("Yula", 28, 6.5,"f",3  );
        ArrayList students = new ArrayList();
        Collections.addAll(students,st1,st2,st3,st4,st5);
        StudentInfo studentInfo = new StudentInfo();
//        studentInfo.testStudent(students, new CheckOverGrade());
//        System.out.println("--------------------2");
//        studentInfo.testStudent(students, new StudentCheck() {
//            @Override
//            public boolean check(Student s) {
//                return  s.getAge()> 24;
//            }
//        });
        System.out.println("--------------------3");
        studentInfo.testStudent(students,  s -> s.getAge() > 29);
        System.out.println("--------------------4");
        Collections.sort(students, (Student s1,Student s2) -> s1.getCourse() - s2.getCourse() );
        System.out.println(students);
        System.out.println("--------------------5");
        studentInfo.testStudent(students,  s -> s.getGrade() > 8);
        System.out.println("--------------------6");
        Predicate<Student> predicate = s -> s.getGrade() > 8;
        Predicate<Student> predicate2 = s -> s.getAge() > 29;
        studentInfo.testStudent(students,  predicate.and(predicate2));
        System.out.println("--------------------7");
        studentInfo.testStudent(students,  predicate.or(predicate2));
        System.out.println("--------------------8");
        studentInfo.testStudent(students,  predicate.negate());
        System.out.println("--------------------9");
        studentInfo.createStudent(() -> new Student("Kola",30, 9.5,"m",3 ));
        System.out.println("--------------------10");
        System.out.println(students.get(0));
        studentInfo.changeStudent((Student) students.get(0),(Student s) -> s.setCourse(s.getCourse()+1));
        System.out.println("--------------------11");
        studentInfo.avgStudent(students, (student -> (double)student.getAge()));
        studentInfo.avgStudent(students, (student -> (double)student.getGrade()));
        studentInfo.avgStudent(students, (student -> (double)student.getCourse()));
    }
}
interface StudentCheck{
    boolean check(Student s);
}
class CheckOverGrade implements StudentCheck{

    @Override
    public boolean check(Student s) {
        return s.getGrade()>8;
    }
}