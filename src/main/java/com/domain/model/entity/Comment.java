package com.domain.model.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="comment")
public class Comment implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "comment", nullable = false)
  @NotEmpty
	@Size(min = 2, message = "content should have at least 2 characters")
  private String comment;

  @Column(name = "created_at")
  private Date created_at;
  
  @Column(name = "updated_at")
  private Date updated_at;
  
  @Column(name = "created_by")
  private int created_by;

  @Column(name = "updated_by")
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

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
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

  @ManyToOne
  @JoinColumn(name = "content_id",referencedColumnName = "id", insertable = false, updatable = false)
  private Content content;


  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "posted_by", referencedColumnName = "id", insertable = false, updatable = false)
  public User user;

  public User getUser() {
    return user;
  }
  
  public void setUser(User user) {
    this.user = user;
  }

  public Comment() {
  }

  public Comment(Long id, String comment, Date created_at, int content_id, Date updated_at, int created_by, int updated_by, User user) {
    this.id = id;
    this.comment = comment;
    this.created_by = created_by;
    this.created_at = created_at;
    this.updated_at = updated_at;
    this.user = user;
  }
}
