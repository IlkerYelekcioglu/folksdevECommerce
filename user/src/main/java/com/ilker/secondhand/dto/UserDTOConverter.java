package com.ilker.secondhand.dto;

import com.ilker.secondhand.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter {

  public  UserDTO convert(User from){
    return new UserDTO(from.getMail(), from.getFirstName(), from.getFirstName(),
        from.getMiddleName());
  }
}
