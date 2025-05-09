package com.example.APIClassRoom.models;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    private int idStudent;

    @Column(nullable = true)
    private int Grade;

    @Column(name = "Birth_date", nullable = true)
    private String Birthdate;

    @Column(nullable = true, length = 255)
    private String Adress;



    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private User user;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Qualification> qualifications;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Attendance> attendances;

    @OneToMany(mappedBy = "student")
    @JsonManagedReference
    private List<Registration> registrations;


    public Student(){
    }

    public Student(int idStudent, String adress, String birthdate, int grade) {
        this.idStudent = idStudent;
        this.Adress = adress;
        this.Birthdate = birthdate;
        this.Grade = grade;
    }

    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getBirthdate() {
        return Birthdate;
    }

    public void setBirthdate(String birthdate) {
        Birthdate = birthdate;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

}
