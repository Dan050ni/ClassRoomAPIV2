package com.example.APIClassRoom.services;

import com.example.APIClassRoom.models.Student;
import com.example.APIClassRoom.repositories.IStudentRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServices {

    @Autowired // Inyección de dependencia
    IStudentRepositories repository;

    // Guardar
    public Student saveStudent(Student dataStudent) throws Exception {
        try {
            return this.repository.save(dataStudent);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Modificar
    public Student modifyStudent(Integer id, Student dataStudent) throws Exception {
        try {
            Optional<Student> studentSearch = this.repository.findById(id);

            if (studentSearch.isPresent()) {
                Student studentEntity = studentSearch.get();
                studentEntity.setAdress(dataStudent.getAdress());
                studentEntity.setBirthdate(dataStudent.getBirthdate());
                studentEntity.setGrade(dataStudent.getGrade());
                // Nota: No modificamos las relaciones como `user`, `qualifications`, etc. aquí directamente
                return this.repository.save(studentEntity);
            } else {
                throw new Exception("Estudiante no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public Student searchStudentById(Integer id) throws Exception {
        try {
            Optional<Student> studentSearch = this.repository.findById(id);
            if (studentSearch.isPresent()) {
                return studentSearch.get();
            } else {
                throw new Exception("Estudiante no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todos
    public Iterable<Student> searchAllStudents() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar
    public String deleteStudent(Integer id) throws Exception {
        try {
            Optional<Student> studentSearch = this.repository.findById(id);
            if (studentSearch.isPresent()) {
                this.repository.deleteById(id);
                return "Estudiante eliminado correctamente";
            } else {
                throw new Exception("Estudiante no encontrado para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
