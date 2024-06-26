package com.personal.personaldemo;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.Level;

@Slf4j
public class JasyptTest {

    @Test
    public void jasyptTest(){
        // Log level 설정
        Logger root = (Logger)LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        root.setLevel(Level.DEBUG);
        String value = "12341234";
        String result = jasyptEncoding(value);
        log.debug("===={}====", result);
    }

    public String jasyptEncoding(String value){
        String key="1u9aP4leItePGF2VSwNbSEmIMCnZ9ZJq9Ul01UkCPt9cOOgLwPPVcaCyVDgxBKLM";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWITHMD5ANDDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);

    }
}
