package travel.journal.api.dto.travelJournal.inbound;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class TravelJournalDTO {
    @NotNull(message = "User id must be not null")
    private Integer userId;

    @NotBlank(message = "Location must be not null")
    private String location;

    @NotNull(message = "Start date must be not null")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate startDate;

    @NotNull(message = "End date must be not null")
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private LocalDate endDate;

    @NotNull(message = "Budget must be not null")
    private Double budget;

    @NotBlank(message = "Description must be not null")
    private String description;
}
