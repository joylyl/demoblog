package com.concise.demoblog.data.entity;

/**
 * 文章类别
 * @author 刘印龙
 */
public class Category {

	private Integer id;
	private String title;
	private Integer parentId;
	
	public Category() {	}

	public Category(Integer id, String title, Integer parentId) {
		super();
		this.id = id;
		this.title = title;
		this.parentId = parentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
}
