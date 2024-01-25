package com.microservice.stundent.controller;

import com.microservice.stundent.persistence.entity.StudentEntity;
import com.microservice.stundent.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveStudent(@RequestBody StudentEntity student) {
        this.studentService.saveStudent(student);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") Long id){
        return ResponseEntity.ok(this.studentService.getById(id));
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllStundents(){
        return ResponseEntity.ok(this.studentService.getAllStundents());
    }

    @GetMapping("/search-by-course/{courseId}")
    public ResponseEntity<?> findByIdCourse(@PathVariable Long courseId){
        return ResponseEntity.ok(this.studentService.getAllByCourseId(courseId));
    }
}
