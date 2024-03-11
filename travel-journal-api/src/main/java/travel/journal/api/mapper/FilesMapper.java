package travel.journal.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import travel.journal.api.entities.Files;
import travel.journal.api.models.FilesModel;
@Component
public class FilesMapper {
    private final ModelMapper modelMapper;

    public FilesMapper() {
        this.modelMapper = new ModelMapper();
    }

    public FilesModel toFilesModel(Files filesEntity) {
        return modelMapper.map(filesEntity, FilesModel.class);
    }

    public Files toFilesEntity(FilesModel filesModel) {
        return modelMapper.map(filesModel, Files.class);
    }
}
