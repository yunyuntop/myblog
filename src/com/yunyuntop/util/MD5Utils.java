package com.yunyuntop.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
	/**
	 */
	public static String md5(String plainText) {
		byte[] secretBytes = null;
		try {
			secretBytes = MessageDigest.getInstance("md5").digest(plainText.getBytes());
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException("找不到md5算法");
		}
		for (int i = 0; i < secretBytes.length; i++)  {
			System.out.print(secretBytes[i] + "  "); 
		}
		
		System.out.println(new BigInteger(1, secretBytes));
		String md5code = new BigInteger(1, secretBytes).toString(16);//把二进制补码形式的byte数组变成改对象1代表正数-1代表-
		for (int i = 0; i < 32 - md5code.length(); i++) {
			md5code = "0" + md5code;
		}
		return md5code;
	}


}
