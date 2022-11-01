package com.domain.model.repository;

import java.util.Optional;

import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
  Boolean existsByEmail(@NotBlank String email);

  User findByEmail(String email);
}
