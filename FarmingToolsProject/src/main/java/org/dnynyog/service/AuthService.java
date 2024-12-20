package org.dnynyog.service;

import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.stereotype.Component;
@Component
public class AuthService {
	private static final String Secret_Key ="5F270B0EF2F0BAB8123A810368B0E4HS";
	private static final String ALGORITHM="AES";
	
	private static SecretKey secretKey;
	private static Cipher cipher;
	
	static {
		secretKey=new SecretKeySpec(Secret_Key.getBytes(StandardCharsets.UTF_8),ALGORITHM);
		try { 
			cipher=Cipher.getInstance(ALGORITHM);
			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		}
		catch(InvalidKeyException e ) {
			e.printStackTrace();
		}
		catch(NoSuchAlgorithmException e ) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
				}
	public String encrypt(String data) throws Exception {
		byte[] encryptedData =cipher.doFinal(data.getBytes());
		return Base64.getEncoder().encodeToString(encryptedData);
		
	}
	public static  String decrypt(String encryptedData) throws Exception{
		byte[] decryptedData =cipher.doFinal(Base64.getDecoder().decode(encryptedData));
		return new String(decryptedData,StandardCharsets.UTF_8);
		
	}
	public static SecretKey generateAesKey() {
		try {
			KeyGenerator keyGenerator=KeyGenerator.getInstance("AES");
			keyGenerator.init(256);
			return keyGenerator.generateKey();
		}catch(NoSuchAlgorithmException e ) {
			throw new RuntimeException("Error generating AES key",e);
		}
	}

}
