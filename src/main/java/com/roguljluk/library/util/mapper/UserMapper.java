package com.roguljluk.library.util.mapper;

import com.roguljluk.library.model.User;
import com.roguljluk.library.model.dto.UserCreationDTO;
import com.roguljluk.library.model.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);
    User userCreationDTOToUser(UserCreationDTO userCreationDTO);
    List<UserDTO> userDTOsToUsers(List<User> users);
}
