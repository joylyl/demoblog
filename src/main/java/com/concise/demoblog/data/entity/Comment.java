package com.concise.demoblog.data.entity;

/**
 * 评论信息
 * @author 刘印龙
 */
public class Comment {

	private Integer id;//评论编号
	private String content;//评论内容
	private Integer parentId;//评论的父级(评论的评论)
	private Integer articleId;//评论的文章
	private String userName;//用户名
	private String userEmail;//邮箱
	private String userLink;//链接
	private Integer isrecover;//是否删除
	
	public Comment() {	}

	public Comment(Integer id, String content, Integer parentId,
			Integer articleId, String userName, String userEmail,
			String userLink, Integer isrecover) {
		super();
		this.id = id;
		this.content = content;
		this.parentId = parentId;
		this.articleId = articleId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userLink = userLink;
		this.isrecover = isrecover;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserLink() {
		return userLink;
	}

	public void setUserLink(String userLink) {
		this.userLink = userLink;
	}

	public Integer getIsrecover() {
		return isrecover;
	}

	public void setIsrecover(Integer isrecover) {
		this.isrecover = isrecover;
	}
}
