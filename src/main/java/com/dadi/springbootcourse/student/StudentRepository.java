package com.dadi.springbootcourse.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student>  findAllByFirstnameContaining(String firstName);

}
