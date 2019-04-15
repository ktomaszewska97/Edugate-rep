package com.example.springsocial.repository;

import com.example.springsocial.model.SignedUpForCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SignedUpForCourseRepository extends JpaRepository<SignedUpForCourse, Long> {

}
