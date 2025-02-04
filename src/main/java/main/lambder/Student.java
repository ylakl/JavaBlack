package main.lambder;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String name;
    private int age;
    private Double grade;
    private String sex;
    private int course;
    public String toString(){
        return this.name + " " + this.age + " лет, пол(" + this.sex+ ") курс - "+ this.course + " средний балл - "+ this.grade;
    }
}
