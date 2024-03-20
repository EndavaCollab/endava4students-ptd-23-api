package travel.journal.api.dto.travelJournal.outbound;

import lombok.Data;

import java.time.LocalDate;

@Data
public class NoteEntryDTO {
    private Integer noteId;
    private String title;
    private LocalDate date;
    private String description;
}
