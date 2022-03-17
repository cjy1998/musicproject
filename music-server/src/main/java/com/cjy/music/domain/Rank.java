package com.cjy.music.domain;
//评价
public class Rank{

    private Integer id;
    private Integer songListId;
    private Integer consumerId;
    private Integer score;

    public void setId(Integer id){
        this.id=id;
    }
    public Integer getId(){
        return id;
    }
    public void setSongListId(Integer songListId){
        this.songListId=songListId;
    }
    public Integer getSongListId(){
        return songListId;
    }
    public void setConsumerId(Integer consumerId){
        this.consumerId=consumerId;
    }
    public Integer getConsumerId(){
        return consumerId;
    }
    public void setScore(Integer score){
        this.score=score;
    }
    public Integer getScore(){
        return score;
    }
}

