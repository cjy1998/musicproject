package com.cjy.mysqlCreat;

import java.util.Date;
/**
 * table name:  comment
 * author name: cjy
 * create time: 2022-03-14 09:46:37
 */ 
public class Comment{

	private Integer id;
	private Integer userId;
	private boolean type;
	private Integer songId;
	private Integer songListId;
	private String content;
	private Date createTime;
	private Integer up;

	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return id;
	}
	public void setUserId(Integer userId){
		this.userId=userId;
	}
	public Integer getUserId(){
		return userId;
	}
	public void setType(boolean type){
		this.type=type;
	}
	public boolean getType(){
		return type;
	}
	public void setSongId(Integer songId){
		this.songId=songId;
	}
	public Integer getSongId(){
		return songId;
	}
	public void setSongListId(Integer songListId){
		this.songListId=songListId;
	}
	public Integer getSongListId(){
		return songListId;
	}
	public void setContent(String content){
		this.content=content;
	}
	public String getContent(){
		return content;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setUp(Integer up){
		this.up=up;
	}
	public Integer getUp(){
		return up;
	}
}

