package com.microservice.course.controller;

import com.microservice.course.entity.CourseEntity;
import com.microservice.course.service.CourseServiceImpl;
import com.microservice.course.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/course")
public class CourseController {

    private final ICourseService courseService;

    @Autowired
    public CourseController(ICourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveCourse(@RequestBody CourseEntity course){
        this.courseService.save(course);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCourses(){
        return ResponseEntity.ok(this.courseService.findAll());
    }

    @GetMapping("/search/{courseId}")
    public ResponseEntity<?> getById(@PathVariable("courseId") Long courseId){
        return ResponseEntity.ok(this.courseService.findById(courseId));
    }

    @GetMapping("/search-student/{courseId}")
    public ResponseEntity<?> getStudentsByIdCourse(@PathVariable("courseId") Long courseId){
        return ResponseEntity.ok(this.courseService.findStudentsByIdCourse(courseId));
    }
}
