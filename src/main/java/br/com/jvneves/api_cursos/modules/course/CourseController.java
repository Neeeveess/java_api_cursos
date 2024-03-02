package br.com.jvneves.api_cursos.modules.course;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.jvneves.api_cursos.modules.course.useCases.GetAllUseCase;
import br.com.jvneves.api_cursos.modules.course.useCases.UpdateCourseByIdUseCase;
import br.com.jvneves.api_cursos.modules.course.useCases.CreateCourseUseCase;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/cursos")
public class CourseController {

  @Autowired
  private CreateCourseUseCase createCourseUseCase;

  @Autowired
  private GetAllUseCase getAllUseCase;

  @Autowired
  private UpdateCourseByIdUseCase updateCourseByIdUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> create(@RequestBody CourseEntity courseEntity) {
    try {
      var result = this.createCourseUseCase.execute(courseEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/")
  public List<CourseEntity> getAll() {
    return this.getAllUseCase.getAll();
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> updateCourse(@PathVariable UUID id, @RequestBody CourseEntity courseEntity) {
    var result = this.updateCourseByIdUseCase.updateCourseById(id, courseEntity);
    return ResponseEntity.ok().body(result);
  }

}
