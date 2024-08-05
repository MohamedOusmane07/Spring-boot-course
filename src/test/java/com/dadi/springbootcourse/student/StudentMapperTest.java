package com.dadi.springbootcourse.student;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {

        StudentDto dto = new StudentDto(
                "Ousmane",
                "Mohamed",
                "aaa@gmail.com",
                1
        );

        Student student = studentMapper.fromStudentDto(dto);

        assertEquals(dto.firstname(), student.getFirstname());
        assertEquals(dto.lastname(), student.getLastname());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());


    }

    @Test
    public void should_throw_null_Pointer_Exception_when_studentDto_is_null(){
            var exp=assertThrows(NullPointerException.class,()->studentMapper.fromStudentDto(null));
            assertEquals("The Student DTO should not be null", exp.getMessage());


    }


    @Test
    public void shouldMapStudentToStudentDto() {

        Student student = new Student(null,"Ousmnane","Mohamed",1, "msdf.com",null,null);

        StudentResponseDto responseDto=studentMapper.fromStudent(student);

        assertEquals(responseDto.firstname(), student.getFirstname());
        assertEquals(responseDto.lastname(), student.getLastname());
        assertEquals(responseDto.email(), student.getEmail());


    }

}