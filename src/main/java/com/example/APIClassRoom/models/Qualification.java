package com.example.APIClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Qualifications")
public class Qualification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_qualification")
    private Integer idQualification;  // Cambié el tipo de String a Integer por convenciones estándar

    @Column(nullable = false)
    private Float note;  // Cambié "Note" a "note" para seguir la convención

    @Column(name = "evaluation_date", nullable = false)
    private String evaluationDate;  // Cambié "EvaluationDate" a "evaluationDate" para seguir la convención

    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id_student")
    @JsonBackReference
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "id_course")
    @JsonBackReference
    private Course course;

    public Qualification() {}

    public Qualification(Integer idQualification, Float note, String evaluationDate) {  // Cambié el tipo del id a Integer
        this.idQualification = idQualification;
        this.note = note;
        this.evaluationDate = evaluationDate;
    }

    public Integer getIdQualification() {
        return idQualification;
    }

    public void setIdQualification(Integer idQualification) {
        this.idQualification = idQualification;
    }

    public Float getNote() {
        return note;
    }

    public void setNote(Float note) {
        this.note = note;
    }

    public String getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(String evaluationDate) {
        this.evaluationDate = evaluationDate;
    }
}
