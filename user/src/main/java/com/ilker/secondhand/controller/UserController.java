package com.ilker.secondhand.controller;

import com.ilker.secondhand.dto.CreateUserRequest;
import com.ilker.secondhand.dto.UpdateUserRequest;
import com.ilker.secondhand.dto.UserDTO;
import com.ilker.secondhand.dto.UserDTOConverter;
import com.ilker.secondhand.exception.UserNotFoundException;
import com.ilker.secondhand.model.User;
import com.ilker.secondhand.service.UserService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {
   private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping()
  public ResponseEntity<List<UserDTO>> getAllUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }
  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> getUserById(@PathVariable("id") Long id){
    return ResponseEntity.ok(userService.getUserById(id));
  }

  @PostMapping
  public ResponseEntity<UserDTO> createUser(@RequestBody CreateUserRequest userRequest){
    return ResponseEntity.ok(userService.createUser(userRequest));

  }

  @PutMapping("/{id}")
  public ResponseEntity<UserDTO> updateUser(@RequestBody UpdateUserRequest updateUserRequest,@PathVariable Long id){
    return ResponseEntity.ok(userService.updateUser(id,updateUserRequest));
  }

  @PatchMapping("/{id}")
  public ResponseEntity<Void> deactiveUser(@PathVariable Long id){
    userService.deactiveUser(id);
    return ResponseEntity.ok().build();
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable Long id){
    userService.deleteUser(id);
    return ResponseEntity.ok().build();
  }
}
