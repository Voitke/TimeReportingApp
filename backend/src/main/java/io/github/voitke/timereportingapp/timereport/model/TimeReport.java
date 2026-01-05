package io.github.voitke.timereportingapp.timereport.model;

import io.github.voitke.timereportingapp.timereport.validation.PositiveDuration;
import jakarta.persistence.*;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.Duration;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class TimeReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    @JoinColumn(name = "activity_id", nullable = false)
    @ManyToOne
    private Activity activity;
    @PastOrPresent
    private LocalDate date;
    @PositiveDuration
    private Duration duration;
    @PastOrPresent
    private LocalDate dateReported;
}