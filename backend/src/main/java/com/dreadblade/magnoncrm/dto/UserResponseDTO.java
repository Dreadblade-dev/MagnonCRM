package com.dreadblade.magnoncrm.dto;

import com.dreadblade.magnoncrm.model.Role;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseDTO {
    private Integer id;
    private String username;
    private String email;
    List<Role> roles;
}
