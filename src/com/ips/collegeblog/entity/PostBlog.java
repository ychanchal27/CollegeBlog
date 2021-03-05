package com.ips.collegeblog.entity;

public class PostBlog {

	private Integer id;
	private Integer collegeid;
	private String title;
	private String topic;
	private String postBlog;
	public PostBlog(Integer id, Integer collegeid, String title, String topic, String postBlog) {
		super();
		this.id = id;
		this.collegeid = collegeid;
		this.title = title;
		this.topic = topic;
		this.postBlog = postBlog;
	}
	public PostBlog(Integer collegeid, String title, String topic, String postBlog) {
		super();
		this.collegeid = collegeid;
		this.title = title;
		this.topic = topic;
		this.postBlog = postBlog;
	}
	public PostBlog() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCollegeid() {
		return collegeid;
	}
	public void setCollegeid(Integer collegeid) {
		this.collegeid = collegeid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getPostBlog() {
		return postBlog;
	}
	public void setPostBlog(String postBlog) {
		this.postBlog = postBlog;
	}
	
	
}
