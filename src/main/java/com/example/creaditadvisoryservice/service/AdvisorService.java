package com.example.creaditadvisoryservice.service;

import javax.transaction.Transactional;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.creaditadvisoryservice.domain.Application;
import com.example.creaditadvisoryservice.repository.AdvisorRepository;
import com.example.creaditadvisoryservice.repository.ApplicationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AdvisorService {

    private AdvisorRepository advisorRepository;

    private ApplicationRepository applicationRepository;

    @Transactional
    public Optional<Application> assignAppByAdvisorId(Long advisorId) {
        var advisor = advisorRepository.findById(advisorId).orElseThrow();
        var application =
          applicationRepository.findFirstByStatusAndAmountBetweenOrderByCreatedDate(Application.ApplicationStatus.NEW,
            advisor.getMinAmount(), advisor.getMaxAmount());
        application.ifPresent(advisor::assignApplication);
        return application;
    }

}
