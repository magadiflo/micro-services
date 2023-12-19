package dev.magadiflo.business_domain.students.app.repositories;

import dev.magadiflo.business_domain.students.app.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStudentRepository extends JpaRepository<Student, Long> {
}
