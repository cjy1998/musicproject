package com.cjy.music.service;

import com.cjy.music.domain.Collect;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 收藏
 */
public interface CollectService {

    /**
     * 增加
     */
    public  boolean insert(Collect collect);

    /**
     * 删除
     */
    public  boolean delete(Integer id);
    public boolean deleteUserIdSongId(Integer userId, Integer songId);

    /**
     * 查询所有收藏
     */
    public List<Collect> allCollect();
    /**
     * 查询某个用户下的所有收藏
     */
    public List<Collect> collectOfUserId(Integer userId);
    /**
     * 查询某个某个用户是否收藏了某个歌曲
     */
    public boolean existSongId(@Param("userId") Integer userId, @Param("songId") Integer songId);

}
