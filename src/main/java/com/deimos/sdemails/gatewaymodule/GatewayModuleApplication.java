package com.deimos.sdemails.gatewaymodule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;


@SpringBootApplication
@ComponentScan("com.deimos.sdemails")
public class GatewayModuleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayModuleApplication.class, args);
	}



	@Bean
	KeyResolver userKeyResolver() {
			return exchange -> Mono.just("1");
		}

}
