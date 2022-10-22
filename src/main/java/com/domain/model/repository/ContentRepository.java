package com.domain.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.domain.model.entity.Content;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long>{
  
}
