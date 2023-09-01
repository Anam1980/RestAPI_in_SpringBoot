package com.example.StudentResultMangementSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // it conatin @componenet which creates object of a class which is singleton in nature
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    public Student getStudent(int regNo) {
        // System.out.println("Repo Bean called in controller: "+studentRepository);
        Student student = studentRepository.getStudent(regNo);
        //student.setAge(200);
        return  student;
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public Student getStudentUsingPathVariable(int regNo) {
       return studentRepository.getStudentUsingPathVariable(regNo);
    }

    public Student updateAge(int regNo, int newAge) {
        return  studentRepository.updateAge(regNo, newAge);
    }

    public void deleteStudent(int regNo) {
        studentRepository.deleteStudent(regNo);
    }

    public void deleteByPath(int regNo) {
        studentRepository.deleteByPath(regNo);
    }
}
