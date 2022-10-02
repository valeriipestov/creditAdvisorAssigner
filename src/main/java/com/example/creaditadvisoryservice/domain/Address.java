package com.example.creaditadvisoryservice.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Address {

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String street;

    @Column(name = "street_number", nullable = false)
    private Integer number;

    @Column(nullable = false)
    private Integer zip;

    private Integer apt;
}
