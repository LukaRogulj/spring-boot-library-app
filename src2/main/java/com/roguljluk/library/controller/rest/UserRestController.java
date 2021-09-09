package com.roguljluk.library.controller.rest;

import com.roguljluk.library.model.dto.UserCreationDTO;
import com.roguljluk.library.model.dto.UserDTO;
import com.roguljluk.library.service.api.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDTO>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping(value = "/")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserCreationDTO userCreationDTO){
        return ResponseEntity.ok(userService.createNewUser(userCreationDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@NotNull @PathVariable Long id){
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@NotNull @PathVariable Long id, @RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.updateUser(id, userDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@NotNull @PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok(null);
    }
}
