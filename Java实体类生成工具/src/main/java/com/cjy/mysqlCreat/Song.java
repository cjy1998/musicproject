package com.cjy.mysqlCreat;

import java.util.Date;
import java.sql.*;
/**
 * table name:  song
 * author name: cjy
 * create time: 2022-01-23 13:58:27
 */ 
public class Song{

	private Integer id;
	private Integer singerId;
	private String name;
	private String introduction;
	private Date createTime;
	private Date updateTime;
	private String pic;
	private String lyric;
	private String url;

	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return id;
	}
	public void setSingerId(Integer singerId){
		this.singerId=singerId;
	}
	public Integer getSingerId(){
		return singerId;
	}
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	public void setIntroduction(String introduction){
		this.introduction=introduction;
	}
	public String getIntroduction(){
		return introduction;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setUpdateTime(Date updateTime){
		this.updateTime=updateTime;
	}
	public Date getUpdateTime(){
		return updateTime;
	}
	public void setPic(String pic){
		this.pic=pic;
	}
	public String getPic(){
		return pic;
	}
	public void setLyric(String lyric){
		this.lyric=lyric;
	}
	public String getLyric(){
		return lyric;
	}
	public void setUrl(String url){
		this.url=url;
	}
	public String getUrl(){
		return url;
	}
}

