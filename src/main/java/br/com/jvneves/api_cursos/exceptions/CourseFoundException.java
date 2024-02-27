package br.com.jvneves.api_cursos.exceptions;

public class CourseFoundException extends RuntimeException {
  public CourseFoundException() {
    super("Nome de curso já existe");
  }
}
