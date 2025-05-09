package com.example.APIClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class SchoolClass {

    @Id
    @Column(name = "id_class")
    private String idClass;

    @Column(length = 1000,nullable = false)
    private String Name;

    @OneToMany(mappedBy = "class")
    @JsonBackReference
    private List<Course> courses;
    public SchoolClass(){}

    public SchoolClass(String idClass, String name) {
        this.idClass = idClass;
        Name = name;
    }

    public String getIdClass() {
        return idClass;
    }

    public void setIdClass(String idClass) {
        this.idClass = idClass;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
