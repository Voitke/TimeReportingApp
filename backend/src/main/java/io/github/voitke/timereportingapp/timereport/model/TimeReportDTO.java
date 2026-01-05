package io.github.voitke.timereportingapp.timereport.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.voitke.timereportingapp.timereport.validation.PositiveDuration;
import jakarta.validation.constraints.PastOrPresent;

import java.time.Duration;
import java.time.LocalDate;

public record TimeReportDTO(
    @JsonProperty("user_id") Long userId,
    @JsonProperty("activity_id") Long activityId,
    @PastOrPresent
    LocalDate date,
    @PositiveDuration
    Duration duration,
    @PastOrPresent
    LocalDate dateReported
) {}