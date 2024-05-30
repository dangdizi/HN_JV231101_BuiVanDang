package com.ra.model.entity;

import com.ra.util.FormatDate;

import javax.persistence.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Integer student_id;

    @Column(name = "student_name")
    private String student_name;

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "address")
    private String address;

    @Column(name = "image_url")
    private String image_url;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "birthday")
    private Date birthday;

    public Student() {
    }

    public Student(Integer student_id, String student_name, Boolean sex, String address, String image_url, String phone_number, Date birthday) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.sex = sex;
        this.address = address;
        this.image_url = image_url;
        this.phone_number = phone_number;
        this.birthday = birthday;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String formatBirthDay () {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(this.birthday);
    }

    @Override
    public String toString() {
        return "Student{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", sex=" + sex +
                ", address='" + address + '\'' +
                ", image_url='" + image_url + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
