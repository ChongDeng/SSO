package com.example.demo.common;

public class PageParams {
  
  private static final Integer PAGE_SIZE = 5;
  
  private Integer pageSize = PAGE_SIZE;
  private Integer pageIndex  = 1; //起始页为1，不是0

  //下面这两行决定了真正要搜索的数据
  private Integer offset;
  private Integer limit;
  
  public static PageParams build(){
    return build(PAGE_SIZE, 1);
  }
  
  public static PageParams build(Integer pageSize, Integer pageIndex){
    if (pageSize == null) {
      pageSize = PAGE_SIZE;
    }

    if (pageIndex == null) {
      pageIndex = 1;
    }

    return new PageParams(pageSize, pageIndex);
  }

  //用途： 默认为返回第一页的数据，且此时页面大小为PAGE_SIZE
  public  PageParams(){
    this(PAGE_SIZE, 1);
  }

  //用途： 搜索页面大小为pageSize时，第pageIndex页中的所有数据
  public  PageParams(Integer pageSize,Integer pageIndex) {
    assert pageSize != null;
    assert pageIndex  != null;
    this.pageSize = pageSize;
    this.pageIndex  = pageIndex;

    //下面这两行决定了“搜索页面大小为pageSize时，第pageIndex页中的所有数据”
    this.offset = pageSize * (pageIndex - 1);
    this.limit  = pageSize;
  }

  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public Integer getPageIndex() {
    return pageIndex;
  }

  public void setPageIndex(Integer pageIndex) {
    this.pageIndex = pageIndex;
  }
  

  public Integer getOffset() {
    return offset;
  }

  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  public Integer getLimit() {
    return limit;
  }

  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  @Override
  public String toString() {
    return "PageParams [pageSize=" + pageSize + ", pageIndex=" + pageIndex + "]";
  }

}
