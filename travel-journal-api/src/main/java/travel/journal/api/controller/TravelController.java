package travel.journal.api.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import travel.journal.api.dto.travelJournal.inbound.TravelJournalDTO;
import travel.journal.api.dto.travelJournal.outbound.TravelJournalDetailsDTO;
import travel.journal.api.service.TravelService;
import travel.journal.api.service.TravelServiceImpl;

import java.io.IOException;
import java.util.List;

@RestController

@RequestMapping("/travel-journal")
public class TravelController {
    private final TravelServiceImpl travelServiceImpl;


    public TravelController(TravelServiceImpl travelServiceImpl) {
        this.travelServiceImpl = travelServiceImpl;
    }

    @PostMapping("/travel")
    public ResponseEntity<TravelJournalDetailsDTO> createTravel(@RequestPart("travelJournalDTO") TravelJournalDTO travelJournalDTO, @RequestParam("file")MultipartFile file) throws IOException {
        TravelJournalDetailsDTO newTravel = travelServiceImpl.createTravelJournal(travelJournalDTO,file);

        return ResponseEntity.ok(newTravel);
    }

    @GetMapping("/travel/{id}")
    public ResponseEntity<TravelJournalDetailsDTO> getTravel(@PathVariable("id") int travelId) {
        TravelJournalDetailsDTO travelToGet = travelServiceImpl.getTravelJournal(travelId);

        return ResponseEntity.ok(travelToGet);
    }
    @GetMapping("/myTravels/{userId}")
    public ResponseEntity<List<TravelJournalDetailsDTO>> getUserTravels(@PathVariable("userId") int userId) {
        List<TravelJournalDetailsDTO> userTravelJournals = travelServiceImpl.getUserTravelJournal(userId);

        return ResponseEntity.ok(userTravelJournals);
    }

    @GetMapping("/travels")
    ResponseEntity<List<TravelJournalDetailsDTO>> getAllTravels()
    {
        List<TravelJournalDetailsDTO> allTravels = travelServiceImpl.getAllTravelJournals();

        return ResponseEntity.ok(allTravels);
    }

    @PutMapping("travel/{id}")
    ResponseEntity<TravelJournalDetailsDTO> modifyTravel(@PathVariable("id") int travelId, @RequestPart TravelJournalDTO travelJournalDTO, @RequestParam("file") MultipartFile file) throws IOException {

        TravelJournalDetailsDTO modifiedTravel = travelServiceImpl.modifyTravelJournal(travelId,travelJournalDTO,file);

        return ResponseEntity.ok(modifiedTravel);
    }

    @DeleteMapping("travel/{id}")
    ResponseEntity<Void> deleteTravel(@PathVariable("id") int travelId){
        travelServiceImpl.deleteTravelJournal(travelId);
        return ResponseEntity.noContent().build();
    }
}
