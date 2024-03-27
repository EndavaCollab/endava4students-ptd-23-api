package travel.journal.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsDTO {
    private int userId;
    private String email;
    private String firstname;
    private String lastname;
}
