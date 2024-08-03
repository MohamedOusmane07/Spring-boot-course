package com.dadi.springbootcourse.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "FisrtName must not empty")
         String firstname,
        @NotEmpty
        String lastname,
         String email,
        Integer schoolId
) {
}
