package com.hendisantika.restaurant.controller;

import com.hendisantika.restaurant.RestaurantAvailability;
import com.hendisantika.restaurant.domain.Restaurant;
import com.hendisantika.restaurant.repository.RestaurantRepository;
import com.hendisantika.restaurant.service.RestaurantAvailabilityService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Created by IntelliJ IDEA.
 * Project : restaurant-application
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/03/18
 * Time: 17.50
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class RestaurantController {

    private final RestaurantRepository repository;

    private final RestaurantAvailabilityService restaurantAvailabilityService;

    public RestaurantController(RestaurantRepository repository,
                                RestaurantAvailabilityService restaurantAvailabilityService) {
        this.repository = repository;
        this.restaurantAvailabilityService = restaurantAvailabilityService;
    }

    @GetMapping("/restaurants")
    public Flux<Restaurant> getByCategoryAndPrice(@RequestParam String category,
                                                  @RequestParam Double maxPrice) {
        return this.repository.findByCategoryAndPricePerPersonLessThan(category, maxPrice);
    }

    @GetMapping(path = "/restaurants/available", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    public Flux<RestaurantAvailability> getAvailableRestaurants() {
        return this.repository.findAll()
                .flatMap(r -> this.restaurantAvailabilityService.getRestaurantAvailability(r.getName()))
                .filter(RestaurantAvailability::isAvailable)
                .take(3);
    }

}