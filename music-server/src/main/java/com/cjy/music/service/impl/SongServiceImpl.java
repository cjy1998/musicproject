package com.cjy.music.service.impl;

import com.cjy.music.dao.SongMapper;
import com.cjy.music.domain.Song;
import com.cjy.music.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//歌曲Service实现类
@Service
public class SongServiceImpl implements SongService {
    @Autowired
    private SongMapper songMapper;

    /**
     * 增加
     *
     * @param song
     */
    @Override
    public boolean insert(Song song) {
        return songMapper.insert(song)>0;
    }

    /**
     * 修改
     *
     * @param song
     */
    @Override
    public boolean update(Song song) {
        return songMapper.update(song)>0;
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public boolean delete(Integer id) {
        return songMapper.delete(id)>0;
    }

    /**
     * 根据主键查询整个对象
     *
     * @param id
     */
    @Override
    public Song selectByPrimarykey(Integer id) {
        return songMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有歌曲
     */
    @Override
    public List<Song> allSong() {
        return songMapper.allSong();
    }

    /**
     * 根据歌名查询
     *
     * @param name
     */
    @Override
    public List<Song> songOfName(String name) {
        return songMapper.songOfName(name);
    }
    /**
     * 根据歌名模糊查询
     *
     * @param name
     */
    @Override
    public List<Song> likesongOfName(String name) {
        return songMapper.likesongOfName("%"+name+"%");
    }
    /**
     * 根据歌手性别查询
     *
     * @param singerId
     */
    @Override
    public List<Song> songOfsingerId(Integer singerId) {
        return songMapper.songOfSingerId(singerId);
    }
}
