package com.example.StudentResultMangementSystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RequestMapping("/srm") //specific endpoint for the application
//EntryPoint for API request

//@Scope("Prototype") // created new instance everytime when u request for that bean from spring container

@RestController  // this also contain @component
///restAPI make-> this annotation tells java compiler this is class in which i written API
//In this class i have written API
//whenever someone hit the API that request comes to this class
@Slf4j
public class StudentController {

    @Autowired //for dependency injection automatically
    StudentService studentservice;

    @Autowired
    StudentRepository studentRepository;

    public void StudentService(StudentService studentservice){
        this.studentservice=studentservice;
    }

    //GetMapping is the endpoint for API i.e. URL
    //API->Code + endpoint
    //This is the GET API

   // public Logger log = Logger.getLogger(String.valueOf(Student.class));

   @GetMapping("/get")
   public ResponseEntity getStudent(@RequestParam("regNo") int regNo){
       System.out.println("Repo Bean called in controller: "+studentRepository);
           Student student = studentservice.getStudent(regNo);

           //but what if no student of this regNo present in db
          if(student == null){
            return  new ResponseEntity("Id doesn't exist", HttpStatus.NOT_FOUND);
          }

          //we are able to return different returntype
           return new ResponseEntity(student, HttpStatus.FOUND);
   }
   //domainName/get?regNo=<regNo>

   //requestparam->Use to take variable as input in url
   //google.com(DomainName) /get(APIendpoint) ?(Via) regNo(RequestParameter) =5(value) & name=Anam

    @PostMapping("/add")
    public String addStudent(@RequestBody Student student){

        //log.info(String.valueOf(student));
        //log.trace("This is a TRACE log");//This not execute because the default level is INFO,
        // so we can only see the logs under info i.e
        //info, warn, and error, fatal

        //Now the level sets to trace
        log.trace("This is a TRACE log");
        log.debug("This is a DEBUG log");
        log.info("This is a INFO log");
        log.warn("This is a WARN log");//this print
        log.error("This is a ERROR log");
       studentservice.addStudent(student);
        return "Student successfully added";
    }

    @GetMapping("/getByPath/{regNo}")
    public Student getStudentUsingPathVariable(@PathVariable("regNo") int regNo){
       return studentservice.getStudentUsingPathVariable(regNo);
    }
    //domainName/getByPath/<regNo>

    //update the age
    //PUT API
    @PutMapping("/update_Age/{regNo}/{newAge}")
    public Student updateAge(@PathVariable("regNo") int regNo, @PathVariable("newAge") int newAge){
       return studentservice.updateAge(regNo, newAge);
    }

    //delete the student--requestparam
    //delete the student -- path variable
    //change the course of student -- both as request param
    //change course -- both as path variabble
    //change course -- one as req one as path
    //change course and age -- regno as requestParam and entire student object as request body

    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("regNo") int regNo){
      studentservice.deleteStudent(regNo);
       return "Student Deleted Successfully";
    }
    @DeleteMapping("/deleteByPath/{regNo}")
    public String deleteStudentByPath(@PathVariable("regNo") int regNo){
        studentservice.deleteByPath(regNo);
        return "Student Deleted Successfully";
    }


}
