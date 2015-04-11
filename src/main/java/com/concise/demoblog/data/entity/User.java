package com.concise.demoblog.data.entity;

/**
 * 用户信息
 * @author 刘印龙
 */
public class User {

	private Integer id;
	private String name;
	private String password;
	private String photo;
	private String description;
	
	public User() {	}

	public User(Integer id, String name, String password, String photo,
			String description) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.photo = photo;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
