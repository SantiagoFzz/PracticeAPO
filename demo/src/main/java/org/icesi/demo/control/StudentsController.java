package org.icesi.demo.control;

import org.icesi.demo.model.Student;

import java.util.ArrayList;

public class StudentsController {

    private ArrayList<Student> students;

    public StudentsController() {
        this.students = new ArrayList<>();
    }

    public void addStudent(String name, String code){
        Student student = new Student(name, code);
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public String printStudents(){
        String msj = "";
        for(Student student : students){
            msj += student.getName() + ", " + student.getCode() + "\n";
        }

        return msj;

    }
}
