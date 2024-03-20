
package travel.journal.api.service;

import org.springframework.web.multipart.MultipartFile;
import travel.journal.api.dto.travelJournal.inbound.TravelJournalDTO;
import travel.journal.api.dto.travelJournal.outbound.TravelJournalDetailsDTO;

import java.io.IOException;
import java.util.List;

public interface TravelService  {


    TravelJournalDetailsDTO createTravelJournal(TravelJournalDTO travelJournal, MultipartFile file) throws IOException;

    TravelJournalDetailsDTO getTravelJournal(Integer id);

    List<TravelJournalDetailsDTO> getAllTravelJournals();

    TravelJournalDetailsDTO modifyTravelJournal(Integer id, TravelJournalDTO travelJournal, MultipartFile file) throws IOException;

    void deleteTravelJournal(Integer id);

    List<TravelJournalDetailsDTO> getUserTravelJournal(int userId);
}

