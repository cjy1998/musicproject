package com.cjy.music.domain;

import java.awt.*;
import java.io.Serializable;
import java.util.Date;

public class Collect implements Serializable {

    private Integer id;
    private Integer userId;
    private Byte type;
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
    public void setType(Byte type){
        this.type=type;
    }
    public Byte getType(){
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
