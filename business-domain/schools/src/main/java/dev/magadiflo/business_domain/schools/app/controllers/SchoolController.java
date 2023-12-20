package dev.magadiflo.business_domain.schools.app.controllers;

import dev.magadiflo.business_domain.schools.app.models.dtos.FullSchoolResponse;
import dev.magadiflo.business_domain.schools.app.models.entities.School;
import dev.magadiflo.business_domain.schools.app.services.ISchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/api/v1/schools")
public class SchoolController {

    private final ISchoolService schoolService;

    @GetMapping
    public ResponseEntity<List<School>> listAllSchools() {
        return ResponseEntity.ok(this.schoolService.listAllSchools());
    }

    @GetMapping(path = "/with-students/{school-id}")
    public ResponseEntity<FullSchoolResponse> findSchoolsWithStudents(@PathVariable(value = "school-id") Long id) {
        return this.schoolService.findSchoolsWithStudents(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<School> saveSchool(@RequestBody School school) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.schoolService.saveSchool(school));
    }
}
