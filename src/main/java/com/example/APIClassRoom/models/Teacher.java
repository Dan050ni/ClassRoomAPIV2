package com.example.APIClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teacher")
    private int idTeacher;

    @Column(length = 100, nullable = false)
    private String specialism;

    @OneToMany(mappedBy = "teacher")
    @JsonManagedReference
    private List<Course> courses;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @JsonBackReference
    private User user;

    public Teacher() {}

    public Teacher(int idTeacher, String specialism) {
        this.idTeacher = idTeacher;
        this.specialism = specialism;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getSpecialism() {
        return specialism;
    }

    public void setSpecialism(String specialism) {
        this.specialism = specialism;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
