package com.microservice.stundent.service;

import com.microservice.stundent.persistence.entity.StudentEntity;
import com.microservice.stundent.persistence.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Optional<List<StudentEntity>> getAllByName(String name){
        return this.studentRepository.findAllByName(name);
    }

    public Optional<List<StudentEntity>> getAllByCourseId(Long courseId){
        return this.studentRepository.findAllByCourseId(courseId);
    }

    public Optional<StudentEntity> getById(Long studentId){
        return this.studentRepository.findById(studentId);
    }

    public void saveStudent(StudentEntity student){
        this.studentRepository.save(student);
    }

    public List<StudentEntity> getAllStundents(){
        return this.studentRepository.findAll();
    }
}
