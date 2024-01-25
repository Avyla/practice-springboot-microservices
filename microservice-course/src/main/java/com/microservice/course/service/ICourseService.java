package com.microservice.course.service;

import com.microservice.course.entity.CourseEntity;
import com.microservice.course.http.response.StudentByCourseResponse;

import java.util.List;

public interface ICourseService {

    List<CourseEntity> findAll();
    CourseEntity findById(Long courseId);
    void save(CourseEntity course);
    StudentByCourseResponse findStudentsByIdCourse(Long courseId);

}
