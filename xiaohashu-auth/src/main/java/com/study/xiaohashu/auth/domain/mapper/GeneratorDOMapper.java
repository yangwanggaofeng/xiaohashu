package com.study.xiaohashu.auth.domain.mapper;

import com.study.xiaohashu.auth.domain.dataobject.GeneratorDO;

public interface GeneratorDOMapper {
    int deleteByPrimaryKey(Long id);

    int insert(GeneratorDO record);

    int insertSelective(GeneratorDO record);

    GeneratorDO selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(GeneratorDO record);

    int updateByPrimaryKey(GeneratorDO record);
}