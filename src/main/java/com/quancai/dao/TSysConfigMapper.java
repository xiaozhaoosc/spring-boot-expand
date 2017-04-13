package com.quancai.dao;

import com.quancai.entity.Criteria;
import com.quancai.entity.TSysConfig;

import java.util.List;

public interface TSysConfigMapper {
    /**
     * 根据条件查询记录总数
     */
    int count(TSysConfig example);

    /**
     * 根据主键删除记录
     */
    int remove(String code);

    /**
     * 保存属性不为空的记录
     */
    int save(TSysConfig record);

    /**
     * 根据条件查询记录集
     */
    List<TSysConfig> listByPramas(TSysConfig example);

    /**
     * 根据主键查询记录
     */
    TSysConfig getByPramas(String code);

    /**
     * 根据主键更新属性不为空的记录
     */
    int updateById(TSysConfig record);
}