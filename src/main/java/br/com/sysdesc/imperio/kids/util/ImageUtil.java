package br.com.sysdesc.imperio.kids.util;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class ImageUtil {

	private ImageUtil() {

	}

	public static String criarBase64(String caminho) {

		try {

			byte[] bytearrayImagem = FileUtils.readFileToByteArray(new File(caminho));

			return Base64.getEncoder().encodeToString(bytearrayImagem);

		} catch (IOException e) {

			throw new SysDescException("Não foi possivel gravar a imagem");
		}

	}

	public static String getType(String caminho) {

		return String.format("data:image/%s;base64", FilenameUtils.getExtension(caminho));
	}

}
