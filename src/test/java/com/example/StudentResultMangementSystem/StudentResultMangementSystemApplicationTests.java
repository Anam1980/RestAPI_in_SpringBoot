package com.example.StudentResultMangementSystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StudentResultMangementSystemApplicationTests {

	@Autowired
	StudentService studentService;//as actual logic tests so we directly checked the service class

	@BeforeEach  //used to before execution then call
	public void prepare(){
		studentService.addStudent(new Student(2, "Dummy1", 26, "CSE"));
		studentService.addStudent(new Student(3, "Dummy2", 27, "EEE"));
		studentService.addStudent(new Student(4, "Dummy3", 28, "CSE"));
	}
	@Test
	public void addStudentTest(){
		Student student = new Student(1, "Dummy", 25, "CSE");
		studentService.addStudent(student);

		Student expectedOutput = new Student(1, "Dummy", 25, "CSE");
		Student actualOutput = studentService.getStudent(1);

		Assertions.assertEquals(expectedOutput.getRegNo(), actualOutput.getRegNo());
		Assertions.assertEquals(expectedOutput.getName(), actualOutput.getName());
		Assertions.assertEquals(expectedOutput.getAge(), actualOutput.getAge());
		Assertions.assertEquals(expectedOutput.getCourse(), actualOutput.getCourse());
	}
	@Test
	public  void  getStudentTest(){
		Student actualOutput = studentService.getStudent(2);
		Student expectedOutput = new Student(2, "Dummy1", 26, "CSE");

		Assertions.assertEquals(expectedOutput.getRegNo(), actualOutput.getRegNo());
		Assertions.assertEquals(expectedOutput.getName(), actualOutput.getName());
		Assertions.assertEquals(expectedOutput.getAge(), actualOutput.getAge());
		Assertions.assertEquals(expectedOutput.getCourse(), actualOutput.getCourse());
	}

	@Test
	void contextLoads() {
	}

}
