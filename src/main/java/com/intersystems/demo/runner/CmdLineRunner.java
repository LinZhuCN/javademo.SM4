package com.intersystems.demo.runner;

import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.intersystems.demo.SM4.SM4WrapperWithJson;
import com.intersystems.demo.SM4.Entity.EncTarget;

import cn.xjfme.encrypt.utils.sm4.SM4Utils;

public class CmdLineRunner {

	public static void main(String[] args) throws Throwable {
		String plainText = "This is the test content";
		EncTarget target = new EncTarget();
	    String uuidKey = UUID.randomUUID().toString().replace("-", "");
		target.setSecretKey(uuidKey);
		target.setContent(plainText);
		String jsonString = JSON.toJSONString(target);
		byte[] encryptedBytes = SM4WrapperWithJson.SM4EncryptJson_ECB(jsonString.getBytes("UTF-8"));
		SM4Utils sm4 = new SM4Utils();
		sm4.secretKey = uuidKey;
		sm4.hexString = true;
		String decString = sm4.decryptData_ECB(new String(encryptedBytes,"UTF-8"));
		if (decString.equals(target.getContent())){
			System.out.println("Test Succeed, decrypted String is " + decString);
		}else {
			System.out.println("Test failed, plainText is " + plainText 
					+ " while decrypted String is " + decString);
		}
	}

}
