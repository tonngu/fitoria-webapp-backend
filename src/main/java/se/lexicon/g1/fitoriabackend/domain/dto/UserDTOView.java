package se.lexicon.g1.fitoriabackend.domain.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserDTOView {
    private Long id;
    private String username;
    private String email;
}
