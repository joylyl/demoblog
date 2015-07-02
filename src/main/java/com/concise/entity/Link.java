package com.concise.entity;

import javax.persistence.*;

/**
 * Created by 刘印龙 on 2015/5/5.
 */
@Entity
@Table(name = "blog_link", schema = "", catalog = "rn00ri83hjzw9ci0")
public class Link {
    private int id;
    private String title;
    private String url;
    private int random;

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
    @Column(name = "url", nullable = false, insertable = true, updatable = true, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "random", nullable = false, insertable = true, updatable = true)
    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (id != link.id) return false;
        if (random != link.random) return false;
        if (title != null ? !title.equals(link.title) : link.title != null) return false;
        if (url != null ? !url.equals(link.url) : link.url != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + random;
        return result;
    }
}
