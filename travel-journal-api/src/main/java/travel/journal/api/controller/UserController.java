package travel.journal.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import travel.journal.api.dto.UserCredentialsDTO;
import travel.journal.api.dto.CreateUserDTO;
import travel.journal.api.dto.UpdateUserDTO;
import travel.journal.api.dto.UserDetailsDTO;
import travel.journal.api.service.UserServiceImpl;

import java.util.List;

@RestController

@RequestMapping("/travel-journal")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PostMapping("/user")
    public ResponseEntity<UserDetailsDTO> createUser(@RequestBody CreateUserDTO user) {
        UserDetailsDTO newUser = userServiceImpl.createUser(user);

        return ResponseEntity.ok(newUser);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<UserDetailsDTO> getUser(@PathVariable("id") int userId) {
        UserDetailsDTO userDetailsDTO = userServiceImpl.getUser(userId);

        return ResponseEntity.ok(userDetailsDTO);
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDetailsDTO>> getAllUsers() {
        List<UserDetailsDTO> users = userServiceImpl.getAllUsers();

        return ResponseEntity.ok(users);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<UserDetailsDTO> modifyUser(@PathVariable("id") int userId,
                                                     @RequestBody UpdateUserDTO updateUserDTO) {
        UserDetailsDTO modifiedUser = userServiceImpl.modifyUser(userId, updateUserDTO);

        return ResponseEntity.ok(modifiedUser);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") int userId) {
        userServiceImpl.deleteUser(userId);

        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> signin(@RequestBody UserCredentialsDTO userCredentialsDTO) {
        boolean loggedin = userServiceImpl.signin(userCredentialsDTO);

        return ResponseEntity.ok(loggedin);
    }

}
