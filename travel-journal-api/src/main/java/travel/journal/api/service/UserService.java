package travel.journal.api.service;


;
import travel.journal.api.dto.CreateUserDTO;
import travel.journal.api.dto.UpdateUserDTO;
import travel.journal.api.dto.UserDetailsDTO;
import travel.journal.api.entities.User;


import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDetailsDTO createUser(CreateUserDTO user);

    UserDetailsDTO getUser(Integer id);

    List<UserDetailsDTO> getAllUsers();

    UserDetailsDTO modifyUser(Integer id, UpdateUserDTO user);

    boolean deleteUser(Integer id);

    Optional<User> findUserByEmail(String email);

    void saveUser(User user);
    Optional<User> getCurrentUser();
}
