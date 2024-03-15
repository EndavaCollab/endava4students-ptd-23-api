package travel.journal.api.models;

import lombok.Data;

import java.util.List;

@Data
public class UserModel {
    private int userId;
    private String email;
    private String name;
    private String surname;
    private List<TravelJournalModel> travelJournalList;
}
