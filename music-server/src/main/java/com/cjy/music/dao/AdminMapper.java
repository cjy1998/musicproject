package com.cjy.music.dao;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * 管理员dao
 */
//方便service层调用
@Repository

public interface AdminMapper {
    /**
     * 验证密码是否正确
     */
    public  int verifyPassword(String username,String password);
}
