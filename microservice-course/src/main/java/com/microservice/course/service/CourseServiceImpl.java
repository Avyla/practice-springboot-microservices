package com.microservice.course.service;

import com.microservice.course.client.StudentClient;
import com.microservice.course.controller.dto.StudentDTO;
import com.microservice.course.entity.CourseEntity;
import com.microservice.course.http.response.StudentByCourseResponse;
import com.microservice.course.persistence.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService{

    private final CourseRepository courseRepository;
    private final StudentClient studentClient;

    @Autowired
    public CourseServiceImpl(CourseRepository courseRepository, StudentClient studentClient) {
        this.courseRepository = courseRepository;
        this.studentClient = studentClient;
    }

    @Override
    public List<CourseEntity> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    public CourseEntity findById(Long courseId) {
        return this.courseRepository.findById(courseId).orElseThrow();
    }

    @Override
    public void save(CourseEntity course) {
        this.courseRepository.save(course);
    }

    @Override
    public StudentByCourseResponse findStudentsByIdCourse(Long courseId) {

        //Se consulta el curso
        CourseEntity course = this.courseRepository.findById(courseId).orElse(new CourseEntity());

        //Obtener los estudiantes
        List<StudentDTO> studentDTOList = studentClient.findAllStundentByCourse(courseId);

        return StudentByCourseResponse
                .builder()
                .courseName(course.getName())
                .teacher(course.getTeacher())
                .studentDTOList(studentDTOList)
                .build();
    }
}
