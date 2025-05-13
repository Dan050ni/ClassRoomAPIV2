package com.example.APIClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Integer idCourse;

    @Column(length = 100, nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_class", referencedColumnName = "id_class")  // Relación con SchoolClass
    @JsonBackReference
    private SchoolClass schoolClass;  // Esta propiedad debería ser "schoolClass" para que coincida con el "mappedBy" en SchoolClass

    @ManyToOne
    @JoinColumn(name = "fk_teacher", referencedColumnName = "id_teacher")
    @JsonBackReference
    private Teacher teacher;

    // Eliminamos las siguientes líneas que hacen referencia a "Subject"
    // @OneToMany(mappedBy = "course")
    // @JsonManagedReference
    // private List<Subject> subjects;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Qualification> qualifications;

    @OneToMany(mappedBy = "course")
    @JsonManagedReference
    private List<Registration> registrations;

    public Course() {}

    public Course(Integer idCourse, String name) {
        this.idCourse = idCourse;
        this.name = name;
    }

    // Getters y Setters

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }
}
