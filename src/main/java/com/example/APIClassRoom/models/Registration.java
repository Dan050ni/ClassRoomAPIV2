package com.example.APIClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDateTime;  // Importado para manejar fechas correctamente

@Entity
@Table(name = "Registrations")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registration")
    private Integer idRegistration;

    @Column(name = "registration_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime registrationDate;  // Usé LocalDateTime para almacenar la fecha y hora correctamente

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id_student")
    @JsonBackReference
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "id_course")
    @JsonBackReference
    private Course course;

    public Registration() {}

    public Registration(Integer idRegistration, LocalDateTime registrationDate) {  // Cambié el tipo de fecha a LocalDateTime
        this.idRegistration = idRegistration;
        this.registrationDate = registrationDate;
    }

    public Integer getIdRegistration() {
        return idRegistration;
    }

    public void setIdRegistration(Integer idRegistration) {
        this.idRegistration = idRegistration;
    }

    public LocalDateTime getRegistrationDate() {  // Cambié el tipo a LocalDateTime
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {  // Cambié el tipo a LocalDateTime
        this.registrationDate = registrationDate;
    }

    // Métodos getter y setter para las relaciones con Student y Course
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
