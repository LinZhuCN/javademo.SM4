package com.intersystems.demo.SM4.Test;

import static org.junit.Assert.*;

/*import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;*/
import java.util.UUID;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.intersystems.demo.SM4.SM4WrapperWithJson;
import com.intersystems.demo.SM4.Entity.EncTarget;

import cn.xjfme.encrypt.utils.sm4.SM4Utils;

public class SM4WrapperWithJsonTest {

	//private static String filePath = "/Users/lzhu/eclipse-workspace/javademo.SM4/src/main/resources/files";
	//private static String srcFileName = "sample.xml";

	/* 使用中文字符串测试加密前字符串与加密并解密后字符串相同 */
	@Test
	public void testSM4EncryptJsonWithString() {
		try {
			String plainText = "这是一段测试用字符串";
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
			assertEquals(plainText, decString);
		}catch (Throwable e) {
			e.printStackTrace();
			fail("Test Failed");
		}	
	}
	
	/*
	 * 使用XML文件测试加密前文件内容与加密并解密后的内容相同 
	 * 注意：执行效率低下，加密70+kb的数据需要十秒以上，解密需要约3秒；大于2MB的文件加密10分钟仍不能结束 
	 * 应是加密算法实现的效率不佳
	 */
	/*@Test
	public void testSM4EncryptJsonWithFile() {
		try {
			File srcFile = new File(filePath+"/"+srcFileName);
			FileInputStream fis = new FileInputStream(srcFile);
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
			byte[] buf = new byte[1000];
			int n;
			while ((n = fis.read(buf)) != -1) {
				bos.write(buf, 0, n);
			}
			fis.close();
			byte[] data = bos.toByteArray();
			bos.close();
			EncTarget target = new EncTarget();
		    String uuidKey = UUID.randomUUID().toString().replace("-", "");
			target.setSecretKey(uuidKey);
			target.setContent(new String(data));
			String jsonString = JSON.toJSONString(target);
			byte[] encryptedBytes = SM4WrapperWithJson.SM4EncryptJson_ECB(jsonString.getBytes("UTF-8"));
			SM4Utils sm4 = new SM4Utils();
			sm4.secretKey = uuidKey;
			sm4.hexString = true;
			String decString = sm4.decryptData_ECB(new String(encryptedBytes,"UTF-8"));
			assertEquals(target.getContent(), decString);
		}catch (Throwable e) {
			e.printStackTrace();
			fail("Test Failed");
		}
	}*/

}
