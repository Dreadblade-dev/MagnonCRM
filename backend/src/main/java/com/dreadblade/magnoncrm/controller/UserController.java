package com.dreadblade.magnoncrm.controller;

import com.dreadblade.magnoncrm.dto.UserDTO;
import com.dreadblade.magnoncrm.dto.UserResponseDTO;
import com.dreadblade.magnoncrm.model.User;
import com.dreadblade.magnoncrm.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class UserController {
    private final UserService userService;

    private final ModelMapper modelMapper;

    @Autowired
    public UserController(UserService userService, ModelMapper modelMapper) {
        this.userService = userService;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/signin")
    public String signIn(@RequestBody UserDTO userDTO) {
        return userService.signIn(userDTO.getUsername(), userDTO.getPassword());
    }

    @PostMapping("/signup")
    public String signUp(@RequestBody UserDTO user) {
        return userService.signUp(modelMapper.map(user, User.class));
    }

    @PostMapping("/signout")
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
    public String signOut(HttpServletRequest request) {
        return userService.refresh(request.getRemoteUser());
    }

    @DeleteMapping(value = "/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public String delete(@PathVariable String username) {
        userService.delete(username);
        return username;
    }

    @GetMapping(value = "/{username}")
    @PreAuthorize("hasRole('ADMIN')")
    public UserResponseDTO search(@PathVariable String username) {
        return modelMapper.map(userService.search(username), UserResponseDTO.class);
    }

    @GetMapping(value = "/me")
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
    public UserResponseDTO whoami(HttpServletRequest req) {
        return modelMapper.map(userService.whoami(req), UserResponseDTO.class);
    }

    @GetMapping("/refresh")
    @PreAuthorize("hasRole('ADMIN') or hasRole('CLIENT')")
    public String refresh(HttpServletRequest request) {
        return userService.refresh(request.getRemoteUser());
    }
}
