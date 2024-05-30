package com.ra.model.service;

import com.ra.model.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> findAll();
    Boolean saveOrUpdate (Student student);
    Boolean deleteById(Integer student_id);
}
