package travel.journal.api.payload.response;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
//@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
    private String token;
    private String type = "Bearer";

//    private String username;

    public JwtResponse(String jwt, String username) {
        this.token=jwt;
//        this.username=username;
    }

    public JwtResponse(String jwt) {
        this.token=jwt;
    }
}
