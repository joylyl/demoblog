package com.concise.demoblog.data.entity;

import java.util.List;

/**
 * 文章信息
 * @author 刘印龙
 */
public class Article {

	private Integer id;//文章编号
	private String title;//文章标题
	private String content;//文章内容
	private String description;//文章描述
	private String tags;//文章的标签
	private Integer cateid;//文章类型
	private Integer isrecover;//是否删除
	private String staticurl;//静态的URL
	private String createtime;//创建时间
	private String contentSource;//Markdown 原文内容
	
	private Category category; 
	private List<Tag> tagList;
	
	public Article(Integer id, String title, String content,
			String description, String tags, Integer cateid, Integer isrecover,
			String staticurl, String createtime, String contentSource,
			Category category, List<Tag> tagList) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.description = description;
		this.tags = tags;
		this.cateid = cateid;
		this.isrecover = isrecover;
		this.staticurl = staticurl;
		this.createtime = createtime;
		this.contentSource = contentSource;
		this.category = category;
		this.tagList = tagList;
	}

	public Article(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public Article() {	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public Integer getCateid() {
		return cateid;
	}

	public void setCateid(Integer cateid) {
		this.cateid = cateid;
	}

	public Integer getIsrecover() {
		return isrecover;
	}

	public void setIsrecover(Integer isrecover) {
		this.isrecover = isrecover;
	}

	public String getStaticurl() {
		return staticurl;
	}

	public void setStaticurl(String staticurl) {
		this.staticurl = staticurl;
	}

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<Tag> getTagList() {
		return tagList;
	}

	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}

	public String getContentSource() {
		return contentSource;
	}

	public void setContentSource(String contentSource) {
		this.contentSource = contentSource;
	}
}
