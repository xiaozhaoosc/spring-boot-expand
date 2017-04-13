package com.quancai.controller;

import com.quancai.entity.TSysConfig;
import com.quancai.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kenzh on 2017/4/12.
 */
@RestController
public class DemoController {

    @Autowired
    private ISysConfigService sysConfigService;

    @RequestMapping("/index")
    public String index(){
        return "Hello Word 2";
    }


    @RequestMapping("/getConfigs")
    public List getAllConfigs(){
        return sysConfigService.getConfigs();
    }

    @RequestMapping("/getConfig")
    public TSysConfig getConfig(){
        return sysConfigService.getConfig("send.email.jbi.wallet");
    }
}
