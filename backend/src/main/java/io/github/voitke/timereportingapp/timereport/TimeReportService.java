package io.github.voitke.timereportingapp.timereport;

import io.github.voitke.timereportingapp.timereport.model.Activity;
import io.github.voitke.timereportingapp.timereport.model.TimeReport;
import io.github.voitke.timereportingapp.timereport.model.TimeReportDTO;
import io.github.voitke.timereportingapp.timereport.model.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
 import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
 @Slf4j
public class TimeReportService {

    private final TimeReportRepository timeReportRepository;
    private final UserRepository userRepository;
    private final ActivityRepository activityRepository;

    @Transactional
    public TimeReport addNewReport(TimeReportDTO reportDto){
        log.info("Adding new time report to database");
        User user = userRepository.findById(reportDto.userId())
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + reportDto.userId()));
        Activity activity = activityRepository.findById(reportDto.activityId())
                .orElseThrow(() -> new EntityNotFoundException("Activit not found with id: " + reportDto.activityId()));
        TimeReport timeReport = new TimeReport();
        timeReport.setUser(user);
        timeReport.setActivity(activity);
        timeReport.setDate(reportDto.date());
        timeReport.setDuration(reportDto.duration());
        timeReport.setDateReported(reportDto.dateReported());
        timeReportRepository.save(timeReport);
        return timeReport;
    }
}