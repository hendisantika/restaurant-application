package com.hendisantika.restaurant.service;

import com.hendisantika.restaurant.RestaurantAvailability;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * Project : restaurant-application
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/03/18
 * Time: 06.22
 * To change this template use File | Settings | File Templates.
 */
@Service
public class RestaurantAvailabilityService {

    private final WebClient webClient;

    public RestaurantAvailabilityService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8081").build();
    }

    public Mono<RestaurantAvailability> getRestaurantAvailability(String name) {
        return this.webClient.get()
                .uri("/restaurants/{name}/availability", name)
                .retrieve().bodyToMono(RestaurantAvailability.class);
    }

}
