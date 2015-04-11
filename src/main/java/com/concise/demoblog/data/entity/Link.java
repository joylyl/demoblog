package com.concise.demoblog.data.entity;

/**
 * 友情链接
 * @author 刘印龙
 */
public class Link {

	private Integer id;
	private String title;
	private String url;
	private Integer random;//随机显示
	
	public Link() {	}

	public Link(Integer id, String title, String url, Integer random) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.random = random;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getRandom() {
		return random;
	}

	public void setRandom(Integer random) {
		this.random = random;
	}
}
