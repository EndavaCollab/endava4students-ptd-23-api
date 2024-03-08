package travel.journal.api.controller;



import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import travel.journal.api.payload.request.LoginRequest;
import travel.journal.api.payload.response.JwtResponse;
import travel.journal.api.security.jwt.JwtUtils;
import travel.journal.api.security.services.UserDetailsImpl;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/auth")
public class AuthController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;


    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();


        return ResponseEntity.ok(new JwtResponse(jwt));
    }
    @GetMapping("/test")
    public ResponseEntity<?> test() {
        return ResponseEntity.ok("Acesta este un test securizat");
    }

}
