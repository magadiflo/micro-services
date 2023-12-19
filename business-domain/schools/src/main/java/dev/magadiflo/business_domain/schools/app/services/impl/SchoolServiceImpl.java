package dev.magadiflo.business_domain.schools.app.services.impl;

import dev.magadiflo.business_domain.schools.app.models.entities.School;
import dev.magadiflo.business_domain.schools.app.repositories.ISchoolRepository;
import dev.magadiflo.business_domain.schools.app.services.ISchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolServiceImpl implements ISchoolService {

    private final ISchoolRepository schoolRepository;

    @Override
    @Transactional(readOnly = true)
    public List<School> listAllSchools() {
        return this.schoolRepository.findAll();
    }

    @Override
    @Transactional
    public School saveSchool(School school) {
        return this.schoolRepository.save(school);
    }
}
