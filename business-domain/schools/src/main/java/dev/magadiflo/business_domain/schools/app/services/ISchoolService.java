package dev.magadiflo.business_domain.schools.app.services;

import dev.magadiflo.business_domain.schools.app.models.entities.School;

import java.util.List;

public interface ISchoolService {
    List<School> listAllSchools();

    School saveSchool(School school);
}
