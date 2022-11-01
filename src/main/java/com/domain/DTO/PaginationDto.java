package com.domain.dto;

public class PaginationDto {
  int pageNo;
  String sortField;
  String sortDir;
  Object result;
  public int getPageNo() {
    return pageNo;
  }
  public String getSortField() {
    return sortField;
  }
  public void setPageNo(int pageNo) {
    this.pageNo = pageNo;
  }
  public void setSortField(String sortField) {
    this.sortField = sortField;
  }
  public void setSortDir(String sortDir) {
    this.sortDir = sortDir;
  }
  public void setResult(Object result) {
    this.result = result;
  }
  public String getSortDir() {
    return sortDir;
  }
  public Object getResult() {
    return result;
  }
}
