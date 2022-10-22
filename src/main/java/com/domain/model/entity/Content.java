package com.domain.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="content")
public class Content implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String title;

  private String content;

  private int viewed_times;

  private int user_id;

  private Date created_at;
  
  private Date updated_at;

  private int created_by;

  public int getCreated_by() {
    return created_by;
  }

  public void setCreated_by(int created_by) {
    this.created_by = created_by;
  }

  public int getUpdated_by() {
    return updated_by;
  }

  public void setUpdated_by(int updated_by) {
    this.updated_by = updated_by;
  }

  private int updated_by;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public int getViewed_times() {
    return viewed_times;
  }

  public void setViewed_times(int viewed_times) {
    this.viewed_times = viewed_times;
  }

  public int getUser_id() {
    return user_id;
  }

  public void setUser_id(int user_id) {
    this.user_id = user_id;
  }

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

  public Content(Long id, String title, String content, int viewed_times, int user_id, Date created_at, Date updated_at, int created_by, int updated_by) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.viewed_times = viewed_times;
    this.user_id = user_id;
    this.created_at = created_at;
    this.updated_at = updated_at;
    this.created_by = created_by;
    this.updated_by = updated_by;
  }

}
