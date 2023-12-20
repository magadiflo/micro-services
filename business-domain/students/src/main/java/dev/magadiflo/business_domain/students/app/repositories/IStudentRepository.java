package dev.magadiflo.business_domain.students.app.repositories;

import dev.magadiflo.business_domain.students.app.models.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student AS s WHERE s.schoolId = :schoolId")
    List<Student> findAllStudentsBySchoolId(@Param(value = "schoolId") Long schoolId);
}
