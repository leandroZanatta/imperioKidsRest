package br.com.sysdesc.imperio.kids.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;

import br.com.sysdesc.imperio.kids.service.AmazonService;
import br.com.sysdesc.imperio.kids.util.SysDescException;

@Service
public class AmazonServiceImpl implements AmazonService {

	@Autowired
	@Lazy
	private AmazonS3 amazonS3;

	@Value("${amazonProperties.endpointUrl}")
	private String endpointUrl;

	@Value("${amazonProperties.bucketName}")
	private String bucketName;

	@Override
	public String putFile(String content, String filename) {

		try {

			String imagemSemHeader = content.replace("/^data:.+;base64,/", "");

			byte[] image = Base64.getDecoder().decode(imagemSemHeader);

			File arquivoImagem = File.createTempFile("image", "." + FilenameUtils.getExtension(filename));

			FileUtils.writeByteArrayToFile(arquivoImagem, image);

			amazonS3.putObject(new PutObjectRequest(bucketName, arquivoImagem.getName(), arquivoImagem)
					.withCannedAcl(CannedAccessControlList.PublicRead));

			return endpointUrl + "/" + arquivoImagem.getName();

		} catch (IOException e) {

			throw new SysDescException("Não foi possivel gravar a imagem");
		}
	}

	@Override
	public void deleteFile(String fileUrl) {

		String fileName = fileUrl.substring(fileUrl.lastIndexOf("/") + 1);

		amazonS3.deleteObject(new DeleteObjectRequest(bucketName, fileName));
	}

}
