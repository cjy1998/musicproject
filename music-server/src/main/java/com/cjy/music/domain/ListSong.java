package com.cjy.music.domain;

import java.io.Serializable;
//歌曲歌单
public class ListSong implements Serializable {
    private  Integer id;
    private Integer songId;
    private  Integer songListId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongID(Integer songID) {
        this.songId = songID;
    }

    public Integer getSongListId() {
        return songListId;
    }

    public void setSongListId(Integer songListId) {
        this.songListId = songListId;
    }
}
