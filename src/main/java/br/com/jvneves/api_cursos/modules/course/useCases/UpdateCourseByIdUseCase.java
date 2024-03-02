package br.com.jvneves.api_cursos.modules.course.useCases;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.jvneves.api_cursos.modules.course.CourseEntity;
import br.com.jvneves.api_cursos.modules.course.CourseRepository;

@Service
public class UpdateCourseByIdUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public CourseEntity updateCourseById(UUID course_id, CourseEntity courseEntity) {
    var course = courseRepository.findById(course_id);
    if (course.isPresent()) {
      CourseEntity entity = course.get();
      entity.setName(courseEntity.getName());
      entity.setCategory(courseEntity.getCategory());
      entity.setActive(courseEntity.getActive());
      entity.setUpdated_at(LocalDateTime.now());
      return this.courseRepository.save(entity);
    }
    return null;

  }
}
