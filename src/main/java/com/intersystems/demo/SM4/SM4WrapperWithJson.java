package com.intersystems.demo.SM4;


import com.alibaba.fastjson.JSON;
import com.intersystems.demo.SM4.Entity.EncTarget;

import cn.xjfme.encrypt.utils.sm4.SM4Utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class SM4WrapperWithJson {
	
	
	private static final Logger logger = LogManager.getLogger(SM4WrapperWithJson.class);
	
	
	//拷贝自SM4Decrypt.SM4Encrypt, 但直接返回二进制数组而不是经base64转换之后的字符串
	public static byte[] SM4Encrypt(String plainText, String secretKey) throws Exception {
        SM4Utils sm4 = new SM4Utils();
        sm4.secretKey = secretKey;
        sm4.hexString = true;
        //2. 将byte数组转换为字符串
        String cipherText = sm4.encryptData_ECB(plainText);
        byte[] sm4Byte = cipherText.getBytes();
        //3. 直接返回加密后的byte数组
        return sm4Byte;
		
	}

	//使用Json payload
	public static byte[] SM4EncryptJson_ECB(byte[] jsonBytes) throws Throwable {
		String inJson = "";
		try {
		//转为字符串不是必须的，也能通过byte[]直接转对象
		inJson = new String(jsonBytes);
		EncTarget payload = JSON.parseObject(inJson, EncTarget.class);
		return SM4Encrypt(payload.getContent(),payload.getSecretKey());
		}catch (Exception e){
			logger.error("Error encrypting : ", e);
			logger.error("Content : " + jsonBytes);
			logger.error("As String : " + new String(jsonBytes));
			return null;
		}
	}


}
