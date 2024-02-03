package com.vikram.singh.springbootrestapis.endpoints;

import com.vikram.singh.springbootrestapis.dto.StudentDto;
import com.vikram.singh.springbootrestapis.exception.InvalidParametersException;
import com.vikram.singh.springbootrestapis.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/student", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class StudentEndpoint {

    private final StudentService studentService;

    public StudentEndpoint(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/student-id")
    public ResponseEntity<StudentDto> getStudent(@RequestParam int id) {
        if (id <= 0) throw new InvalidParametersException("Student id is invalid");

        var studentDto = this.studentService.getStudentById(id);
        return ResponseEntity
                .ok()
                .body(studentDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        var studentDtoList = this.studentService.getAllStudents();
        return ResponseEntity.ok(studentDtoList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateStudent(@PathVariable("id") int studentId, @Valid @RequestBody StudentDto studentDto) {
        if (studentId <= 0) throw new InvalidParametersException("Student id is invalid");

        boolean updateStatus = this.studentService.updateStudent(studentDto);
        return ResponseEntity.of(Optional.of(updateStatus));
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@Valid @RequestBody StudentDto studentDto) {
        this.studentService.addStudent(studentDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable int id) {
        if (id <= 0) throw new InvalidParametersException("Student id is invalid");

        boolean response = this.studentService.deleteStudent(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
