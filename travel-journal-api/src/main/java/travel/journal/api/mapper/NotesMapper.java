package travel.journal.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import travel.journal.api.entities.Notes;
import travel.journal.api.models.NotesModel;
@Component
public class NotesMapper {
    private final ModelMapper modelMapper;

    public NotesMapper() {
        this.modelMapper = new ModelMapper();
    }

    public NotesModel toNotesModel(Notes notesEntity) {
        return modelMapper.map(notesEntity, NotesModel.class);
    }

    public Notes toNotesEntity(NotesModel notesModel) {
        return modelMapper.map(notesModel, Notes.class);
    }
}
