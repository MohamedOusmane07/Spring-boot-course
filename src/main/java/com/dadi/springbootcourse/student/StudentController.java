package com.dadi.springbootcourse.student;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {


    private final StudentService studentService;


    public StudentController( StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/students")
    public StudentResponseDto saveStudent(
             @RequestBody StudentDto dto
    ){
       return this.studentService.saveStudent(dto);
     //  return studentService.saveStudent(dto);
    }


    @GetMapping("/students/{student-id}")
    public StudentResponseDto getStudentById(
            @PathVariable("student-id") Integer id){

            return this.studentService.getStudentById(id);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> getAllStudents(){

        return this.studentService.getAllStudents();
    }


    @GetMapping("/students/search/{firstname}")
    public List<StudentResponseDto> getAllStudentsByFirstname(

            @PathVariable("firstname") String kw
    ){

        return this.studentService.getAllStudentsByName(kw);
    }


    @DeleteMapping("/students/{student-id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudentById(
            @PathVariable("student-id") Integer id
    ){
       this.studentService.deleteStudentById(id);
    }




}




