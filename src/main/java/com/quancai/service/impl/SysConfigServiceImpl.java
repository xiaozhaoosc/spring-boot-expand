package com.quancai.service.impl;

import com.quancai.dao.TSysConfigMapper;
import com.quancai.entity.TSysConfig;
import com.quancai.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kenzh on 2017/4/12.
 */
@Service
public class SysConfigServiceImpl implements ISysConfigService {

    @Autowired
    private TSysConfigMapper sysConfigMapper;

    /**
     * 获取所有的配置参数
     *
     * @return
     */
    @Override
    public List<TSysConfig> getConfigs() {
        TSysConfig sysConfig = new TSysConfig();
        return sysConfigMapper.listByPramas(sysConfig);
    }

    /**
     * 获取配置
     *
     * @param code
     * @return
     */
    @Override
    public TSysConfig getConfig(String code) {
        return sysConfigMapper.getByPramas(code);
    }
}
