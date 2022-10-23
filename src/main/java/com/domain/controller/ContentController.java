package com.domain.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.domain.DTO.PaginationDto;
import com.domain.helper.exception.ResponseHandler;
import com.domain.model.entity.Content;
import com.domain.service.ContentService;


@RestController
@RequestMapping("api/content")
public class ContentController {

  @Autowired
	private ContentService contentService;

  @GetMapping("/page/{pageNo}")
  public ResponseEntity getAll(@PathVariable (value = "pageNo") int pageNo, 
    @RequestParam("sortField") String sortField,
    @RequestParam("sortDir") String sortDir,
    @RequestParam("limit") int limit,
    Content content) {

    Page<Content> page = contentService.findPaginated(pageNo, limit, sortField, sortDir);
		List<Content> listContent = page.getContent();

    PaginationDto data = new PaginationDto();

    ArrayList<Content> contents = new ArrayList<Content>();

    for (Object cont : listContent) {
      Content contentData = new Content();
      contentData.setId(((Content) cont).getId());
      contentData.setTitle(((Content) cont).getTitle());
      contentData.setViewed_times(((Content) cont).getViewed_times());
      contentData.setCreated_at(((Content) cont).getCreated_at());
      contentData.setContent(((Content) cont).getContent().substring(0, 90) + "...");
      contentData.setUser(((Content) cont).getUser());
      contents.add(contentData);
    }
    data.setPageNo(pageNo);
    data.setSortField(sortField);
    data.setSortDir(sortDir);
    data.setResult(contents);

    return ResponseHandler.generateResponse("Get Content Successfully", data);
  };

  @GetMapping("/{id}")
  public ResponseEntity getById(@PathVariable (value = "id") int id, Content content) {
    
    return null;
  }
}
