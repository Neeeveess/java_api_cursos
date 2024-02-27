package br.com.jvneves.api_cursos.modules.course.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jvneves.api_cursos.exceptions.CourseFoundException;
import br.com.jvneves.api_cursos.modules.course.CourseEntity;
import br.com.jvneves.api_cursos.modules.course.CourseRepository;

@Service
public class CreateCourseUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public CourseEntity execute(CourseEntity courseEntity) {
    this.courseRepository
        .findByName(courseEntity.getName())
        .ifPresent((name) -> {
          throw new CourseFoundException();
        });

    return this.courseRepository.save(courseEntity);
  }

}
