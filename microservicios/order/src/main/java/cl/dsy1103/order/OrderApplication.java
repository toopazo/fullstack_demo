package cl.dsy1103.order;

import java.io.StringReader;
import java.util.Properties;
import java.util.Scanner;

import lombok.extern.log4j.Log4j2;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.Environment;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

// import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
// import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
// import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

@Log4j2
@SpringBootApplication
public class OrderApplication {

	public static void main(String[] args) {
		getSecret(args);
		// SpringApplication.run(OrderApplication.class, args);
	}

	public static void getSecret(String[] args) {

		String secretName = "neondb-for-DSY1103";
		Region region = Region.of("us-east-2");

		// Create a Secrets Manager client
		SecretsManagerClient client = SecretsManagerClient.builder()
				.region(region)
				.build();

		GetSecretValueRequest getSecretValueRequest = GetSecretValueRequest.builder()
				.secretId(secretName)
				.build();

		GetSecretValueResponse getSecretValueResponse;

		try {
			getSecretValueResponse = client.getSecretValue(getSecretValueRequest);
		} catch (Exception e) {
			// For a list of exceptions thrown, see
			// https://docs.aws.amazon.com/secretsmanager/latest/apireference/API_GetSecretValue.html
			throw e;
		}

		String secret = getSecretValueResponse.secretString();

		// Your code goes here.
		log.info("Secret retrieved from AWS Secrets Manager:");
		log.info(secret);

		// Jackson main object
		ObjectMapper mapper = new ObjectMapper();

		JsonNode node = null;
		try {
			// JsonNode node = mapper.readTree(new StringReader(secret));
			// log.info(node);
			node = mapper.readTree(secret);

		} catch (Exception e) {
			e.printStackTrace();
		}

		log.info("host: " + node.get("host").asText());
		log.info("username: " + node.get("username").asText());
		log.info("password: " + node.get("password").asText());
		log.info("port: " + node.get("port").asText());

		Properties properties = new Properties();

		// spring.application.name=order
		// server.port=8082
		properties.put("spring.application.name", "order");
		properties.put("server.port", "8082");

		// spring.datasource.url=jdbc:postgresql://${DB_NEON_HOST}:${DB_NEON_PORT}/${DB_NEON_NAME}
		// spring.datasource.username=${DB_NEON_ADMIN}
		// spring.datasource.password=${DB_NEON_PASS}
		String url = "jdbc:postgresql://" + node.get("host").asText() + ":" + node.get("port").asText() + "/"
				+ node.get("dbname").asText();
		properties.put("spring.datasource.url", url);
		properties.put("spring.datasource.username", node.get("username").asText());
		properties.put("spring.datasource.password", node.get("password").asText());

		// spring.jpa.hibernate.ddl-auto=update
		// spring.jpa.show-sql=true
		// spring.jpa.properties.hibernate.format_sql=true
		properties.put("spring.jpa.hibernate.ddl-auto", "update");
		properties.put("spring.jpa.show-sql", "true");
		properties.put("spring.jpa.properties.hibernate.format_sql", "true");

		log.info(properties);

		SpringApplication application = new SpringApplication(OrderApplication.class);
		application.setDefaultProperties(properties); // Set properties before run
		application.run(args);

	}

}
