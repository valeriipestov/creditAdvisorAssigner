package com.example.creaditadvisoryservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.creaditadvisoryservice.domain.Application;
import com.example.creaditadvisoryservice.domain.ErrorDto;
import com.example.creaditadvisoryservice.service.AdvisorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/credit/advisor")
@AllArgsConstructor
public class AdvisorController {

    private AdvisorService advisorService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{advisorId}/application/assign")
    public ResponseEntity<Application> assignApplication(@PathVariable Long advisorId) {
        var app = advisorService.assignAppByAdvisorId(advisorId);
        return ResponseEntity.of(app);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = RuntimeException.class)
    public ErrorDto handleException(RuntimeException e) {
        return new ErrorDto(e.getMessage());
    }

}
