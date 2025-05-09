package com.example.APIClassRoom.services;

import com.example.APIClassRoom.models.User;
import com.example.APIClassRoom.repositories.IUserRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServices {

    @Autowired // Inyección de dependencia
    IUserRepositories repository;

    // Guardar
    public User saveUser(User dataUser) throws Exception {
        try {
            return this.repository.save(dataUser);
        } catch (Exception mistake) {
            throw new Exception(mistake.getMessage());
        }
    }

    // Modificar
    public User modifyUser(Integer id, User dataUser) throws Exception {
        try {
            Optional<User> userSearch = this.repository.findById(id);

            if (userSearch.isPresent()) {
                // Modificamos los datos
                userSearch.get().setName(dataUser.getName());
                userSearch.get().setEmail(dataUser.getEmail());
                userSearch.get().setPassword(dataUser.getPassword());
                userSearch.get().setPhone(dataUser.getPhone());
                userSearch.get().setUserType(dataUser.getUserType());
                return this.repository.save(userSearch.get());
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar por ID
    public User searchUserById(Integer id) throws Exception {
        try {
            Optional<User> userSearch = this.repository.findById(id);
            if (userSearch.isPresent()) {
                return userSearch.get();
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Buscar todos
    public Iterable<User> searchAllUsers() throws Exception {
        try {
            return this.repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    // Eliminar
    public String deleteUser(Integer id) throws Exception {
        try {
            Optional<User> userSearch = this.repository.findById(id);
            if (userSearch.isPresent()) {
                this.repository.deleteById(id);
                return "Usuario eliminado correctamente";
            } else {
                throw new Exception("Usuario no encontrado para eliminar");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
}
