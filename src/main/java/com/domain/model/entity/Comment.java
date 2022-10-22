package com.domain.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String content;

  private Date created_at;
  
  private Date updated_at;

  private int created_by;

  private int updated_by;

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

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
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

  public Comment(Long id, String content, Date created_at, Date updated_at, int created_by, int updated_by) {
    this.id = id;
    this.content = content;
    this.created_by = created_by;
    this.created_at = created_at;
    this.updated_at = updated_at;
    this.updated_by = updated_by;
  }
}
