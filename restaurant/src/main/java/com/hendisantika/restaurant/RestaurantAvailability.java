package com.hendisantika.restaurant;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;

/**
 * Created by IntelliJ IDEA.
 * Project : restaurant-application
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 11/03/18
 * Time: 06.19
 * To change this template use File | Settings | File Templates.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantAvailability {

    private final String name;

    private final boolean available;

    private final URI confirmationUri;

    @JsonCreator
    public RestaurantAvailability(@JsonProperty("name") String name,
                                  @JsonProperty("available") boolean available,
                                  @JsonProperty("confirmationUri") URI confirmationUri) {
        this.name = name;
        this.available = available;
        this.confirmationUri = confirmationUri;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public URI getConfirmationUri() {
        return this.confirmationUri;
    }

}