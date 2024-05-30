package com.ra.controller;

import com.ra.model.entity.Student;
import com.ra.model.service.StudentService;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/student")
    public String index (Model model) {
        Student student = new Student();
        model.addAttribute("student", student);

        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return "student/index";
    }

    @PostMapping("/add")
    public String add (@ModelAttribute("student") Student student, @RequestParam("imageFile")MultipartFile file) {
        String fileName = file.getOriginalFilename();
        String path = "D:\\Rikkei Academy\\HN_JV231101_BuiVanDang\\src\\main\\webapp\\uploads";
        File image = new File(path + "/" + fileName);
        try {
            Files.write(image.toPath(), file.getBytes(), StandardOpenOption.CREATE);
            student.setImage_url(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        studentService.saveOrUpdate(student);
        return "redirect:/student";
    }

    @GetMapping("/student-delete")
    public String delete (@RequestParam("id") Integer student_id) {
        studentService.deleteById(student_id);
        return "redirect:/student";
    }

    @GetMapping("/student-edit")
    public String doEdit (Model model, @RequestParam("id") Integer student_id) {
        Student student = new Student();
        model.addAttribute("student", student);
        studentService.deleteById(student_id);
        return "student/edit";
    }
}
