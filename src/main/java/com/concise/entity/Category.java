package com.concise.entity;

import javax.persistence.*;

/**
 * Created by 刘印龙 on 2015/5/5.
 */
@Entity
@Table(name = "blog_category", schema = "", catalog = "rn00ri83hjzw9ci0")
public class Category {
    private int id;
    private String title;
    private String alias;
    private int parentId;

    private Category parent;

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
    @Column(name = "alias", nullable = false, insertable = true, updatable = true, length = 255)
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    @Basic
    @Column(name = "parentId", nullable = false, insertable = true, updatable = true)
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Transient
    public Category getParent() {
        return parent;
    }

    public void setParent(Category parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (parentId != category.parentId) return false;
        if (title != null ? !title.equals(category.title) : category.title != null) return false;
        if (alias != null ? !alias.equals(category.alias) : category.alias != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (alias != null ? alias.hashCode() : 0);
        result = 31 * result + parentId;
        return result;
    }
}
