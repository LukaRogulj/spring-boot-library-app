package com.roguljluk.library.service.api;

import com.roguljluk.library.model.User;
import com.roguljluk.library.model.dto.UserCreationDTO;
import com.roguljluk.library.model.dto.UserDTO;

import java.util.List;

public interface UserService {

    UserDTO createNewUser(UserCreationDTO userCreationDTO);
    UserDTO getUser(Long userId);
    UserDTO getUserByUsername(String username);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(Long userId, UserDTO userDTO);
    void deleteUser(Long userId);
}
