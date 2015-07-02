package com.concise.entity;

import javax.persistence.*;

/**
 * Created by 刘印龙 on 2015/5/5.
 */
@Entity
@Table(name = "blog_system", schema = "", catalog = "rn00ri83hjzw9ci0")
public class System {
    private int id;
    private String title;
    private String key;
    private String description;
    private String icp;
    private String seo;
    private int readonly;
    private String url;

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
    @Column(name = "`key`", nullable = true, insertable = true, updatable = true, length = 500)
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Basic
    @Column(name = "description", nullable = true, insertable = true, updatable = true, length = 500)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "icp", nullable = true, insertable = true, updatable = true, length = 500)
    public String getIcp() {
        return icp;
    }

    public void setIcp(String icp) {
        this.icp = icp;
    }

    @Basic
    @Column(name = "seo", nullable = true, insertable = true, updatable = true, length = 255)
    public String getSeo() {
        return seo;
    }

    public void setSeo(String seo) {
        this.seo = seo;
    }

    @Basic
    @Column(name = "readonly", nullable = false, insertable = true, updatable = true)
    public int getReadonly() {
        return readonly;
    }

    public void setReadonly(int readonly) {
        this.readonly = readonly;
    }

    @Basic
    @Column(name = "url", nullable = false, insertable = true, updatable = true, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        System system = (System) o;

        if (id != system.id) return false;
        if (readonly != system.readonly) return false;
        if (title != null ? !title.equals(system.title) : system.title != null) return false;
        if (key != null ? !key.equals(system.key) : system.key != null) return false;
        if (description != null ? !description.equals(system.description) : system.description != null) return false;
        if (icp != null ? !icp.equals(system.icp) : system.icp != null) return false;
        if (seo != null ? !seo.equals(system.seo) : system.seo != null) return false;
        if (url != null ? !url.equals(system.url) : system.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (icp != null ? icp.hashCode() : 0);
        result = 31 * result + (seo != null ? seo.hashCode() : 0);
        result = 31 * result + readonly;
        result = 31 * result + (url != null ? url.hashCode() : 0);
        return result;
    }
}
