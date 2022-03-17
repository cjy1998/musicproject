package com.cjy.music.dao;

import com.cjy.music.domain.Collect;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 收藏dao
 */
//方便service层调用
@Repository
public interface CollectMapper {
    /**
     * 增加
     */
    public  int insert(Collect collect);

    /**
     * 删除
     */
    public  int delete(Integer id);

    public int deleteUserIdSongId(@Param("userId") Integer userId,@Param("songId") Integer songId);

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
    public int existSongId(@Param("userId") Integer userId,@Param("songId") Integer songId);

}
