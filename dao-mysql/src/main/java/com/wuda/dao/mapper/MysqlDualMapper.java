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

    /**
     * 执行select 1语句.
     *
     * @return 数字1
     */
    @Select("select 1 from dual")
    Integer ping();
}
