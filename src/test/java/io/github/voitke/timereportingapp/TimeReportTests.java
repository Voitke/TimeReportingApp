package io.github.voitke.timereportingapp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class TimeReportTests {

    private static final Logger log = LoggerFactory.getLogger(TimeReportTests.class);
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldGetTimeReportForGivenId() throws Exception {
        log.info("Starting shouldGetTimeReportForGivenId test.");
        String expectedResponse =
            """
            {
                "id": 1,
                "user": {},
                "activity": {},
                "date": "2025-09-23",
                "duration": "PT0.000005S",
                "dateReported": "2025-09-24"
            }
            """;

        mockMvc.perform(get("/api/timereport/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(expectedResponse));
    }

    @Test
    void shouldAddNewTimeReport() throws Exception {
        log.info("Starting shouldAddNewTimeReport test.");
        String newTimeReport =
            """
            {
                "user_id": 1,
                "activity_id": 1,
                "date": "2025-09-24",
                "duration": "PT0.000005S",
                "dateReported": "2025-09-24"
            }
            """;

        mockMvc.perform(post("/api/timereport")
                .contentType(MediaType.APPLICATION_JSON).content(newTimeReport))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(3));
    }
}