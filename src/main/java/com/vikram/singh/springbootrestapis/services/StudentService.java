package com.vikram.singh.springbootrestapis.services;

import com.vikram.singh.springbootrestapis.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto getStudentById(int id);

    List<StudentDto> getAllStudents();

    boolean updateStudent(StudentDto studentDto);

    void addStudent(StudentDto studentDto);

    boolean deleteStudent(int id);
}
