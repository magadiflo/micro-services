package dev.magadiflo.business_domain.schools.app.services.impl;

import dev.magadiflo.business_domain.schools.app.models.dtos.FullSchoolResponse;
import dev.magadiflo.business_domain.schools.app.models.dtos.Student;
import dev.magadiflo.business_domain.schools.app.models.entities.School;
import dev.magadiflo.business_domain.schools.app.repositories.ISchoolRepository;
import dev.magadiflo.business_domain.schools.app.services.ISchoolService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.Optional;

@Service
public class SchoolServiceImpl implements ISchoolService {

    private final ISchoolRepository schoolRepository;
    private final RestClient restClient;

    public SchoolServiceImpl(ISchoolRepository schoolRepository, RestClient.Builder restClientBuilder) {
        this.schoolRepository = schoolRepository;
        this.restClient = restClientBuilder.baseUrl("lb://students/api/v1/students").build();
    }

    @Override
    @Transactional(readOnly = true)
    public List<School> listAllSchools() {
        return this.schoolRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FullSchoolResponse> findSchoolsWithStudents(Long schoolId) {
        return this.schoolRepository.findById(schoolId)
                .map(schoolDB -> {
                    List<Student> students = this.restClient.get()
                            .uri("/school/{schoolId}", schoolDB.getId())
                            .retrieve()
                            .body(new ParameterizedTypeReference<>() {
                            });
                    return new FullSchoolResponse(schoolDB.getName(), schoolDB.getEmail(), students);
                });
    }

    @Override
    @Transactional
    public School saveSchool(School school) {
        return this.schoolRepository.save(school);
    }
}
