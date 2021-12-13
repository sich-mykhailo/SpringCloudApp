package com.nerdy.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

@Configuration
public class ProxyConfig {
    @Bean
    RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("timeApp_route",
                        route -> route.path("/timeApp/**")
                        .and()
                        .method(HttpMethod.GET)
                        .filters(filter -> filter.stripPrefix(1))
                        .uri("lb://timeApp"))
                .route("time_generator_route",
                        route -> route.path("time-generator/**")
                                .filters(filter -> filter.stripPrefix(1))
                                .uri("lb://time-generator"))
                .build();
    }
}
