package travel.journal.api.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "\"files\"")
public class Files {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Watch out if nullable or not
    @Column(name = "file_id")
    private Long fileId;

    @Column(name = "file_name")
    private String fileName;

    @Column(name = "title")
    private String title;

    @Column(name = "file_content")
    private byte[] fileContent;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @OneToMany(mappedBy = "coverPhoto", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<TravelJournal> travelJournalList;

    @ManyToMany
    @JoinTable(
            name = "notes_files",
            joinColumns = @JoinColumn(name = "file_id"),
            inverseJoinColumns = @JoinColumn(name = "note_id")
    )
    private List<Notes> notesList;

    public Files(Long fileId, String fileName, String title, byte[] fileContent, LocalDate createdDate, List<TravelJournal> travelJournalList, List<Notes> notesList) {
        this.fileId = fileId;
        this.fileName = fileName;
        this.title = title;
        this.fileContent = fileContent;
        this.createdDate = createdDate;
        this.travelJournalList = travelJournalList;
        this.notesList = notesList;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getFileContent() {
        return fileContent;
    }

    public void setFileContent(byte[] fileContent) {
        this.fileContent = fileContent;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public List<TravelJournal> getTravelJournalList() {
        return travelJournalList;
    }

    public void setTravelJournalList(List<TravelJournal> travelJournalList) {
        this.travelJournalList = travelJournalList;
    }

    public List<Notes> getNotesList() {
        return notesList;
    }

    public void setNotesList(List<Notes> notesList) {
        this.notesList = notesList;
    }
}

