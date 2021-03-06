package br.com.sysdesc.imperio.kids.util;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CryptoUtil {

	private CryptoUtil() {
	}

	protected static final String SECRET_KEY = "4FJjks#2";
	private static final Charset CHARSET = StandardCharsets.UTF_8;
	private static SecretKeySpec keySpec = null;
	private static Cipher cipher;

	static {

		try {
			keySpec = new SecretKeySpec(SECRET_KEY.getBytes(CHARSET), "Blowfish");

			cipher = Cipher.getInstance("Blowfish");
		} catch (NoSuchAlgorithmException | NoSuchPaddingException e) {

			log.error("Erro ao gerar criptografia", e);
		}
	}

	public static String toMD5(String textoConverter) {
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(textoConverter.getBytes(), 0, textoConverter.length());
			return new BigInteger(1, m.digest()).toString(16);
		} catch (NoSuchAlgorithmException e) {
			return null;
		}

	}

	public static String toBlowfish(String converter) {
		try {

			cipher.init(Cipher.ENCRYPT_MODE, keySpec);

			return Base64.getEncoder().encodeToString(cipher.doFinal(converter.getBytes(CHARSET)));

		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "ERRO CRIPTOGRAFANDO ARQUIVO");
			return null;
		}

	}

	public static String fromBlowfish(String blowFish) {
		try {

			cipher.init(Cipher.DECRYPT_MODE, keySpec);

			return new String(cipher.doFinal(Base64.getDecoder().decode(blowFish.getBytes(CHARSET))));

		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException | IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "ERRO DESCRIPTOGRAFANDO ARQUIVO");
			return null;
		}

	}
}
