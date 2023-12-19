package dev.magadiflo.business_domain.schools.app.repositories;

import dev.magadiflo.business_domain.schools.app.models.entities.School;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISchoolRepository extends JpaRepository<School, Long> {
}
