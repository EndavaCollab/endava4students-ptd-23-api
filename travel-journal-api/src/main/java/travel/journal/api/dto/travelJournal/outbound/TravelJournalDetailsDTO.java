package travel.journal.api.dto.travelJournal.outbound;

import lombok.Data;
import travel.journal.api.entities.Files;

import java.time.LocalDate;
import java.util.List;

@Data
public class TravelJournalDetailsDTO {
    private byte[] coverPhoto;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;
}
