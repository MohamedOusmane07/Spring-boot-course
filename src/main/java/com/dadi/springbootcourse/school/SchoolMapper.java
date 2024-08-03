package com.dadi.springbootcourse.school;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;


@Service
public class SchoolMapper {

    public SchoolDto fromSchool(School school){
        return new SchoolDto(
                school.getName()
        );
    }


    public School fromSchoolDto(SchoolDto schoolDto){
        var school = new School();
        school.setName(schoolDto.name());
        return school;

    }
}
