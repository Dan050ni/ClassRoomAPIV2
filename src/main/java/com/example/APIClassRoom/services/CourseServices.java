package com.example.APIClassRoom.services;

import com.example.APIClassRoom.models.Course;
import com.example.APIClassRoom.repositories.ICourseRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CourseServices {

    @Autowired // Inyección de dependencias
    ICourseRepositories repositor;

    // Guardar un curso
    public Course saveCourse(Course dataCourse) throws Exception {
        try {
            return this.repositor.save(dataCourse);
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    // Modificar un curso
    public Course modifyCourse(Integer id, Course dataCourse) throws Exception {
        try {
            Optional<Course> courseSearch = this.repositor.findById(id);

            if (courseSearch.isPresent()) {
                courseSearch.get().setName(dataCourse.getName()); // Puedes agregar más campos a modificar aquí
                return this.repositor.save(courseSearch.get());
            } else {
                throw new Exception("curso no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar curso por ID
    public Course searchCourseById(Integer id) throws Exception {
        try {
            Optional<Course> courseSearch = this.repositor.findById(id);
            if (courseSearch.isPresent()) {
                return courseSearch.get();
            } else {
                throw new Exception("curso no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todos los cursos
    public Iterable<Course> searchAllCourses() throws Exception {
        try {
            return this.repositor.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar un curso por ID
    public String deleteCourse(Integer id) throws Exception {
        try {
            Optional<Course> courseSearch = this.repositor.findById(id);
            if (courseSearch.isPresent()) {
                this.repositor.deleteById(id);
                return "Curso eliminado correctamente";
            } else {
                throw new Exception("curso no encontrado para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
