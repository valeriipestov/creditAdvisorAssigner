package com.example.creaditadvisoryservice.domain;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "applicants")
public class Applicant extends SystemUser {

    @Column(nullable = false, unique = true)
    private String ssn;

    @Embedded
    private Address address;

    @ElementCollection
    @CollectionTable(name = "applicant_phones", joinColumns = @JoinColumn(name = "applicant_id"))
    private List<PhoneNumber> phoneNumbers;

    @OneToMany(mappedBy = "applicant")
    private List<Application> applications;

}
