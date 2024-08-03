package com.dadi.springbootcourse.studentProfile;


import com.dadi.springbootcourse.student.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class StudentProfile {

    @Id
    @GeneratedValue
    private Integer id;
    private String bio;


    @OneToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
