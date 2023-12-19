package dev.magadiflo.business_domain.students.app.controllers;

import dev.magadiflo.business_domain.students.app.models.entities.Student;
import dev.magadiflo.business_domain.students.app.services.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {

    private final IStudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> listAllStudents() {
        return ResponseEntity.ok(this.studentService.listAllStudents());
    }

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody  Student student) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.studentService.saveStudent(student));
    }

}
