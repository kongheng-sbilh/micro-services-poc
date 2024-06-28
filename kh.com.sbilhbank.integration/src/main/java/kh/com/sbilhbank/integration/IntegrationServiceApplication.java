package kh.com.sbilhbank.integration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

@SpringBootApplication
@Slf4j
public class IntegrationServiceApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(IntegrationServiceApplication.class);
		StandardEnvironment environment = new StandardEnvironment();
		try {
			String homeDir = System.getProperty("user.home");
			String filePath = homeDir + "/appzillon/property/application.properties";
			ResourcePropertySource propertySource = new ResourcePropertySource("externalProperties", "file:" + filePath);
			environment.getPropertySources().addFirst(propertySource);
			application.setEnvironment(environment);
		} catch (IOException exception) {
			log.error("error: can not find the application.properties file", exception);
		}
        application.run(args);
    }

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
