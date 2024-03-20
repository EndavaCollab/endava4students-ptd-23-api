package travel.journal.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import travel.journal.api.entities.TravelJournal;
import travel.journal.api.models.TravelJournalModel;
@Component
public class TravelJournalMapper {
    private final ModelMapper modelMapper;

    public TravelJournalMapper() {
        this.modelMapper = new ModelMapper();
    }

    public TravelJournalModel toTravelJournalModel(TravelJournal travelJournalEntity) {
        return modelMapper.map(travelJournalEntity, TravelJournalModel.class);
    }

    public TravelJournal toTravelJournalEntity(TravelJournalModel travelJournalModel) {
        return modelMapper.map(travelJournalModel, TravelJournal.class);
    }
}
