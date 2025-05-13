package com.example.APIClassRoom.models;

import com.example.APIClassRoom.helpers.Status;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Attendances")
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_attendances")
    private Integer idAttendance;

    @Column(nullable = false)
    private String date;  // Cambié "Date" por "date" siguiendo la convención

    @Column(nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id_student")
    @JsonBackReference
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "id_course")
    @JsonBackReference
    private Course course;

    public Attendance() {
    }

    public Attendance(Integer idAttendance, String date, Status status) {
        this.idAttendance = idAttendance;
        this.date = date;
        this.status = status;
    }

    public Integer getIdAttendance() {
        return idAttendance;
    }

    public void setIdAttendance(Integer idAttendance) {
        this.idAttendance = idAttendance;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
