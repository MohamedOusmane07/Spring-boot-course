package com.dadi.springbootcourse.student;

import com.dadi.springbootcourse.school.School;
import org.springframework.stereotype.Service;

@Service
public class StudentMapper {

    public Student fromStudentDto(StudentDto dto){
        if(dto == null){
            throw new NullPointerException("The Student DTO should not be null");
        }
        var student = new Student();
        student.setFirstname(dto.firstname());
        student.setLastname(dto.lastname());
        student.setEmail(dto.email());
        var school = new School();
        school.setId(dto.schoolId());
        student.setSchool(school);
        return student;
    }

    public StudentResponseDto fromStudent(Student student){

        return new StudentResponseDto(
                student.getFirstname(),
                student.getLastname(),
                student.getEmail()
        );
    }


}
