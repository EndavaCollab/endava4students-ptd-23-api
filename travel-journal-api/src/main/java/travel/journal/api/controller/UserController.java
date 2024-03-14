package travel.journal.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import travel.journal.api.dto.CreateUserDTO;
import travel.journal.api.dto.UpdateUserDTO;
import travel.journal.api.dto.UserDetailsDTO;
import travel.journal.api.service.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final UserServiceImpl userServiceImpl;

    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/saveuser")
    public ResponseEntity<?> createUser(@RequestBody CreateUserDTO user) {
        UserDetailsDTO newUser = userServiceImpl.createUser(user);
        if(newUser==null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(newUser);
    }

    
    @GetMapping("/userbyid/{id}")
    public ResponseEntity<?> getUser(@PathVariable("id") Long userId) {
        UserDetailsDTO userDetailsDTO = userServiceImpl.getUser(userId);
        if(userDetailsDTO==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userDetailsDTO);
    }

    @GetMapping("/getallusers")
    public ResponseEntity<List<UserDetailsDTO>> getAllUsers() {
        List<UserDetailsDTO> users = userServiceImpl.getAllUsers();

        return ResponseEntity.ok(users);
    }
    @PreAuthorize("isAuthenticated()")
    @PutMapping("/updateuser/{id}")
    public ResponseEntity<?> modifyUser(@PathVariable("id") Long userId,
                                                        @RequestBody UpdateUserDTO updateUserDTO) {
        UserDetailsDTO modifiedUser = userServiceImpl.modifyUser(userId, updateUserDTO);
        if(modifiedUser==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(modifiedUser);
    }
    @PreAuthorize("isAuthenticated()")
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long userId) {
        boolean deleted= userServiceImpl.deleteUser(userId);
        if(deleted){
            return ResponseEntity.ok().build();
        }
        else{
        return ResponseEntity.notFound().build();
        }
    }
}
