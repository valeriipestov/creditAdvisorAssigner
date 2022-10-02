package com.example.creaditadvisoryservice.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Embeddable
@EqualsAndHashCode(of = "number")
public class PhoneNumber {

    public enum PhoneNumberType {
        HOME, WORK, MOBILE
    }

    @Column(name = "phone_number")
    private String number;

    @Column(name = "phone_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private PhoneNumberType type;

}
