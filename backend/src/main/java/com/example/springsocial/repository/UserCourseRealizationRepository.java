package com.example.springsocial.repository;

import com.example.springsocial.model.UserCourseRealization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCourseRealizationRepository extends JpaRepository<UserCourseRealization, Integer> {
}