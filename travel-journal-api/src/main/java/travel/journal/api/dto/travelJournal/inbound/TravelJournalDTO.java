package travel.journal.api.dto.travelJournal.inbound;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TravelJournalDTO {
    private Integer userId;
    private Integer travelId;
    private String coverPhoto;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double budget;
    private String description;
}
