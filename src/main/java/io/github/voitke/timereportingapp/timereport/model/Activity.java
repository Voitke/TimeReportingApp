package io.github.voitke.timereportingapp.timereport.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    String name;
    @ManyToOne
    Activity parentActivity;
}