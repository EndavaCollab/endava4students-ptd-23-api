package travel.journal.api.dto.travelJournal.outbound;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class TravelJournalDetailsDTO {
    private Integer travelId;
    private String coverPhoto;
    private String destinationName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double budget;
    private String description;
    private Integer notesNumber;
    private List<NoteEntryDTO> notesList;
}
