package com.dadi.springbootcourse.school;


import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }


    public SchoolDto saveSchool(SchoolDto schoolDto) {
        var school=schoolMapper.fromSchoolDto(schoolDto);
        return schoolMapper.fromSchool(schoolRepository.save(school));
    }


    public List<SchoolDto> getAllSchools() {
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::fromSchool)
                .collect(Collectors.toList());
    }


}
