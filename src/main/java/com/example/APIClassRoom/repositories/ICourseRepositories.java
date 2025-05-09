package com.example.APIClassRoom.repositories;


import com.example.APIClassRoom.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepositories extends JpaRepository<Course,Integer> {

}
