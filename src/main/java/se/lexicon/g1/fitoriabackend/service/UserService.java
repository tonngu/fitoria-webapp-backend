package se.lexicon.g1.fitoriabackend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import se.lexicon.g1.fitoriabackend.domain.dto.UserDTO;
import se.lexicon.g1.fitoriabackend.domain.dto.UserDTOView;
import se.lexicon.g1.fitoriabackend.domain.entity.User;
import se.lexicon.g1.fitoriabackend.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserDTOView registerUser(UserDTO userDTO){
        User user = User.builder()
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .password(passwordEncoder.encode(userDTO.getPassword()))
                .build();

        user = userRepository.save(user);

        return mapToDTOView(user);
    }

    public UserDTOView loginUser(UserDTO userDTO) {
        User user = userRepository.findByUsername(userDTO.getUsername());

        // If user exists and password matches
        if (user != null && passwordEncoder.matches(userDTO.getPassword(), user.getPassword())) {
            return mapToDTOView(user);  // Return the user without password
        }

        return null;  // Return null if login fails
    }

    public UserDTOView findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user != null ? mapToDTOView(user) : null;
    }

    private UserDTOView mapToDTOView(User user) {
        return UserDTOView.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

}
