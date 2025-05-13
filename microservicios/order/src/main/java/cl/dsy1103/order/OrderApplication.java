package cl.dsy1103.order;

import java.util.Properties;

import lombok.extern.log4j.Log4j2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.secretsmanager.SecretsManagerClient;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueRequest;
import software.amazon.awssdk.services.secretsmanager.model.GetSecretValueResponse;

@Log4j2
@SpringBootApplication
public class OrderApplication {

	public static void main(String[] args) {
		JsonNode node = getSecrets();

		Properties properties = setApplicationProperties(node);
		log.info(properties);

		SpringApplication application = new SpringApplication(OrderApplication.class);
		application.setDefaultProperties(properties); // Set properties before run
		application.run(args);

		// SpringApplication.run(OrderApplication.class, args);
	}

	public static JsonNode getSecrets() {

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

		return node;
	}

	public static void setApplicationPropertiesOracle() {

		// # ORACLE DB
		// # spring.datasource.driver-class-name=oracle.jdbc.OracleDriver
		// #
		// spring.datasource.url=jdbc:oracle:thin:@cbicn24vcdndg5uc_high?TNS_ADMIN=${DB_ORACLE_WALLET_DIR}
		// # spring.datasource.username=ADMIN
		// # spring.datasource.password=${DB_ORACLE_PASS}

		// # ORACLE DB
		// # spring.jpa.hibernate.ddl-auto=<create | create-drop | update | validate |
		// none>
		// # spring.jpa.hibernate.ddl-auto=update
		// # spring.jpa.show-sql=true
		// # spring.jpa.properties.hibernate.format_sql=true
		// # spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.OracleDialect
	}

	public static Properties setApplicationProperties(JsonNode node) {

		// log.info("host: " + node.get("host").asText());
		// log.info("username: " + node.get("username").asText());
		// log.info("password: " + node.get("password").asText());
		// log.info("port: " + node.get("port").asText());

		Properties properties = new Properties();

		// spring.application.name=order
		// server.port=8082
		properties.put("spring.application.name", "order");
		properties.put("server.port", "8082");

		// spring.datasource.url=jdbc:postgresql://${DB_HOST}:${DB_PORT}/${DB_NAME}
		// spring.datasource.username=${DB_ADMIN}
		// spring.datasource.password=${DB_PASS}
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

		// Logging
		// logging.level.org.hibernate=DEBUG
		// logging.level.com.zaxxer.hikari=DEBUG
		// logging.level.java.sql=DEBUG

		return properties;
	}
}
