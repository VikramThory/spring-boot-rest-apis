package com.vikram.singh.springbootrestapis.converter;

import com.vikram.singh.springbootrestapis.datamodel.StudentEntity;
import com.vikram.singh.springbootrestapis.dto.StudentDto;

import java.util.List;

public class Converter {

    public static StudentDto toStudentDto(StudentEntity studentEntity) {
        return new StudentDto(studentEntity.name(), studentEntity.standard(), studentEntity.section());
    }

    public static StudentEntity toStudentEntity(StudentDto studentDto) {
        return new StudentEntity(0, studentDto.name(), studentDto.standard(), studentDto.section());
    }

    public static List<StudentDto> toStudentDtoList(List<StudentEntity> studentEntityList) {
        return studentEntityList
                .stream()
                .map(Converter::toStudentDto)
                .toList();
    }

}
