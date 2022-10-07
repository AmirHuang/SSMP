package com.example.utils;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CodeUtils {
    private String[] patch = {"000000", "00000", "0000", "000", "00", "0", ""};

    public String generator(String tele){
        int hash = tele.hashCode();
        int encryption = 20221006;
        long result = hash ^ encryption;
        long nowtime = System.currentTimeMillis();
        result = result ^ nowtime;
        long code = result % 1000000;
        code = code < 0 ? -code : code;
        String codeStr = code + "";
        int len = codeStr.length();
        return patch[len] + codeStr;
    }

    @Cacheable(value = "smsCode", key = "#tele")
    public String get(String tele){
        return null;
    }

//    public static void main(String[] args) {
//        for (int i =0; i < 1000; i++){
//            System.out.println(new CodeUtils().generator("18812341234"));
//        }
//
//    }
}
