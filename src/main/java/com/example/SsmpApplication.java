package com.example;

import com.alibaba.druid.pool.DruidDataSource;
import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.example.config.ServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableCaching

// jetcache main switch
@EnableCreateCacheAnnotation
// Method cache switch
@EnableMethodCache(basePackages = "com.example")
//@EnableScheduling
public class SsmpApplication {

//    @Bean
//    @ConfigurationProperties(prefix = "datasource")
//    public DruidDataSource datasource(){
//        DruidDataSource ds = new DruidDataSource();
//        return ds;
//    }

    public static void main(String[] args) {

        ConfigurableApplicationContext ctx = SpringApplication.run(SsmpApplication.class, args);
        ServerConfig bean = ctx.getBean(ServerConfig.class);
        System.out.println(bean);

//        DruidDataSource ds = ctx.getBean(DruidDataSource.class);
//        System.out.println(ds.getDriverClassName());
//        System.out.println();

    }

}
