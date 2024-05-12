package com.github.leovd100.capture.system;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;


@EnableFeignClients
@ImportAutoConfiguration({FeignAutoConfiguration.class})
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Customer capture system", version = "1.0", description = "This application is a BFF responsible for capturing user data and passing it on to the responsible microservices."))
public class MarketingCaptureSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(MarketingCaptureSystemApplication.class, args);
	}
}
