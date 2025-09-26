package io.github.voitke.timereportingapp.timereport;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class TimeReport {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private Long userId;
    @NotNull
    private Long activityId;
    @PastOrPresent
    private LocalDate date;
    @PositiveOrZero
    private Duration duration;
    @PastOrPresent
    private LocalDate dateReported;
}