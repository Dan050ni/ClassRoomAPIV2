package com.example.APIClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import javax.security.auth.Subject;
import java.util.List;

@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Integer idCourse;

    @Column(length = 100,nullable = false)
    private String Name;

    @ManyToOne
    @JoinColumn(name = "id_class", referencedColumnName = "id_class")  // Relación con Class
    @JsonBackReference
    private SchoolClass classroom;  // Cambié el nombre de "class" a "classroom" para evitar conflictos con la palabra reservada


    @ManyToOne
    @JoinColumn(name = "fk_teacher",referencedColumnName = "id_tecaher")
    @JsonBackReference/*referencia del manytoone*/
            Teacher teacher;


    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Subject> subjects;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Qualification> qualifications;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Registration> registrations;

    public Course(){}

    public Course(Integer idCourse, String name) {
        this.idCourse = idCourse;
        Name = name;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(int idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
