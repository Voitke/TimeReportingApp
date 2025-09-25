package io.github.voitke.timereportingapp.timereport;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeReportRepository  extends JpaRepository<TimeReport, Long> {
    // save(TimeReport tr)  [C U]
    // findById(Long id)    [R]
    // findAll()            [R]
    // deleteById(Long id)  [D]
    // count()
}
