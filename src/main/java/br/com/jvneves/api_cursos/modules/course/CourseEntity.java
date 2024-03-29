package br.com.jvneves.api_cursos.modules.course;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "course")
public class CourseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  private String name;

  private String category;

  public enum Active {
    TRUE, FALSE;
  }

  @Enumerated(EnumType.STRING)
  private Active active;

  @CreationTimestamp
  private LocalDateTime created_at;

  private LocalDateTime updated_at;

}
