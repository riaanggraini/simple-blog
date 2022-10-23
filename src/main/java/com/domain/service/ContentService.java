package com.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.domain.model.entity.Content;
import com.domain.model.repository.ContentRepository;


@Service
public class ContentService {
  @Autowired
	private ContentRepository contentRepository;
  
  public List<Content> getAll() {
    return contentRepository.findAll();
  }

	public Page<Content> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
			Sort.by(sortField).descending();
		
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.contentRepository.findAll(pageable);
	}
}
