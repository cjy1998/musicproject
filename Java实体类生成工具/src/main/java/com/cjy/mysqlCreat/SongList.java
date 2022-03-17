package com.cjy.mysqlCreat;

/**
 * table name:  song_list
 * author name: cjy
 * create time: 2022-01-27 09:16:06
 */ 
public class SongList{

	private Integer id;
	private String title;
	private String pic;
	private String introduction;
	private String style;

	public void setId(Integer id){
		this.id=id;
	}
	public Integer getId(){
		return id;
	}
	public void setTitle(String title){
		this.title=title;
	}
	public String getTitle(){
		return title;
	}
	public void setPic(String pic){
		this.pic=pic;
	}
	public String getPic(){
		return pic;
	}
	public void setIntroduction(String introduction){
		this.introduction=introduction;
	}
	public String getIntroduction(){
		return introduction;
	}
	public void setStyle(String style){
		this.style=style;
	}
	public String getStyle(){
		return style;
	}
}

