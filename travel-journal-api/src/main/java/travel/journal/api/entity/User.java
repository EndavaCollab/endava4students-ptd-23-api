package travel.journal.api.entity;

import jakarta.persistence.*;
import lombok.*;




@Entity
@Table(name = "users")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;
    @Column(unique = true)
    @NonNull
    private String email;
    @NonNull
    private String first_name;
    @NonNull
    private String last_name;
    @NonNull
    private String password;
}

