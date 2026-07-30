package com.hms.User.entity;

import com.hms.User.dto.Roles;
import com.hms.User.dto.RegisterRequestDTO;
import com.hms.User.dto.UserDTO;
import com.hms.User.dto.UserResponseDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    @Column(unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private Roles role;
    private Long profileId;

    public UserDTO toDTO() {
        UserDTO dto = new UserDTO();

        dto.setId(this.id);
        dto.setUsername(this.username);
        dto.setEmail(this.email);
        dto.setPassword(this.password);
        dto.setRole(this.role);
        dto.setProfileId(this.profileId);

        return dto;
    }

    public UserResponseDTO toResponseDTO() {
        UserResponseDTO dto = new UserResponseDTO();

        dto.setId(this.id);
        dto.setUsername(this.username);
        dto.setEmail(this.email);
        dto.setRole(this.role);
        dto.setProfileId(this.profileId);

        return dto;
    }

    public static User fromUserDTO(UserDTO dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        user.setProfileId(dto.getProfileId());
        return user;
    }

    public static User fromRegisterRequest(RegisterRequestDTO dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setRole(dto.getRole());
        return user;
    }
}

