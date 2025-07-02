package com.study.xiaohashu.auth.domain.mapper;

import com.study.xiaohashu.auth.domain.dataobject.UserDO;
import org.apache.ibatis.annotations.Param;

public interface UserDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserDO record);

    int insertSelective(UserDO record);

    UserDO selectByPrimaryKey(Long id);

    /**
     * 根据手机号查询记录
     * @param schema 当前schema
     * @param phone 手机号
     * @return
     */
    UserDO selectByPhone(@Param("schema") String schema ,
                         @Param("phone") String phone);

    int updateByPrimaryKeySelective(UserDO record);

    int updateByPrimaryKey(UserDO record);

}