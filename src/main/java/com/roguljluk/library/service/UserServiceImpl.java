package com.roguljluk.library.service;

import com.roguljluk.library.model.User;
import com.roguljluk.library.model.dto.UserCreationDTO;
import com.roguljluk.library.model.dto.UserDTO;
import com.roguljluk.library.repository.UserRepository;
import com.roguljluk.library.service.api.UserService;
import com.roguljluk.library.util.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO createNewUser(UserCreationDTO userCreationDTO) {
        User user = userMapper.userCreationDTOToUser(userCreationDTO);
        userRepository.save(user);
        return userMapper.userToUserDTO(user);
    }

    @Override
    public UserDTO getUser(Long userId) {
        return userMapper.userToUserDTO(userRepository.getById(userId));
    }

    @Override
    public UserDTO getUserByUsername(String username) {
        return userMapper.userToUserDTO(userRepository.findByUsername(username));
    }

    @Override
    public List<UserDTO> getAllUsers() {
        return userMapper.userDTOsToUsers(userRepository.findAll());
    }

    @Override
    public UserDTO updateUser(Long userId, UserDTO userDTO) {
        User user = userRepository.getById(userId);
        user.setAge(userDTO.getAge());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setUsername(userDTO.getUsername());

        userRepository.save(user);
        return userMapper.userToUserDTO(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
