package com.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.domain.helper.exception.NotfoundException;
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

  public Optional<Content> getByid(long id) {
    return this.contentRepository.findById(id);
  }

  public Content createContent(Content content) {
    Content data = new Content();
    data.setTitle(content.getTitle());
    data.setContent(content.getContent());
		return contentRepository.save(content);
	}	

  public Content updateContent(Content content, Long id) {
    Boolean existing = contentRepository.existsById(id);

    if (!existing) {
      throw new NotfoundException("Content has been deleted or not found");
    }
    Content data = new Content();
    data.setId(id);
    data.setContent(content.getContent());
    data.setTitle(content.getTitle());
    return contentRepository.save(data);
  }
}
