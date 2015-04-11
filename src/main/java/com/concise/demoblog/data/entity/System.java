	package com.concise.demoblog.data.entity;

/**
 * 系统信息表
 * @author 刘印龙
 */
public class System {

	private String title;//标题
	private String key;//站点关键字(meta标签内)
	private String description;//站点描述,同上
	private String icp;//ICP备案信息
	private String seo;//seo优化信息
	private Integer readonly;//是否可以删除
	private String url;
	
	public System() {}

	public System(String title, String key, String description, String icp,
			String seo, Integer readonly, String url) {
		super();
		this.title = title;
		this.key = key;
		this.description = description;
		this.icp = icp;
		this.seo = seo;
		this.readonly = readonly;
		this.url = url;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIcp() {
		return icp;
	}

	public void setIcp(String icp) {
		this.icp = icp;
	}

	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public Integer getReadonly() {
		return readonly;
	}

	public void setReadonly(Integer readonly) {
		this.readonly = readonly;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
