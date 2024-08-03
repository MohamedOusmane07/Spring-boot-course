package com.dadi.springbootcourse.student;

import com.dadi.springbootcourse.studentProfile.StudentProfile;
import com.dadi.springbootcourse.school.School;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor @AllArgsConstructor @Getter @Setter
@Table(name = "T_STUDENT")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "c_fname")
    private String firstname;
    private String lastname;
    @Column(length = 5)
    private Integer age;
    @Column(unique = true)
    private String email;
    @Column(updatable = false, insertable = false)
    private String some_Column;


    @OneToOne(mappedBy = "student",
    cascade = CascadeType.ALL)
    private StudentProfile studentProfile;

    @ManyToOne
    @JsonBackReference
    private School school;

}
