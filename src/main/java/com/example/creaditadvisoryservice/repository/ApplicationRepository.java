package com.example.creaditadvisoryservice.repository;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.creaditadvisoryservice.domain.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    Optional<Application> findFirstByStatusAndAmountBetweenOrderByCreatedDate(Application.ApplicationStatus status,
                                                                              BigDecimal minAmount,
                                                                              BigDecimal maxAmount);
}
