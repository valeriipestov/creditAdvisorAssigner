package com.example.creaditadvisoryservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "applications")
public class Application {

    public enum ApplicationStatus {
        NEW, ASSIGNED, ON_HOLD, APPROVED, CANCELED, DECLINED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private ApplicationStatus status;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "assigned_date")
    private LocalDateTime assignedDate;

    @Column(name = "resolved_date")
    private LocalDateTime resolvedDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "applicant_id")
    private Applicant applicant;

    @Version
    private Long version;
    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;

    public void assignTo(Advisor advisor) {
        verifyApp();
        this.advisor = advisor;
        this.status = ApplicationStatus.ASSIGNED;
        this.assignedDate = LocalDateTime.now();
    }

    private void verifyApp() {
        if (status != ApplicationStatus.NEW) {
            throw new IllegalStateException("Application should have status: NEW to be assigned");
        }
    }

}
