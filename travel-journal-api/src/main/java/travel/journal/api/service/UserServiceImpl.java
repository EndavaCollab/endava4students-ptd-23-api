package travel.journal.api.service;

import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import travel.journal.api.dto.CreateUserDTO;
import travel.journal.api.dto.UpdateUserDTO;
import travel.journal.api.dto.UserDetailsDTO;
import travel.journal.api.entity.User;
import travel.journal.api.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9.%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;


    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }
    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public UserDetailsDTO createUser(CreateUserDTO createUserDto) {
        User userToCreate = modelMapper.map(createUserDto, User.class);
        boolean existEmail=userRepository.existsByEmail(userToCreate.getEmail());
        if(existEmail || !isValidEmail(userToCreate.getEmail())){
            return null;
        }
        String encodedPassword = passwordEncoder.encode(createUserDto.getPassword());
        userToCreate.setPassword(encodedPassword);
        User createdUser = userRepository.save(userToCreate);
        return modelMapper.map(createdUser, UserDetailsDTO.class);
    }

    @Override
    public UserDetailsDTO getUser(Long id) {
        User user = userRepository.findById(id).orElse(null);
        if(user==null){
            return null;
        }
        return modelMapper.map(user, UserDetailsDTO.class);
    }

    @Override
    public List<UserDetailsDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(user -> modelMapper.map(user, UserDetailsDTO.class)).collect(Collectors.toList());
    }


    public UserDetailsDTO modifyUser(Long id, UpdateUserDTO updateUserDTO) {
        Optional<User> existingUserOptional = userRepository.findById(id);
        if (existingUserOptional.isPresent()) {
            User existingUser = existingUserOptional.get();
            existingUser = User.builder()
                    .user_id(existingUser.getUser_id())
                    .email(existingUser.getEmail())
                    .first_name(updateUserDTO.getFirst_name())
                    .last_name(updateUserDTO.getLast_name())
                    .password(existingUser.getPassword())
                    .build();

            User modifiedUser = userRepository.save(existingUser);

            return modelMapper.map(modifiedUser, UserDetailsDTO.class);
        } else {
           return null;
        }
    }


    @Override
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        } else {
          return false;
        }
    }
}
