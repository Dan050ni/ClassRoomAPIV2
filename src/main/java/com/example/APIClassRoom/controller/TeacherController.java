package com.example.APIClassRoom.controller;

import com.example.APIClassRoom.models.Teacher;
import com.example.APIClassRoom.services.TeacherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//La siguiene anotacion garantiza que este en API REST para que venga con un JSON y debe ser en plural
@RestController
@RequestMapping("teachers")

public class TeacherController {
    @Autowired
    TeacherServices thService;

    //Controlador para guardar el ? quiere decir que puede ser el uno o el otro
    @PostMapping
    public ResponseEntity<?> save(@RequestBody Teacher dataPostForClient){
        try{
            return ResponseEntity
                    .status(HttpStatus.CREATED).body(this.thService.saveDocente(dataPostForClient));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //Controlador para modificar ojjo los id's viajan por el path y no por el body
    @PutMapping("/{id}")
    public ResponseEntity<?> modify(@PathVariable Integer id, @RequestBody Teacher date){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK).body(this.thService.modifyTeacher(id, date));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //Controlador que busca por id
    @GetMapping("/{id}")
    public ResponseEntity<?> searchById(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK).body(this.thService.searchTeacherById(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //Controlador para buscarlos todos
    //Siempre pongo el nombre de la operacion
    @GetMapping
    public ResponseEntity<?> searchAll(){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK).body(this.thService.searchAllTeachers());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    //Controlador para eliminar
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try{
            return ResponseEntity
                    .status(HttpStatus.OK).body(this.thService.deleteTeacher(id));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}