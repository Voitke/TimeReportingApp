package io.github.voitke.timereportingapp.timereport;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequiredArgsConstructor
public class TimeReportController {
    
    @Autowired
    TimeReportRepository timeReportRepository;

    @GetMapping("/api/timereport/{id}")
    public ResponseEntity<TimeReport> getReportById(@PathVariable Long id) {
        Optional<TimeReport> timeReport = timeReportRepository.findById(id);
        return timeReport.isPresent() ? ResponseEntity.ok(timeReport.get()) : ResponseEntity.notFound().build();
    }
}
