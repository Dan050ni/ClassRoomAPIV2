package com.example.APIClassRoom.controller;

import com.example.APIClassRoom.models.SchoolClass;
import com.example.APIClassRoom.services.SchoolClassServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("school-classes") // Buenas prácticas: plural y usando guion para nombres compuestos
public class SchoolClassController {

    @Autowired
    SchoolClassServices schoolClassService;

    // Controlador para guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody SchoolClass dataPostForClient) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.schoolClassService.saveSchoolClass(dataPostForClient));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Controlador para modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable String id, @RequestBody SchoolClass data) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.schoolClassService.modifySchoolClass(id, data));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Controlador para buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> searchById(@PathVariable String id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.schoolClassService.searchSchoolClassById(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Controlador para buscar todos
    @GetMapping
    public ResponseEntity<?> searchAll() {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.schoolClassService.searchAllSchoolClasses());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Controlador para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.schoolClassService.deleteSchoolClass(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
