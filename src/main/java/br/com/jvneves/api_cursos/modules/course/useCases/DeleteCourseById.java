package br.com.jvneves.api_cursos.modules.course.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.jvneves.api_cursos.modules.course.CourseEntity;
import br.com.jvneves.api_cursos.modules.course.CourseRepository;

@Service
public class DeleteCourseById {

  @Autowired
  private CourseRepository courseRepository;

  public ResponseEntity deleteCourseById(UUID id) {
    var course = this.courseRepository.findById(id);
    if (course.isPresent()) {
      this.courseRepository.deleteById(id);
      return ResponseEntity.ok().body(course);
    }
    return ResponseEntity.badRequest().body(null);
  }
}
