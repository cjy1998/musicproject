package com.cjy.music.service;

import com.cjy.music.domain.Rank;

/**
 * 评价service层接口
 */
public interface RankService {
    /**
     *增加
     */
    public boolean insert(Rank rank);

    /**
     * 查询总分
     */
    public int selectScoreSum(Integer songListId) ;

    /**
     *评分人数
     */
    public int selectRankNum(Integer songListId);
    /**
     * 计算平均分
     */
    public int rankOfSongListId(Integer songListId);

}
