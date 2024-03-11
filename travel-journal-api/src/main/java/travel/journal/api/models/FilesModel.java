package travel.journal.api.models;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class FilesModel {
    private Long fileId;
    private String fileName;
    private String title;
    private byte[] fileContent;
    private LocalDate createdDate;
    private List<TravelJournalModel> travelJournalList;
    private List<NotesModel> notesList;

}
