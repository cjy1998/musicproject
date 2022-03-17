package com.cjy.music.service;

import com.cjy.music.domain.Song;

import java.util.List;

/**
 * 歌曲service接口
 */
public interface SongService {
    /**
     * 增加
     */
    public  boolean insert(Song song);
    /**
     * 修改
     */
    public  boolean update(Song song);
    /**
     * 删除
     */
    public  boolean delete(Integer id);
    /**
     * 根据主键查询整个对象
     */
    public  Song selectByPrimarykey(Integer id);
    /**
     * 查询所有歌曲
     */
    public List<Song> allSong();
    /**
     * 根据歌名查询
     */
    public List<Song> songOfName(String name);
    /**
     * 根据歌名模糊查询
     */
    public List<Song> likesongOfName(String name);
    /**
     * 根据歌手性别查询
     */
    public List<Song> songOfsingerId(Integer singerId);
}
