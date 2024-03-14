package travel.journal.api.service;


import travel.journal.api.dto.CreateUserDTO;
import travel.journal.api.dto.UpdateUserDTO;
import travel.journal.api.dto.UserDetailsDTO;
import travel.journal.api.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDetailsDTO createUser(CreateUserDTO user);

    UserDetailsDTO getUser(Long id);

    List<UserDetailsDTO> getAllUsers();

    UserDetailsDTO modifyUser(Long id, UpdateUserDTO user);

    boolean deleteUser(Long id);

    Optional<User> finduserbyemail(String email);

    void saveUser(User user);
}
