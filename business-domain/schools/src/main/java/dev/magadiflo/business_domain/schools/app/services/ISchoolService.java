package dev.magadiflo.business_domain.schools.app.services;

import dev.magadiflo.business_domain.schools.app.models.dtos.FullSchoolResponse;
import dev.magadiflo.business_domain.schools.app.models.entities.School;

import java.util.List;
import java.util.Optional;

public interface ISchoolService {
    List<School> listAllSchools();

    Optional<FullSchoolResponse> findSchoolsWithStudents(Long schoolId);

    School saveSchool(School school);
}
