package com.example.springsocial.repository;

import com.example.springsocial.model.CourseRealization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRealizationRepository extends JpaRepository<CourseRealization, Integer> {
}
