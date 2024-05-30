package com.ra.model.service;

import com.ra.model.dao.StudentDao;
import com.ra.model.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Boolean saveOrUpdate(Student student) {
        return studentDao.saveOrUpdate(student);
    }

    @Override
    public Boolean deleteById(Integer student_id) {
        return studentDao.deleteById(student_id);
    }
}
