package com.wuda.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 使用mysql dual获取信息.
 *
 * @author wuda
 */
@Mapper
public interface MysqlDualMapper {

    @Select("select 1 from dual")
    Integer ping();
}
