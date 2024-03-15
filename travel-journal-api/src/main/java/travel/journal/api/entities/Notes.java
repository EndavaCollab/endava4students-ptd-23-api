package travel.journal.api.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "\"notes\"")
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private int noteId;

    @ManyToOne
    @JoinColumn(name = "travel_id")
    private TravelJournal travelJournal;

    @Column(name = "destination_name")
    private String destinationName;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "note")
    private String note;

    @ManyToMany(mappedBy = "notesList")
    private List<Files> filesList;

    public Notes(int noteId, TravelJournal travelJournal, String destinationName, LocalDate startDate, LocalDate endDate, String note, List<Files> filesList) {
        this.noteId = noteId;
        this.travelJournal = travelJournal;
        this.destinationName = destinationName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.note = note;
        this.filesList = filesList;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public TravelJournal getTravelJournal() {
        return travelJournal;
    }

    public void setTravelJournal(TravelJournal travelJournal) {
        this.travelJournal = travelJournal;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public List<Files> getFilesList() {
        return filesList;
    }

    public void setFilesList(List<Files> filesList) {
        this.filesList = filesList;
    }
}

