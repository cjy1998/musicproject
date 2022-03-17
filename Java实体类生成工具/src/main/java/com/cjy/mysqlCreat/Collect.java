package com.cjy.mysqlCreat;

import java.util.Date;
/**
 * table name:  collect
 * author name: cjy
 * create time: 2022-03-16 11:11:38
 */ 
public class Collect{

	private Integer id;
	private Integer userId;
	private boolean type;
	private Integer songId;
	private Integer songListId;
	private Date createTime;

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
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
}

