package com.placementmodule.Placement.Module.controller;

import com.placementmodule.Placement.Module.model.Student;
import com.placementmodule.Placement.Module.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class StudentController {
   @Autowired
    private StudentRepository studentRepository;

   @PostMapping("/student")
    Student newStudent(@RequestBody Student newStudent){
       return studentRepository.save(newStudent);
   }
   @GetMapping("/student")
    List<Student> getAllStudents(){
       return studentRepository.findAll();
   }

}
