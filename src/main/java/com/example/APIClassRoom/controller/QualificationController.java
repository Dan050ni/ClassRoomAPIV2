package com.example.APIClassRoom.controller;

import com.example.APIClassRoom.models.Qualification;
import com.example.APIClassRoom.services.QualificationServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("qualifications") // Plural para seguir las buenas prácticas REST
public class QualificationController {

    @Autowired
    QualificationServices qualificationService;

    // Controlador para guardar
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Qualification dataPostForClient) {
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(this.qualificationService.saveQualification(dataPostForClient));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Controlador para modificar
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Qualification data) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.qualificationService.modifyQualification(id, data));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Controlador para buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> searchById(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.qualificationService.searchQualificationById(id));
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
                    .body(this.qualificationService.searchAllQualifications());
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }

    // Controlador para eliminar
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(this.qualificationService.deleteQualification(id));
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
    }
}
