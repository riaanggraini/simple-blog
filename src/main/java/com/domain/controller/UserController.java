package com.domain.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.domain.DTO.TokenDto;
import com.domain.helper.exception.DuplicateException;
import com.domain.helper.exception.ResponseHandler;
import com.domain.model.entity.User;
import com.domain.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {

  @Autowired
	private UserService userService;

  @PostMapping
  public ResponseEntity register(@Valid @RequestBody User user) throws Exception{
    Boolean isUserExist = userService.findOneByEmail(user.getEmail());
    if (isUserExist) {
      throw new DuplicateException("Username Already Exist");
    }
    userService.createUser(user);
    return ResponseHandler.generateResponse("Registration Successfully", null);
  };

  @PostMapping("/login")
  public ResponseEntity login(@Valid @RequestBody User user) throws Exception{
    User userValidate = userService.findUserAndValidate(user);
    String token = userService.generateAccessToken(userValidate);

    TokenDto data = new TokenDto();
    data.setUserId(userValidate.getId());
    data.setToken(token);

    return ResponseHandler.generateResponse("Login Successfully", data);
  };
}
