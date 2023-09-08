package travel.journal.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import travel.journal.api.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByEmailAndPassword(String email, String password);
}
