package com.example.APIClassRoom.repositories;

import com.example.APIClassRoom.models.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQualificationRepositories extends JpaRepository<Qualification,Integer> {
}
