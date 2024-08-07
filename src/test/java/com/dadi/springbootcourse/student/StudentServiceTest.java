package com.dadi.springbootcourse.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {


    //which service we want to test
    @InjectMocks
    private StudentService studentService;

    //declare dependencies
    @Mock
    private StudentRepository studentRepository;
    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_student() {


        //Given

        StudentDto dto = new StudentDto(
                "Ousmane",
                "Mohamed",
                "aaaa@gmail.com",
                null);


        Student student = new Student(
                null,
                "Ousmane",
                "Mohamed",
                23,
                "aaaa@gmail.com",
                null,
                null
        );

        Student studentSaved = new Student(
                null,
                "Ousmane",
                "Mohamed",
                23,
                "aaaa@gmail.com",
                null,
                null
        );
        studentSaved.setId(1);


        //Mocks the call
        when(studentMapper.fromStudentDto(dto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(studentSaved);
        when(studentMapper.fromStudent(studentSaved)).thenReturn(new StudentResponseDto(

                "Ousmane",
                "Mohamed",
                "aaaa@gmail.com"
        ));


        //when


        StudentResponseDto responseDto = studentService.saveStudent(dto);


        //Then

        assertEquals(dto.firstname(),responseDto.firstname());
        assertEquals(dto.lastname(),responseDto.lastname());
        assertEquals(dto.email(),responseDto.email());

        verify(studentMapper, times(1)).fromStudentDto(dto);
        verify(studentRepository, times(1)).save(student);
        verify(studentMapper,times(1)).fromStudent(studentSaved);



    }

    @Test
    public void should_successfully_return_StudentResponseDto_List() {

        //Given

        List<Student> students = new ArrayList<>();
        students.add(new Student(null,
                "Ousmane",
                "Mohamed",
                23,
                "aaaa@gmail.com",
                null,
                null));

        students.add(new Student(null,
                "Ousmane",
                "Lamine",
                23,
                "aaa@gmail.com",
                null,
                null));

        List<StudentResponseDto> studentsResponseDto = new ArrayList<>();
        studentsResponseDto.add(new StudentResponseDto(
                "Ousmane",
                "Mohamed",
                "aaaa@gmail.com"
        ));

        studentsResponseDto.add(new StudentResponseDto(
                "Ousmane",
                "Lamine",
                "aaaa@gmail.com"
        ));
        //Mocks the call
        when(studentRepository.findAll()).thenReturn(students);
        for (int i = 0; i < students.size(); i++) {

            when(studentMapper.fromStudent(students.get(i))).thenReturn(studentsResponseDto.get(i));

        }
        //when(students.stream().map(studentMapper::fromStudent).collect(Collectors.toList())).thenReturn(studentsResponseDto);


        //When
        List<StudentResponseDto> studentResponseDtoList = studentService.getAllStudents();

        //Then

        assertEquals(studentsResponseDto.size(),studentResponseDtoList.size());
        for (int i = 0; i < studentsResponseDto.size(); i++) {
            assertEquals(studentsResponseDto.get(i).firstname(),studentResponseDtoList.get(i).firstname());
        }
        verify(studentRepository, times(1)).findAll();



    }

    @Test
    public void should_get_student_by_id() {

        int id = 1;
        //Given
        Student student = new Student(null,
                "Ousmane",
                "Lamine",
                23,
                "aaa@gmail.com",
                null,
                null);

        StudentResponseDto responseDto=new StudentResponseDto(
                "Ousmane",
                "Lamine",
                "aaaa@gmail.com"
        );

        //Mocks the call
        when(studentRepository.findById(id)).thenReturn(Optional.of(student));
        when(studentMapper.fromStudent(student)).thenReturn(responseDto);


        //When

        StudentResponseDto studentResponseDto=studentService.getStudentById(id);

        //Then

        assertEquals(responseDto.firstname(),studentResponseDto.firstname());
        assertEquals(responseDto.lastname(),studentResponseDto.lastname());
        assertEquals(responseDto.email(),studentResponseDto.email());

        verify(studentRepository, times(1)).findById(id);
        verify(studentMapper, times(1)).fromStudent(student);
    }



    @Test
    public void should_successfully_return_StudentResponseDto_List_By_Name() {

        //Given

        String name = "Ousmane";

        List<Student> students = new ArrayList<>();
        students.add(new Student(null,
                "Ousmane",
                "Mohamed",
                23,
                "aaaa@gmail.com",
                null,
                null));

        students.add(new Student(null,
                "Ousmane",
                "Lamine",
                23,
                "aaa@gmail.com",
                null,
                null));

        List<StudentResponseDto> studentsResponseDto = new ArrayList<>();
        studentsResponseDto.add(new StudentResponseDto(
                "Ousmane",
                "Mohamed",
                "aaaa@gmail.com"
        ));

        studentsResponseDto.add(new StudentResponseDto(
                "Ousmane",
                "Lamine",
                "aaaa@gmail.com"
        ));
        //Mocks the call
        when(studentRepository.findAllByFirstnameContaining(name)).thenReturn(students);
        for (int i = 0; i < students.size(); i++) {

            when(studentMapper.fromStudent(students.get(i))).thenReturn(studentsResponseDto.get(i));

        }
        //when(students.stream().map(studentMapper::fromStudent).collect(Collectors.toList())).thenReturn(studentsResponseDto);


        //When
        //List<StudentResponseDto>
        var studentResponseDtoList = studentService.getAllStudentsByName(name);

        //Then

        assertEquals(studentsResponseDto.size(),studentResponseDtoList.size());
        for (int i = 0; i < studentsResponseDto.size(); i++) {
            assertEquals(studentsResponseDto.get(i).firstname(),studentResponseDtoList.get(i).firstname());
        }
        verify(studentRepository, times(1)).findAllByFirstnameContaining(name);
        //verify(studentMapper,ti)



    }

    @Test
    public void should_delete_student_by_id() {

        //Given
        int id = 1;

        //Mocks the call

        //when
        studentService.deleteStudentById(id);

        //then

        verify(studentRepository, times(1)).deleteById(id);

    }


}