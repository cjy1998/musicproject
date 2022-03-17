package com.cjy.music.dao;

import com.cjy.music.domain.Rank;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 评价Dao
 */
@Repository
public interface RankMapper {
    /**
     *增加
     */
    public int insert(Rank rank);

    /**
     * 查询总分
     */
    public int selectScoreSum(Integer songListId) ;

    /**
     *评分人数
     */
    public int selectRankNum(Integer songListId);


}

