package br.com.jvneves.api_cursos.modules.course.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.jvneves.api_cursos.modules.course.CourseEntity;
import br.com.jvneves.api_cursos.modules.course.CourseRepository;

@Service
public class GetAllUseCase {

  @Autowired
  private CourseRepository courseRepository;

  public List<CourseEntity> getAll() {
    return courseRepository.findAll();
  }
}
