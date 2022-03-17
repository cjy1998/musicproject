package com.cjy.music.service.impl;

import com.cjy.music.dao.ListSongMapper;
import com.cjy.music.dao.SongMapper;
import com.cjy.music.domain.ListSong;
import com.cjy.music.service.ListSongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//歌单里面的歌曲Service实现类
@Service
public class ListSongServiceImpl implements ListSongService {
@Autowired
    private ListSongMapper listsongMapper;
    /**
     * 增加
     *
     * @param listSong
     */
    @Override
    public boolean insert(ListSong listSong) {
        return listsongMapper.insert(listSong) > 0;
    }

    /**
     * 修改
     *
     * @param listSong
     */
    @Override
    public boolean update(ListSong listSong) {
        return listsongMapper.update(listSong) > 0;
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public boolean delete(Integer id) {
        return listsongMapper.delete(id) > 0;
    }

    @Override
    public boolean deleteBySongIdAndSongListId(Integer songId, Integer songListId) {
        return listsongMapper.deleteBySongIdAndSongListId(songId,songListId) > 0;
    }

    /**
     * 根据主键查询整个对象
     *
     * @param id
     */
    @Override
    public ListSong selectByPrimaryKey(Integer id) {
        return listsongMapper.selectByPrimaryKey(id) ;
    }

    /**
     * 查询所有歌单里歌曲
     */
    @Override
    public List<ListSong> allListSong() {
        return listsongMapper.allListSong();
    }

    /**
     * 根据歌单id查询所有该歌单下的歌曲
     *
     * @param songListId
     */
    @Override
    public List<ListSong> listSongOfSongListId(Integer songListId) {
        return listsongMapper.listSongOfSongListId(songListId);
    }
}
