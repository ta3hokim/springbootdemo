package com.personal.personaldemo;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JasyptTest {

    @Test
    public void jasyptTest(){
        String value = "password";
        String result = jasyptEncoding(value);
        System.out.printf("====%s====\n", result);

    }

    public String jasyptEncoding(String value){
        String key="1u9aP4leItePGF2VSwNbSEmIMCnZ9ZJq9Ul01UkCPt9cOOgLwPPVcaCyVDgxBKLM";
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        pbeEnc.setAlgorithm("PBEWITHMD5ANDDES");
        pbeEnc.setPassword(key);
        return pbeEnc.encrypt(value);

    }
}
