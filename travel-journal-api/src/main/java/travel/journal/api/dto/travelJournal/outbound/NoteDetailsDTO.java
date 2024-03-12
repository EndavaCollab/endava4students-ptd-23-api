package travel.journal.api.dto.travelJournal.outbound;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class NoteDetailsDTO {
    private Integer userId;
    private Integer travelId;
    private Integer noteId;
    private List<String> travelPhotos;
    private String title;
    private LocalDate date;
    private String description;
}
