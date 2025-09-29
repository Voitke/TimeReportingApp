package io.github.voitke.timereportingapp.timereport;

import io.github.voitke.timereportingapp.timereport.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}