package com.cjy.music.domain;

import java.util.Date;

public class Comment {
    private Integer id;
        private Integer userId;
        private Byte type;
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

