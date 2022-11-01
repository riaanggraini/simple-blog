package com.domain.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.domain.helper.exception.ResponseHandler;
import com.domain.model.entity.Comment;
import com.domain.service.CommentService;

@RestController
@RequestMapping("api/comment")
public class CommentController {

  @Autowired
	private CommentService commentService;

  @PostMapping("/{contentId}")
  public ResponseEntity create(@PathVariable (value = "contentId") long id, @Valid @RequestBody Comment comment) throws Exception{
    commentService.createComment(comment, id);
    return ResponseHandler.generateResponse("Successfully Create Content", null);
  }
}
