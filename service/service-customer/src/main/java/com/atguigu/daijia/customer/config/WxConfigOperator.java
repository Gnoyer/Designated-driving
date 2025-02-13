package com.atguigu.daijia.customer.config;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.impl.WxMaServiceImpl;
import cn.binarywang.wx.miniapp.config.WxMaConfig;
import cn.binarywang.wx.miniapp.config.impl.WxMaDefaultConfigImpl;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 创建微信工具包对象
 */

@Component
public class WxConfigOperator {

    @Resource
    private WxConfigProperties wxConfigProperties;

    @Bean
    public WxMaService wxMaService() {

        //微信小程序id和秘钥
        WxMaDefaultConfigImpl wxMaConfig = new WxMaDefaultConfigImpl();
        wxMaConfig.setAppid(wxConfigProperties.getAppId());
        wxMaConfig.setSecret(wxConfigProperties.getSecret());

        //创建微信工具包对象并设置配置信息
        WxMaService service = new WxMaServiceImpl();
        service.setWxMaConfig(wxMaConfig);
        return service;
    }
}
