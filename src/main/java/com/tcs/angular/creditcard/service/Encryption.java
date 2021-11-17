package com.tcs.angular.creditcard.service;

import org.springframework.security.crypto.encrypt.BytesEncryptor;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.keygen.KeyGenerators;

public abstract class Encryption {
	static final String password = "Blobal Gank Security Pass"; 
	static final String salt = "1a15347647a4a7e7";  //KeyGenerators.string().generateKey();
	
	public static byte[] stringToByte(String val) {
		byte[] barray = val.getBytes();
		return barray;
	}
	
	public static String bytearrayToSting(byte[] barray) {
		String val = new String(barray);
		return val;
	}
	
	public static byte[] encrypt(byte[] value) {
		BytesEncryptor encryptor = Encryptors.stronger(password, salt);
		System.out.println("salt :"+salt);
		
		byte[] encryptedText = encryptor.encrypt(value);
		return encryptedText;
	}
	
	public static byte[] decrypt(byte[] encText) {
		BytesEncryptor decryptor = Encryptors.stronger(password, salt);
		System.out.println("salt :"+salt);
		
		byte[] decryptedText = decryptor.decrypt(encText);
		return decryptedText;
	}
	
}

