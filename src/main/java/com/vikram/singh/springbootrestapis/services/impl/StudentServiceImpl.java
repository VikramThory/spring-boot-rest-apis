package com.vikram.singh.springbootrestapis.services.impl;

import com.vikram.singh.springbootrestapis.converter.Converter;
import com.vikram.singh.springbootrestapis.dto.StudentDto;
import com.vikram.singh.springbootrestapis.repositories.StudentRepository;
import com.vikram.singh.springbootrestapis.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }


    @Override
    public StudentDto getStudentById(int id) {
        var studentEntity = this.studentRepository.getStudentById(id);
        return Converter.toStudentDto(studentEntity);
    }

    @Override
    public List<StudentDto> getAllStudents() {
        var studentEntityList = this.studentRepository.getAllStudents();
        return Converter.toStudentDtoList(studentEntityList);
    }

    @Override
    public boolean updateStudent(StudentDto studentDto) {
        return this.studentRepository.updateStudent(studentDto);
    }

    @Override
    public void addStudent(StudentDto studentDto) {
        this.studentRepository.addStudent();
    }

    @Override
    public boolean deleteStudent(int id) {
        return this.studentRepository.deleteStudent(id);
    }
}
