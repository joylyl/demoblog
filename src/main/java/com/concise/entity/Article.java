package com.concise.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by 刘印龙 on 2015/5/5.
 */
@Entity
@Table(name = "blog_article", schema = "", catalog = "rn00ri83hjzw9ci0")
public class Article {
    private int id;
    private String title;
    private String content;
    private String description;
    private String tags;
    private int cateid;
    private int isrecover;
    private String staticurl;
    private String createtime;
    private String contentSource;
    private int view;
    private int commentNum;

    private Category category;
    private List<Tag> tagList;

    @Transient
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Transient
    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    @Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = false, insertable = true, updatable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "tags", nullable = true, insertable = true, updatable = true, length = 255)
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @Basic
    @Column(name = "cateid", nullable = false, insertable = true, updatable = true)
    public int getCateid() {
        return cateid;
    }

    public void setCateid(int cateid) {
        this.cateid = cateid;
    }

    @Basic
    @Column(name = "isrecover", nullable = false, insertable = true, updatable = true)
    public int getIsrecover() {
        return isrecover;
    }

    public void setIsrecover(int isrecover) {
        this.isrecover = isrecover;
    }

    @Basic
    @Column(name = "staticurl", nullable = true, insertable = true, updatable = true, length = 255)
    public String getStaticurl() {
        return staticurl;
    }

    public void setStaticurl(String staticurl) {
        this.staticurl = staticurl;
    }

    @Basic
    @Column(name = "createtime", nullable = false, insertable = true, updatable = true)
    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    @Basic
    @Column(name = "contentSource", nullable = true, insertable = true, updatable = true, length = 65535)
    public String getContentSource() {
        return contentSource;
    }

    public void setContentSource(String contentSource) {
        this.contentSource = contentSource;
    }

    @Basic
    @Column(name = "view", nullable = false, insertable = true, updatable = true)
    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }

    @Basic
    @Column(name = "commentNum", nullable = false, insertable = true, updatable = true)
    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Article article = (Article) o;

        if (id != article.id) return false;
        if (cateid != article.cateid) return false;
        if (isrecover != article.isrecover) return false;
        if (view != article.view) return false;
        if (commentNum != article.commentNum) return false;
        if (title != null ? !title.equals(article.title) : article.title != null) return false;
        if (content != null ? !content.equals(article.content) : article.content != null) return false;
        if (description != null ? !description.equals(article.description) : article.description != null) return false;
        if (tags != null ? !tags.equals(article.tags) : article.tags != null) return false;
        if (staticurl != null ? !staticurl.equals(article.staticurl) : article.staticurl != null) return false;
        if (createtime != null ? !createtime.equals(article.createtime) : article.createtime != null) return false;
        if (contentSource != null ? !contentSource.equals(article.contentSource) : article.contentSource != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + cateid;
        result = 31 * result + isrecover;
        result = 31 * result + (staticurl != null ? staticurl.hashCode() : 0);
        result = 31 * result + (createtime != null ? createtime.hashCode() : 0);
        result = 31 * result + (contentSource != null ? contentSource.hashCode() : 0);
        result = 31 * result + view;
        result = 31 * result + commentNum;
        return result;
    }
}
