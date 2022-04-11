package com.intersystems.demo.SM4.Entity;

import com.alibaba.fastjson.annotation.JSONField;

public class EncTarget {

	@JSONField(name="secretKey")
	private String secretKey;
	
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
