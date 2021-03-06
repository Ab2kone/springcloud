package org.sid.clouggateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClougGatewayApplication {

	@Bean 
	RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r->r.path("/customers/**").uri("http://localhost:8081/").id("r1"))
				.route(r->r.path("/products/**").uri("http://localhost:8082/").id("r2"))
				.build();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ClougGatewayApplication.class, args);
	}

}
