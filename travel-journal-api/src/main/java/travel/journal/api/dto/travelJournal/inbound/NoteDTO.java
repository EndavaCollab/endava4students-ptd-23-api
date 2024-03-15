package travel.journal.api.dto.travelJournal.inbound;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class NoteDTO {
    private Integer userId;
    private List<String> coverPhotos;
    private String destinationName;
    private LocalDate date;
    private String description;
}
