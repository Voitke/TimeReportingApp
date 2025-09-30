package io.github.voitke.timereportingapp.timereport.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Duration;
import java.time.LocalDate;

public record TimeReportDTO(
    @JsonProperty("user_id") Long userId,
    @JsonProperty("activity_id") Long activityId,
    LocalDate date,
    Duration duration,
    LocalDate dateReported
) {}