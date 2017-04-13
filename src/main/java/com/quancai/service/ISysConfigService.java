package com.quancai.service;

import com.quancai.entity.TSysConfig;

import java.util.List;

/**
 * Created by kenzh on 2017/4/12.
 */
public interface ISysConfigService {
    /**
     * 获取所有的配置参数
     * @return
     */
    List<TSysConfig> getConfigs();


    /**
     * 获取配置
     * @return
     */
    TSysConfig getConfig(String code);
}
