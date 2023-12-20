package dev.magadiflo.business_domain.students.app.services;

import dev.magadiflo.business_domain.students.app.models.entities.Student;

import java.util.List;

public interface IStudentService {
    List<Student> listAllStudents();

    List<Student> findAllStudentsBySchool(Long schoolId);

    Student saveStudent(Student student);
}
