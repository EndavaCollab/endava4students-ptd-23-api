package travel.journal.api.dto.travelJournal.outbound;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CardTravelJournalDTO {
    private Integer userId;
    private Integer travelId;
    private String coverPhoto;
    private String location;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double budget;
    private Integer notesNumber;
}
