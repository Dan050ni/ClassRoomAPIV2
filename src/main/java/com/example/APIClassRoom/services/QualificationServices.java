package com.example.APIClassRoom.services;

import com.example.APIClassRoom.models.Qualification;
import com.example.APIClassRoom.repositories.IQualificationRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class QualificationServices {

    @Autowired
    IQualificationRepositories repositories;

    // guardar
    public Qualification saveQualification(Qualification dataQualification) throws Exception {
        try {
            return this.repositories.save(dataQualification);
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    // modificar
    public Qualification modifyQualification(Integer id, Qualification dataQualification) throws Exception {
        try {
            Optional<Qualification> qualificationSearch = this.repositories.findById(id);

            if (qualificationSearch.isPresent()) {
                qualificationSearch.get().setNote(dataQualification.getNote());
                // Puedes modificar más campos aquí
                return this.repositories.save(qualificationSearch.get());
            } else {
                throw new Exception("calificación no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // buscar por id
    public Qualification searchQualificationById(Integer id) throws Exception {
        try {
            Optional<Qualification> qualificationSearch = this.repositories.findById(id);
            if (qualificationSearch.isPresent()) {
                return qualificationSearch.get();
            } else {
                throw new Exception("calificación no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // buscar todos
    public Iterable<Qualification> searchAllQualifications() throws Exception {
        try {
            return this.repositories.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // eliminar
    public String deleteQualification(Integer id) throws Exception {
        try {
            Optional<Qualification> qualificationSearch = this.repositories.findById(id);
            if (qualificationSearch.isPresent()) {
                this.repositories.deleteById(id);
                return "Calificación eliminada correctamente";
            } else {
                throw new Exception("calificación no encontrada para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
