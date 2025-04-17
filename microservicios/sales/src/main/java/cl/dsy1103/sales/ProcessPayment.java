package cl.dsy1103.sales;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProcessPayment {
    private static final Logger log = LoggerFactory.getLogger(ProcessPayment.class);

    public static void main(String[] args) {
        SpringApplication.run(ProcessPayment.class, args);
    }

    // @Bean
    // public RestTemplate restTemplate(RestTemplateBuilder builder) {
    // return builder.build();
    // }

    @Bean
    @Profile("!test")
    public CommandLineRunner run() throws Exception {
        String endpoint = String.format("http://127.0.0.1:8000/users/1/");
        log.info(String.format("endpoint %s", endpoint));

        String user = "admin";
        String pass = "aldomaionA9";

        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        RestTemplate restTemplate = restTemplateBuilder.basicAuthentication(user, pass).build();

        String result = restTemplate.getForObject(endpoint, String.class);
        return args -> {
            log.info(result);
        };
    }

}
