package travel.journal.api.service;


import travel.journal.api.dto.CreateUserDTO;
import travel.journal.api.dto.UpdateUserDTO;
import travel.journal.api.dto.UserDetailsDTO;

import java.util.List;

public interface UserService {
    UserDetailsDTO createUser(CreateUserDTO user);

    UserDetailsDTO getUser(Long id);

    List<UserDetailsDTO> getAllUsers();

    UserDetailsDTO modifyUser(Long id, UpdateUserDTO user);

    boolean deleteUser(Long id);
}
