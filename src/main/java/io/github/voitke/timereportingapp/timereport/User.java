package io.github.voitke.timereportingapp.timereport;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@NoArgsConstructor
public class User {
    @Id
    Long id;
}
