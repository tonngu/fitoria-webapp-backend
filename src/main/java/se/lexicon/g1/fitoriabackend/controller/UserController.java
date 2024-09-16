package se.lexicon.g1.fitoriabackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.lexicon.g1.fitoriabackend.domain.dto.UserDTO;
import se.lexicon.g1.fitoriabackend.domain.dto.UserDTOView;
import se.lexicon.g1.fitoriabackend.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Register new user

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO){
        if (userService.findByUsername(userDTO.getUsername()) != null) {
            return ResponseEntity.badRequest().body("Username already exists");
        }

        userService.registerUser(userDTO);
        return ResponseEntity.ok("User registered successfully");
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<UserDTOView> loginUser(@RequestBody UserDTO userDTO) {
        UserDTOView loggedInUser = userService.loginUser(userDTO);
        if (loggedInUser != null) {
            return ResponseEntity.ok(loggedInUser);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
