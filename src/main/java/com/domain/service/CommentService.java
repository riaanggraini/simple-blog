package com.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.domain.model.entity.Comment;
import com.domain.model.repository.CommentRepository;

@Service
public class CommentService {
  @Autowired
	private CommentRepository commentRepository;

  public Comment createComment(Comment comment, long id) {
    return commentRepository.save(comment);
  }
}
