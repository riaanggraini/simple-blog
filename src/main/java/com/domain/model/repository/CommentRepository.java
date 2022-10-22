package com.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.model.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{
  
}
