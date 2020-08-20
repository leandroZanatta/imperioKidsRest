package br.com.sysdesc.imperio.kids.service;

public interface AmazonService {

	public abstract String putFile(String content, String filename);

	public abstract void deleteFile(String fileUrl);

}
