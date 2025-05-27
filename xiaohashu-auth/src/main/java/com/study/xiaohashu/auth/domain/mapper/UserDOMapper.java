package com.study.xiaohashu.auth.domain.mapper;

import com.study.xiaohashu.auth.domain.dataobject.UserDO;

/**
 * @ClassName UserMapper
 * @Description TODO
 * @Author zhang
 * @Date 2024/12/18
 * @Version 1.0
 **/
public interface UserDOMapper {
    /**
     * 根据主键Id查询
     */
    UserDO selectByPrimaryKey(Long id);
    /**
     * 插入记录
     * @param record
     * @return
     */
    int insert(UserDO record);
}
