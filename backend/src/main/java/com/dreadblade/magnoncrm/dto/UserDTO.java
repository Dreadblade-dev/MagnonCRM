package com.dreadblade.magnoncrm.dto;

import com.dreadblade.magnoncrm.model.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDTO {
    private String username;
    private String email;
    private String password;
    Set<Role> roles;
}
