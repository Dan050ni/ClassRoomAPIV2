package com.example.APIClassRoom.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Qualifications")
public class Qualification {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "id_qualification")
    private String idQualification;

    @Column (nullable = false)
    private Float Note;

    @Column (name = "evaluation_date",nullable = false)
    private String EvaluationDate;


    @ManyToOne
    @JoinColumn(name = "id_student", referencedColumnName = "id_student")
    @JsonBackReference
    private Student student;

    @ManyToOne
    @JoinColumn(name = "id_course", referencedColumnName = "id_course")
    @JsonBackReference
    private Course course;



    public Qualification(){}

    public Qualification(String idQualification, Float note, String evaluationDate) {
        this.idQualification = idQualification;
        Note = note;
        EvaluationDate = evaluationDate;
    }

    public String getIdQualification() {
        return idQualification;
    }

    public void setIdQualification(String idQualification) {
        this.idQualification = idQualification;
    }

    public Float getNote() {
        return Note;
    }

    public void setNote(Float note) {
        Note = note;
    }

    public String getEvaluationDate() {
        return EvaluationDate;
    }

    public void setEvaluationDate(String evaluationDate) {
        EvaluationDate = evaluationDate;
    }
}
