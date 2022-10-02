package com.example.creaditadvisoryservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.creaditadvisoryservice.domain.Advisor;

public interface AdvisorRepository extends JpaRepository<Advisor, Long> {
}
