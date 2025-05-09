package com.example.APIClassRoom.services;

import com.example.APIClassRoom.models.Registration;
import com.example.APIClassRoom.repositories.IRegistrationRepositories; // <-- si luego quieres cambiar a singular, mejor
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationServices {

    @Autowired
    IRegistrationRepositories repository;

    // Guardar
    public Registration saveRegistration(Registration dataRegistration) throws Exception {
        try {
            return this.repository.save(dataRegistration);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar
    public Registration modifyRegistration(Integer id, Registration dataRegistration) throws Exception {
        try {
            Optional<Registration> registrationSearch = this.repository.findById(id);

            if (registrationSearch.isPresent()) {
                Registration registrationEntity = registrationSearch.get();
                registrationEntity.setRegistrationDate(dataRegistration.getRegistrationDate());
                registrationEntity.setStudent(dataRegistration.getStudent());
                registrationEntity.setCourse(dataRegistration.getCourse());
                return this.repository.save(registrationEntity);
            } else {
                throw new Exception("Registro no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public Registration searchRegistrationById(Integer id) throws Exception {
        try {
            Optional<Registration> registrationSearch = this.repository.findById(id);
            if (registrationSearch.isPresent()) {
                return registrationSearch.get();
            } else {
                throw new Exception("Registro no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todos
    public Iterable<Registration> searchAllRegistrations() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar
    public String deleteRegistration(Integer id) throws Exception {
        try {
            Optional<Registration> registrationSearch = this.repository.findById(id);
            if (registrationSearch.isPresent()) {
                this.repository.deleteById(id);
                return "Registro eliminado correctamente";
            } else {
                throw new Exception("Registro no encontrado para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
