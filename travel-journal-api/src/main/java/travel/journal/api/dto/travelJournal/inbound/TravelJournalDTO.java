package travel.journal.api.dto.travelJournal.inbound;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TravelJournalDTO {
    private String coverPhoto;
    private String destinationName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double budget;
    private String description;
}
