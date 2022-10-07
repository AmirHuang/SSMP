package com.example.service.impl;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CacheType;
import com.alicp.jetcache.anno.CreateCache;
import com.example.domain.SMSCode;
import com.example.service.SMSCodeService;
import com.example.utils.CodeUtils;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


@Service
public class SMSCodeServiceImpl implements SMSCodeService {

    @Autowired
    private CodeUtils codeUtils;

    // remote
    @CreateCache(area = "sms", name = "jetCache_", expire = 10, timeUnit = TimeUnit.SECONDS,
            cacheType = CacheType.BOTH)
    private Cache<String, String> jetCache;

    @Override
    public String sendCodeToSMS(String tele) {
        String code = codeUtils.generator(tele);
        jetCache.put(tele, code);
        return code;
    }

    @Override
    public boolean checkCode(SMSCode smsCode) {
        String code = jetCache.get(smsCode.getTele());
        return smsCode.getCode().equals(code);
    }

//    @Autowired
//    private MemcachedClient memcachedClient;
//
//    @Override
//    public String sendCodeToSMS(String tele) {
//        String code = codeUtils.generator(tele);
//
//        try {
//            memcachedClient.set(tele, 10, code);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return code;
//    }
//
//    @Override
//    public boolean checkCode(SMSCode smsCode) {
//        String code = null;
//
//        try {
//            code = memcachedClient.get(smsCode.getTele()).toString();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return smsCode.getCode().equals(code);
//    }

//    @Override
//    @CachePut(value = "smsCode", key = "#tele")
//    public String sendCodeToSMS(String tele) {
//        String code = codeUtils.generator(tele);
//        return code;
//    }
//
//    @Override
//    public boolean checkCode(SMSCode smsCode) {
//        String code = smsCode.getCode();
//        String cacheCode = codeUtils.get(smsCode.getTele());
//        return code.equals(cacheCode);
//    }
}
