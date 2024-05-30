package com.ra.model.dao;

import com.ra.model.entity.Student;

import java.util.List;

public interface StudentDao {
    List<Student> findAll();
    Boolean saveOrUpdate (Student student);
    Boolean deleteById(Integer student_id);
}
