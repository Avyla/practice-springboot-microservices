package com.microservice.stundent.persistence.repository;

import com.microservice.stundent.persistence.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    Optional<List<StudentEntity>> findAllByName(String name);
    Optional<List<StudentEntity>> findAllByCourseId(Long courseId);

}
