package com.hendisantika.restaurant.repository;

import com.hendisantika.restaurant.domain.Restaurant;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

/**
 * Created by IntelliJ IDEA.
 * Project : restaurant-application
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/03/18
 * Time: 06.18
 * To change this template use File | Settings | File Templates.
 */
public interface RestaurantRepository extends ReactiveCrudRepository<Restaurant, String> {

    Flux<Restaurant> findByCategoryAndPricePerPersonLessThan(String category, Double maxPrice);

}