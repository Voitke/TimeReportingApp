package io.github.voitke.timereportingapp.timereport;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TimeReport {
    @Id
    private Long id;
    private Long userId;
    private Long activityId;
    private LocalDate date;
    private Duration duration;
    private LocalDate dateReported;
}