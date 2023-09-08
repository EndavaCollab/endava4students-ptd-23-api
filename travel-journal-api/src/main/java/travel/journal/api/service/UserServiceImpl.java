package travel.journal.api.service;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import travel.journal.api.dto.UserCredentialsDTO;
import travel.journal.api.dto.CreateUserDTO;
import travel.journal.api.dto.UpdateUserDTO;
import travel.journal.api.dto.UserDetailsDTO;
import travel.journal.api.entities.User;
import travel.journal.api.exception.ResourceNotFoundException;
import travel.journal.api.repositories.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserDetailsDTO createUser(CreateUserDTO createUserDto) {
        User userToCreate = modelMapper.map(createUserDto, User.class);
        User createdUser = userRepository.save(userToCreate);

        return modelMapper.map(createdUser, UserDetailsDTO.class);
    }

    @Override
    public UserDetailsDTO getUser(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " does not exist."));
        return modelMapper.map(user, UserDetailsDTO.class);
    }

    @Override
    public List<UserDetailsDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDetailsDTO.class)).collect(Collectors.toList());
    }

    @Override
    public UserDetailsDTO modifyUser(Integer id, UpdateUserDTO updateUserDTO) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser.setName(updateUserDTO.getName());
            existingUser.setSurname(updateUserDTO.getSurname());

            User modifiedUser = userRepository.save(existingUser);

            return modelMapper.map(modifiedUser, UserDetailsDTO.class);
        } else {
            throw new ResourceNotFoundException("User with id: " + id + " does not exist.");
        }
    }

    @Override
    public void deleteUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("User with id: " + id + " does not exist.");
        }
    }

    @Override
    public boolean signin(UserCredentialsDTO userCredentialsDTO) {
        User user = userRepository.findByEmailAndPassword(userCredentialsDTO.getEmail(), userCredentialsDTO.getPassword());

        return user != null;
    }

}
