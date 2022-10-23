package com.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.helper.exception.UnauthorizedException;
import com.domain.helper.utility.Bcrypt;
import com.domain.helper.utility.JwtTokenUtil;
import com.domain.model.entity.User;
import com.domain.model.repository.UserRepository;

@Service
public class UserService {

  @Autowired
	private UserRepository userRepository;

  public Boolean findOneByEmail(String email) {
    return userRepository.existsByEmail(email);
  }

  public User createUser(User user) {
    String hashed_password = Bcrypt.hashPassword(user.getPassword());
    user.setPassword(hashed_password);
		return userRepository.save(user);
	}	

  public User findUserAndValidate(User user) {
    User userData = userRepository.findByEmail(user.getEmail());

    if (userData == null) {
      throw new UnauthorizedException("Username or password is Invalid");
    }
    
    Boolean isPasswordCorrect = Bcrypt.checkPassword(user.getPassword(), userData.getPassword());

    if (!isPasswordCorrect) {
      throw new UnauthorizedException("Username or password is Invalid");
    }
    return userData;
  }

  public String generateAccessToken(User user) {
    User userData = userRepository.findByEmail(user.getEmail());
    System.out.println(userData);

    String Token = JwtTokenUtil.generateToken(userData);

    return Token;
  }
}
