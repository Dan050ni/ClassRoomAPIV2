package com.example.APIClassRoom.services;

import com.example.APIClassRoom.models.SchoolClass;
import com.example.APIClassRoom.repositories.ISchoolClassRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchoolClassServices {

    @Autowired // Inyección de dependencia
    ISchoolClassRepositories repository;

    // Guardar
    public SchoolClass saveSchoolClass(SchoolClass dataSchoolClass) throws Exception {
        try {
            return this.repository.save(dataSchoolClass);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar
    public SchoolClass modifySchoolClass(String id, SchoolClass dataSchoolClass) throws Exception {
        try {
            Optional<SchoolClass> schoolClassSearch = this.repository.findById(id);

            if (schoolClassSearch.isPresent()) {
                SchoolClass schoolClassEntity = schoolClassSearch.get();
                schoolClassEntity.setName(dataSchoolClass.getName());
                return this.repository.save(schoolClassEntity);
            } else {
                throw new Exception("Clase no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public SchoolClass searchSchoolClassById(String id) throws Exception {
        try {
            Optional<SchoolClass> schoolClassSearch = this.repository.findById(id);
            if (schoolClassSearch.isPresent()) {
                return schoolClassSearch.get();
            } else {
                throw new Exception("Clase no encontrada");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todos
    public Iterable<SchoolClass> searchAllSchoolClasses() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar
    public String deleteSchoolClass(String id) throws Exception {
        try {
            Optional<SchoolClass> schoolClassSearch = this.repository.findById(id);
            if (schoolClassSearch.isPresent()) {
                this.repository.deleteById(id);
                return "Clase eliminada correctamente";
            } else {
                throw new Exception("Clase no encontrada para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
