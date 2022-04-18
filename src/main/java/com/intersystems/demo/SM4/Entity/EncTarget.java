package com.intersystems.demo.SM4.Entity;

import com.alibaba.fastjson.annotation.JSONField;


/* 用于支持在Java与ObjectScript间传递加密对象的实体类
 * 本示例中只使用了SM4 ECB算法，如果要使用CBC算法，则还需要扩展。请自行阅读CBC和ECB资料及开源源码
 * */
public class EncTarget {

	//加密密钥
	@JSONField(name="secretKey")
	private String secretKey;
	
	//待加密内容
	@JSONField(name="content")
	private String content;
	
	public EncTarget () {}
	
	public EncTarget (String secretKey, String  content) {
		this.setSecretKey(secretKey);
		this.setContent(content);
	}

	public String getSecretKey() {
		return secretKey;
	}

	public void setSecretKey(String secretKey) {
		this.secretKey = secretKey;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content2) {
		this.content = content2;
	}
	
}
