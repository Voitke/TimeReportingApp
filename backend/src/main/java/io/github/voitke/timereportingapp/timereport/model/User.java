package io.github.voitke.timereportingapp.timereport.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    String firstName;
    @NotBlank
    String lastName;
    @NotNull
    @Enumerated(EnumType.STRING)
    UserRole userRole;
}