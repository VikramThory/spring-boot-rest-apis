package com.vikram.singh.springbootrestapis.repositories;

import com.vikram.singh.springbootrestapis.datamodel.StudentEntity;
import com.vikram.singh.springbootrestapis.dto.StudentDto;

import java.util.List;

public interface StudentRepository {
    StudentEntity getStudentById(int id);

    List<StudentEntity> getAllStudents();

    void addStudent();

    boolean updateStudent(StudentDto studentDto);

    boolean deleteStudent(int id);
}
