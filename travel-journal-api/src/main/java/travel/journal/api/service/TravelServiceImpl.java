
package travel.journal.api.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import travel.journal.api.dto.travelJournal.inbound.TravelJournalDTO;
import travel.journal.api.dto.travelJournal.outbound.TravelJournalDetailsDTO;
import travel.journal.api.entities.Files;
import travel.journal.api.entities.TravelJournal;
import travel.journal.api.exception.ResourceNotFoundException;
import travel.journal.api.repositories.TravelJournalRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TravelServiceImpl implements TravelService {

    private final TravelJournalRepository travelRepository;
    private final FilesServiceImpl filesService;
    private final ModelMapper modelMapper;

    public TravelServiceImpl(TravelJournalRepository travelRepository, FilesServiceImpl filesService, ModelMapper modelMapper) {
        this.travelRepository = travelRepository;
        this.filesService = filesService;
        this.modelMapper = modelMapper;
    }

    @Override
    public TravelJournalDetailsDTO createTravelJournal(TravelJournalDTO travelJournalDTO, MultipartFile file) throws IOException {
        TravelJournal travelToCreate = modelMapper.map(travelJournalDTO, TravelJournal.class);

        Files createdFile = filesService.saveImage(file);
        travelToCreate.setCoverPhoto(createdFile);
        travelToCreate.setHasCoverPhoto(createdFile.getFileContent().length > 0);

        TravelJournal createdTravel = travelRepository.save(travelToCreate);

        return modelMapper.map(createdTravel, TravelJournalDetailsDTO.class);
    }

    @Override
    public TravelJournalDetailsDTO getTravelJournal(Integer id) {
        TravelJournal travel = travelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Travel with id: " + id + " does not exist"));
        return modelMapper.map(travel, TravelJournalDetailsDTO.class);
    }

    @Override
    public List<TravelJournalDetailsDTO> getAllTravelJournals() {
        List<TravelJournal> allTravels = travelRepository.findAll();

        return allTravels.stream().map(travelJournal -> modelMapper.map(travelJournal, TravelJournalDetailsDTO.class)).collect(Collectors.toList());
    }

    @Override
    public TravelJournalDetailsDTO modifyTravelJournal(Integer id, TravelJournalDTO travelJournalDTO, MultipartFile file) throws IOException {
        Optional<TravelJournal> existingTravelOptional = travelRepository.findById(id);

        if (existingTravelOptional.isPresent()) {

            TravelJournal existingTravel = existingTravelOptional.get();

            Files modifiedImage = filesService.modifyImage(existingTravel.getCoverPhoto().getFileId(), file);

            existingTravel.setHasCoverPhoto(modifiedImage.getFileContent().length > 0);
            existingTravel.setCoverPhoto(modifiedImage);
            existingTravel.setBudget(travelJournalDTO.getBudget());
            existingTravel.setDescription(travelJournalDTO.getDescription());
            existingTravel.setLocation(travelJournalDTO.getLocation());
            existingTravel.setEndDate(travelJournalDTO.getEndDate());
            existingTravel.setStartDate(travelJournalDTO.getStartDate());
            existingTravel.setHasCoverPhoto(existingTravel.getHasCoverPhoto());
            existingTravel.setNotesList(existingTravel.getNotesList());

            TravelJournal modifiedTravel = travelRepository.save(existingTravel);

            return modelMapper.map(modifiedTravel, TravelJournalDetailsDTO.class);
        } else {
            throw new ResourceNotFoundException("Travel with id: " + id + " does not exist");
        }
    }


    @Override
    public void deleteTravelJournal(Integer id) {
        Optional<TravelJournal> travelOptional = travelRepository.findById(id);
        if (travelOptional.isPresent()) {

            TravelJournal travelToDelete = travelOptional.get();
            filesService.deleteImage(travelToDelete.getCoverPhoto().getFileId());
            travelRepository.deleteById(id);

        } else {
            throw new ResourceNotFoundException("Travel with id: " + id + " does not exist");
        }
    }

    @Override
    public List<TravelJournalDetailsDTO>getUserTravelJournal(int userId) {
        List<TravelJournal> userTravels = travelRepository.findByUserUserIdOrderByStartDateDesc(userId);

        return userTravels.stream().map(travelJournal -> modelMapper.map(travelJournal, TravelJournalDetailsDTO.class)).collect(Collectors.toList());
    }
}


