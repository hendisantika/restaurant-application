package com.hendisantika.restaurant.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by IntelliJ IDEA.
 * Project : restaurant-application
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 10/03/18
 * Time: 09.39
 * To change this template use File | Settings | File Templates.
 */
@Document
public class Restaurant {

    @Id
    private String id;

    private String name;

    private Double pricePerPerson;

    private String category;

    public Restaurant() {
    }

    public Restaurant(String name, Double pricePerPerson, String category) {
        this.name = name;
        this.pricePerPerson = pricePerPerson;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPricePerPerson() {
        return this.pricePerPerson;
    }

    public void setPricePerPerson(Double pricePerPerson) {
        this.pricePerPerson = pricePerPerson;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
