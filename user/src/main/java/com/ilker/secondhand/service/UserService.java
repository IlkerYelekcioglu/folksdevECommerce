package com.ilker.secondhand.service;

import com.ilker.secondhand.dto.CreateUserRequest;
import com.ilker.secondhand.dto.UpdateUserRequest;
import com.ilker.secondhand.dto.UserDTO;
import com.ilker.secondhand.dto.UserDTOConverter;
import com.ilker.secondhand.exception.UserNotFoundException;
import com.ilker.secondhand.model.User;
import com.ilker.secondhand.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class UserService {
private final UserRepository userRepository;
private final UserDTOConverter userDTOConverter;

  public UserService(UserRepository userRepository, UserDTOConverter userDTOConverter) {
    this.userRepository = userRepository;
    this.userDTOConverter = userDTOConverter;
  }

  public List<UserDTO> getAllUsers() {
    return userRepository.findAll().stream().map(userDTOConverter::convert).collect(
        Collectors.toList());
  }

  public UserDTO getUserById(Long id) {
   User user =  findUserById(id);
   return userDTOConverter.convert(user);
  }

  public UserDTO createUser(CreateUserRequest userRequest) {
    User user = new User(null,
        userRequest.getMail(),
        userRequest.getFirstName(),
        userRequest.getMiddleName(),
        userRequest.getLastName()
    );
    return userDTOConverter.convert(userRepository.save(user));
  }

  public UserDTO updateUser(Long id,UpdateUserRequest updateUserRequest) {
    User user = findUserById(id);
    User updatedUser = new User(user.getId(), updateUserRequest.getFirstName(), user.getMiddleName(),
        user.getLastName(), user.getMail());
    return userDTOConverter.convert(userRepository.save(updatedUser));
  }
  private User findUserById(Long id) {
   return userRepository.findById(id).orElseThrow(()->new UserNotFoundException("User couldn't be found by following id : " + id ));
  }
}
