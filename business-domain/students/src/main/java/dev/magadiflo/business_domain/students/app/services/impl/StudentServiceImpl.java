package dev.magadiflo.business_domain.students.app.services.impl;

import dev.magadiflo.business_domain.students.app.models.entities.Student;
import dev.magadiflo.business_domain.students.app.repositories.IStudentRepository;
import dev.magadiflo.business_domain.students.app.services.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentServiceImpl implements IStudentService {

    private final IStudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Student> listAllStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        return this.studentRepository.save(student);
    }
}
