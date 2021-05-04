package com.stef.ssm.config;

import com.alibaba.nacos.api.annotation.NacosInjected;
import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.api.naming.NamingService;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import com.alibaba.nacos.spring.context.annotation.discovery.EnableNacosDiscovery;
import com.stef.ssm.utils.NetworkUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.annotation.PostConstruct;

@Configuration
@PropertySource("classpath:nacos-application.properties")
@EnableNacosDiscovery(globalProperties = @NacosProperties)
@EnableNacosConfig(globalProperties = @NacosProperties)
@NacosPropertySource(dataId = "common.properties", autoRefreshed = true)
public class NacosConfiguration {

    //获取配置文件里服务端口
    @Value("${server.port}")
    private int serverPort;
    //获取配置文件里服务名
    @Value("${spring.application.name}")
    private String applicationName;

    // 注入 Nacos 的 NamingService 实例
    @NacosInjected
    private NamingService namingService;

    @PostConstruct
    public void registerInstance() throws Exception {

        // 通过Nacos Open API 向 Nacos Server 注册一个名称为applicationName的服务
        namingService.registerInstance(applicationName, NetworkUtil.getLocalIp(), serverPort);
    }

}
