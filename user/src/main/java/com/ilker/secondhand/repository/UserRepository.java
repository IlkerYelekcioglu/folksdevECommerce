package com.ilker.secondhand.repository;

import com.ilker.secondhand.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
