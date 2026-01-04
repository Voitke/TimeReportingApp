package io.github.voitke.timereportingapp.timereport;

import io.github.voitke.timereportingapp.timereport.model.TimeReport;
import io.github.voitke.timereportingapp.timereport.model.TimeReportDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TimeReportController {
    
    private final TimeReportRepository timeReportRepository;
    private final TimeReportService timeReportService;

    @GetMapping("/api/timereports")
    public Page<TimeReport> getAllReports(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page,size);
        return timeReportRepository.findAll(pageable);
    }

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