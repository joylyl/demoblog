package com.concise.entity;

import javax.persistence.*;

/**
 * Created by 刘印龙 on 2015/5/5.
 */
@Entity
@Table(name = "blog_comment", schema = "", catalog = "rn00ri83hjzw9ci0")
public class Comment {
    private int id;
    private String content;
    private int parentId;
    private int articleId;
    private String userName;
    private String userEmail;
    private String userLink;
    private int isrecover;

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "content", nullable = false, insertable = true, updatable = true, length = 65535)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "parentId", nullable = false, insertable = true, updatable = true)
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Basic
    @Column(name = "articleId", nullable = false, insertable = true, updatable = true)
    public int getArticleId() {
        return articleId;
    }

    public void setArticleId(int articleId) {
        this.articleId = articleId;
    }

    @Basic
    @Column(name = "userNeme", nullable = false, insertable = true, updatable = true, length = 255)
    public String getUserNeme() {
        return userName;
    }

    public void setUserNeme(String userNeme) {
        this.userName = userNeme;
    }

    @Basic
    @Column(name = "userEmail", nullable = false, insertable = true, updatable = true, length = 255)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "userLink", nullable = false, insertable = true, updatable = true, length = 255)
    public String getUserLink() {
        return userLink;
    }

    public void setUserLink(String userLink) {
        this.userLink = userLink;
    }

    @Basic
    @Column(name = "isrecover", nullable = false, insertable = true, updatable = true)
    public int getIsrecover() {
        return isrecover;
    }

    public void setIsrecover(int isrecover) {
        this.isrecover = isrecover;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (id != comment.id) return false;
        if (parentId != comment.parentId) return false;
        if (articleId != comment.articleId) return false;
        if (isrecover != comment.isrecover) return false;
        if (content != null ? !content.equals(comment.content) : comment.content != null) return false;
        if (userName != null ? !userName.equals(comment.userName) : comment.userName != null) return false;
        if (userEmail != null ? !userEmail.equals(comment.userEmail) : comment.userEmail != null) return false;
        if (userLink != null ? !userLink.equals(comment.userLink) : comment.userLink != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + parentId;
        result = 31 * result + articleId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userEmail != null ? userEmail.hashCode() : 0);
        result = 31 * result + (userLink != null ? userLink.hashCode() : 0);
        result = 31 * result + isrecover;
        return result;
    }
}
