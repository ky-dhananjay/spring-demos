package com.msapp.gatewayserver.router;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class RouteConfig {
    @Bean
    public RouteLocator routeLocatorConfig(RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
            .route(p -> p
                .path("/eazybank/accounts/**")
                .filters( f -> f.rewritePath("/eazybank/accounts/(?<segment>.*)","/${segment}")
                    .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                .uri("lb://ACCOUNTS"))
            .route(p -> p
                .path("/eazybank/loans/**")
                .filters( f -> f.rewritePath("/eazybank/loans/(?<segment>.*)","/${segment}")
                    .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                .uri("lb://LOANS"))
            .route(p -> p
                .path("/eazybank/cards/**")
                .filters( f -> f.rewritePath("/eazybank/cards/(?<segment>.*)","/${segment}")
                    .addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
                .uri("lb://CARDS")).build();
    }
//    public RouterFunction<ServerResponse> reviewsRoute(ReviewHandler reviewHandler){
//        return route()
//            .nest(path("/v1/reviews"), builder -> {
//                builder
//                    .POST("",request -> reviewHandler.addReview(request))
//                    .GET("", reviewHandler::getAllReviews)
//                    .PUT("/{id}", reviewHandler::updateReview)
//                    .DELETE("/{id}", reviewHandler::deleteReview);
//            })
//            .GET("/v1/helloworld", (request -> ServerResponse.ok().bodyValue("helloworld")))
//            .build();
//    }

}
