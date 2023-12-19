package dev.magadiflo.business_domain.schools.app.models.dtos;

import java.util.List;

public record FullSchoolResponse(String name, String email, List<Student> students) {
}
