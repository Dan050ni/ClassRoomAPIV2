package com.example.APIClassRoom.repositories;

import com.example.APIClassRoom.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepositories extends JpaRepository<User, Integer> {
}
