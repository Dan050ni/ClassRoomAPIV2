package com.example.APIClassRoom.services;

import com.example.APIClassRoom.models.Teacher;
import com.example.APIClassRoom.repositories.ITeacherRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServices {

    @Autowired //inyección de dependencia
    ITeacherRepositories repository;

    //guardar
    public Teacher saveDocente(Teacher dataTeacher) throws Exception {
        try {
            return this.repository.save(dataTeacher);
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    //modificar
    public Teacher modifyTeacher(Integer id, Teacher dateTeacher) throws Exception {
        try {
            Optional<Teacher> teacherSerch = this.repository.findById(id);

            if (teacherSerch.isPresent()) {
                //modifiquelo
                teacherSerch.get().setSpecialism(dateTeacher.getSpecialism()); // modificando un dato viejo
                return this.repository.save(teacherSerch.get());
            } else {
                throw new Exception("usuario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar por id
    public Teacher searchTeacherById(Integer id) throws Exception {
        try {
            Optional<Teacher> teacherSearch = this.repository.findById(id);
            if (teacherSearch.isPresent()) {
                return teacherSearch.get();
            } else {
                throw new Exception("docente no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //buscar todos
    public Iterable<Teacher> searchAllTeachers() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    //eliminar
    public String deleteTeacher(Integer id) throws Exception {
        try {
            Optional<Teacher> teacherSearch = this.repository.findById(id);
            if (teacherSearch.isPresent()) {
                this.repository.deleteById(id);
                return "Docente eliminado correctamente";
            } else {
                throw new Exception("docente no encontrado para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
