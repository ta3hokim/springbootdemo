package com.personal.personaldemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;


@Configuration
public class JasyptConfig {

    // Bean 안의 문자열이 application설정 파일에서 적은 jasypt.encryptor.bean과 일치해야함
    @Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor(){
        String key = "1u9aP4leItePGF2VSwNbSEmIMCnZ9ZJq9Ul01UkCPt9cOOgLwPPVcaCyVDgxBKLM";
        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(key); //encrypt key
        config.setAlgorithm("PBEWITHMD5ANDDES");
        config.setPoolSize("1");
        // 실행시킬때마다 랜덤하게 되버림
        // config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);
        return encryptor;
    }
}
