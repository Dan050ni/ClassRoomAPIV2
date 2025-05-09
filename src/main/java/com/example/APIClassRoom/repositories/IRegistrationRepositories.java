package com.example.APIClassRoom.repositories;

import com.example.APIClassRoom.models.Registration; // 👈 Aquí está el cambio correcto
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegistrationRepositories extends JpaRepository<Registration, Integer> {
}
