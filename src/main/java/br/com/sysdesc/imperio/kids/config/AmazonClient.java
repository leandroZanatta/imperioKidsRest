package br.com.sysdesc.imperio.kids.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

@Configuration
public class AmazonClient {

	@Value("${amazonProperties.endpointUrl}")
	private String endpointUrl;

	@Value("${amazonProperties.accessKey}")
	private String accessKey;

	@Value("${amazonProperties.secretKey}")
	private String secretKey;

	@Value("${amazonProperties.region}")
	private String region;

	@Bean
	public AmazonS3 initializeAmazon() {

		AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);

		return AmazonS3ClientBuilder.standard().withRegion(Regions.SA_EAST_1)
				.withCredentials(new AWSStaticCredentialsProvider(credentials)).build();
	}
}