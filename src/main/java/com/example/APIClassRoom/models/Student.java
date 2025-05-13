package com.example.APIClassRoom.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

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

    // Constructor vacío requerido por JPA
    public Student() {
    }

    // Constructor personalizado
    public Student(int idStudent, String adress, String birthdate, int grade) {
        this.idStudent = idStudent;
        this.Adress = adress;
        this.Birthdate = birthdate;
        this.Grade = grade;
    }

    // Getters y setters
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Qualification> getQualifications() {
        return qualifications;
    }

    public void setQualifications(List<Qualification> qualifications) {
        this.qualifications = qualifications;
    }

    public List<Attendance> getAttendances() {
        return attendances;
    }

    public void setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
    }

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }
}
