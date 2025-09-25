package io.github.voitke.timereportingapp.timereport;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class Activity {
    @Id
    Long id;
}
