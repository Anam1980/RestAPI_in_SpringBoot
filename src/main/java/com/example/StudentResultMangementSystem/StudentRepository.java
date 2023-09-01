package com.example.StudentResultMangementSystem;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentRepository {


    public Object getStudentUsingPathVariable;
    Map<Integer, Student> db = new HashMap<>();

    public Student getStudent(int regNo) {
        return db.get(regNo);
    }

    public void addStudent(Student student) {
        db.put(student.getRegNo(), student);
    }

    public Student getStudentUsingPathVariable(int regNo) {
        return db.get(regNo);
    }

    public Student updateAge(int regNo, int newAge) {
        db.get(regNo).setAge(newAge);
        return  db.get(regNo);
    }

    public void deleteStudent(int regNo) {
        db.remove(regNo);
    }

    public void deleteByPath(int regNo) {
        db.remove(regNo);
    }
}
