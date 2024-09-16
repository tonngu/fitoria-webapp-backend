package se.lexicon.g1.fitoriabackend.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDTO {
    private String username;
    private String email;
    private String password;
}
