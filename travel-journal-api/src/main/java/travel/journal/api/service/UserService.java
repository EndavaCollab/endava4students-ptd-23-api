package travel.journal.api.service;

import travel.journal.api.dto.UserCredentialsDTO;
import travel.journal.api.dto.CreateUserDTO;
import travel.journal.api.dto.UpdateUserDTO;
import travel.journal.api.dto.UserDetailsDTO;

import java.util.List;

public interface UserService {
    UserDetailsDTO createUser(CreateUserDTO user);

    UserDetailsDTO getUser(Integer id);

    List<UserDetailsDTO> getAllUsers();

    UserDetailsDTO modifyUser(Integer id, UpdateUserDTO user);

    void deleteUser(Integer id);

    boolean signin(UserCredentialsDTO userCredentialsDTO);
}
