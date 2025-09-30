package io.github.voitke.timereportingapp.timereport;

import io.github.voitke.timereportingapp.timereport.model.TimeReport;
import io.github.voitke.timereportingapp.timereport.model.TimeReportDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.Optional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequiredArgsConstructor
public class TimeReportController {
    
    @Autowired
    TimeReportRepository timeReportRepository;
    @Autowired
    TimeReportService timeReportService;

    @GetMapping("/api/timereport/{id}")
    public ResponseEntity<TimeReport> getReportById(@PathVariable Long id) {
        Optional<TimeReport> timeReport = timeReportRepository.findById(id);
        return timeReport.isPresent() ? ResponseEntity.ok(timeReport.get()) : ResponseEntity.notFound().build();
    }

    @PostMapping("/api/timereport")
    public ResponseEntity addReport(@RequestBody @Valid TimeReportDTO reportDto) {
        var createdReport = timeReportService.addNewReport(reportDto);
        return ResponseEntity.created(URI.create("/api/timereport/" + createdReport.getId())).body(createdReport);
    }
}