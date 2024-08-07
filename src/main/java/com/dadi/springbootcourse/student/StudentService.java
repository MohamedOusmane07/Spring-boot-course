package com.dadi.springbootcourse.student;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }



    public StudentResponseDto saveStudent(StudentDto studentDto) {

        var student= studentMapper.fromStudentDto(studentDto);
        return studentMapper.fromStudent(studentRepository.save(student));

    }


    public StudentResponseDto getStudentById(Integer id) {
        return studentRepository.findById(id)
                .map(studentMapper::fromStudent)
                .orElse(null);

    }

    public List<StudentResponseDto> getAllStudentsByName(String name) {

        return studentRepository.findAllByFirstnameContaining(name)
                .stream()
                .map(studentMapper::fromStudent)
                .collect(Collectors.toList());
    }

    public List<StudentResponseDto> getAllStudents() {

       return studentRepository.findAll()
               .stream()
               .map(studentMapper::fromStudent)
               .collect(Collectors.toList());
    }

    public void deleteStudentById(Integer id) {

        studentRepository.deleteById(id);
    }

    public StudentResponseDto updateStudent(StudentDto studentDto) {
        var student= studentMapper.fromStudentDto(studentDto);
        return studentMapper.fromStudent(studentRepository.save(student));
    }
}
