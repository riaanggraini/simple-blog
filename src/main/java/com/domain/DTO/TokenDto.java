package com.domain.DTO;

public class TokenDto {
  Long user_id;
  String token;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Long getUserId() {
    return user_id;
  }

  public void setUserId(Long user_id) {
    this.user_id = user_id;
  }
}