package com.vikram.singh.springbootrestapis.repositories.impl;

import com.vikram.singh.springbootrestapis.datagenerator.DummyDataSource;
import com.vikram.singh.springbootrestapis.datamodel.StudentEntity;
import com.vikram.singh.springbootrestapis.dto.StudentDto;
import com.vikram.singh.springbootrestapis.repositories.StudentRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Dummy data implementation can be replaced with JPA or JDBC implementation
 */
@Repository
public class StudentRepositoryImpl implements StudentRepository {

    private final DummyDataSource dataSource;

    public StudentRepositoryImpl(DummyDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public StudentEntity getStudentById(int id) {
        return this.dataSource.studentById(id);
    }

    @Override
    public List<StudentEntity> getAllStudents() {
        return this.dataSource.studentEntityList();
    }

    @Override
    public void addStudent() {

    }

    @Override
    public boolean updateStudent(StudentDto studentDto) {
        return false;
    }

    @Override
    public boolean deleteStudent(int id) {
        return false;
    }
}
