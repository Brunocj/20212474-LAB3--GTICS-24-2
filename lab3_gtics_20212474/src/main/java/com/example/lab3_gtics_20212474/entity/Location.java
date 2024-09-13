package com.example.lab3_gtics_20212474.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="locations")
public class Location {

    @Id
    @Column(name="location_id",nullable = false)
    private Integer location_id;

    @Column(name="street_address",nullable = true,length = 12)
    private String street_address;

    @Column(name="postal_code",nullable = true,length = 12)
    private String postal_code;

    @Column(name="city",nullable = false,length = 30)
    private String city;

    @Column(name="state_province",nullable = true,length = 12)
    private String state_province;

}

