package com.domain.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User implements Serializable{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  @NotEmpty
  @Size(min = 2, message = "Name should have at least 2 characters")
  private String name;

  @Column(name = "email", nullable = false)
  @NotEmpty
  @Size(min = 2, message = "Email should have at least 2 characters")
	@Email
  private String email;
  
  @NotEmpty( message = "Paswword cant be empty")
  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "created_at")
  private Date created_at;
  
  @Column(name = "updated_at")
  private Date updated_at;

  public Date getCreated_at() {
    return created_at;
  }

  public void setCreated_at(Date created_at) {
    this.created_at = created_at;
  }

  public Date getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(Date updated_at) {
    this.updated_at = updated_at;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public User() {
  }
  
  public User(Long id, String name) {
    this.id = id;
    this.name = name;
  }

  public User orElseThrow(Object object) {
    return null;
  }
}
