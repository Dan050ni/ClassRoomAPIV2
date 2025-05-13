package com.example.APIClassRoom.models;

import com.example.APIClassRoom.helpers.UserType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 150, unique = true)
    private String email;

    @Column(length = 150, nullable = false)
    private String password;

    @Column(length = 20, nullable = true)
    private String phone;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Student student;

    @OneToOne(mappedBy = "user")
    @JsonBackReference
    private Teacher teacher;

    public User() {
    }

    public User(Integer id, String name, String email, String password, String phone, UserType userType) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.userType = userType;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
