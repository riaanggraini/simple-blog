package com.domain.model.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
@Entity
@Table(name="content")
public class Content implements Serializable{
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
	@Size(min = 2, message = "Title should have at least 2 characters")
  private String title;

  @NotEmpty
  @Column(columnDefinition="text")
	@Size(min = 2, message = "Content should have at least 2 characters")
  private String content;

  private int viewed_times;

  @Column(name = "created_at")
  private Date created_at;
  
  @Column(name = "updated_at")
  private Date updated_at;

  @Column(name = "updated_by")
  private int updated_by;

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
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

  public Date getCreated_at() {
    return created_at;
  }

  public void setCreated_at(Date created_at) {
    this.created_at = created_at;
  }

  public Date getUpdated_at() {
    return updated_at;
  }
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "posted_by", referencedColumnName = "id", insertable = false, updatable = false)
  public User user;

  @OneToMany(mappedBy = "content")
  private List<Comment> comment;

  public List<Comment> getComment() {
    return comment;
  }

  public void setComment(List<Comment> comment) {
    this.comment = comment;
  }

  public void setUpdated_at(Date updated_at) {
    this.updated_at = updated_at;
  }
  public Content() {
  }

  public Content(Long id, String title, String content, int viewed_times, int user_id, Date created_at, Date updated_at, int created_by, int updated_by, User user, List<Comment> comment) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.viewed_times = viewed_times;
    this.user = user;
    this.created_at = created_at;
    this.updated_at = updated_at;
    this.comment = comment;
    this.updated_by = updated_by;
  }

}
