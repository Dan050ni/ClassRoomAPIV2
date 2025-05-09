package com.example.APIClassRoom.repositories;

import com.example.APIClassRoom.models.SchoolClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISchoolClassRepositories extends JpaRepository<SchoolClass, String> {
}
