package com.vikram.singh.springbootrestapis.datagenerator;

import com.vikram.singh.springbootrestapis.datamodel.StudentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DummyDataSource {

    private List<StudentEntity> studentEntityList;

    public DummyDataSource() {
        List<StudentEntity> studentEntities = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {
            studentEntities.add(new StudentEntity(i, "Student" + i, i, "A"));
        }

        this.studentEntityList = studentEntities;
    }

    public List<StudentEntity> studentEntityList() {
        return  this.studentEntityList;
    }

    public StudentEntity studentById(int id) {
        return  this.studentEntityList.stream().filter(e -> e.id() == id).toList().getFirst();
    }


}
