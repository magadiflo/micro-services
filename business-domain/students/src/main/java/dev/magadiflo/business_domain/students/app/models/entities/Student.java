package dev.magadiflo.business_domain.students.app.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    /**
     * Debemos garantizar la integridad de los datos manualmente, ya que estamos trabajando con microservicios.
     */
    private Long schoolId;
}
