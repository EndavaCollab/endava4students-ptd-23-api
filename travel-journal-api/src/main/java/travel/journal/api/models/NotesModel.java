package travel.journal.api.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class NotesModel {
    private int noteId;
    private TravelJournalModel travelJournal;
    private String destinationName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String note;
    private List<FilesModel> filesList;

}
