package com.example.creaditadvisoryservice.domain;

import static com.example.creaditadvisoryservice.domain.Application.ApplicationStatus.ASSIGNED;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "advisors")
public class Advisor extends SystemUser {

    public enum AdvisorRole {
        ASSOCIATE(BigDecimal.ZERO, new BigDecimal(10000)),
        PARTNER(new BigDecimal(10000), new BigDecimal(50000)),
        SENIOR(new BigDecimal(50000), new BigDecimal(Integer.MAX_VALUE));

        public final BigDecimal min;
        public final BigDecimal max;

        private AdvisorRole(BigDecimal min, BigDecimal max) {
            this.max = max;
            this.min = min;
        }
    }

    @Column(name = "advisor_role", nullable = false)
    @Enumerated(value = EnumType.STRING)
    private AdvisorRole role;

    @OneToMany(mappedBy = "advisor")
    private List<Application> applications = new ArrayList<>();

    public void assignApplication(Application application) {
        verifyForAssignments();
        application.assignTo(this);
        applications.add(application);
    }

    public BigDecimal getMaxAmount() {
        return role.max;
    }

    public BigDecimal getMinAmount() {
        return role.min;
    }

    private boolean hasAssignedApplications() {
        return applications.stream().anyMatch(app -> app.getStatus() == ASSIGNED);
    }

    private void verifyForAssignments() {
        if (hasAssignedApplications()) {
            throw new IllegalArgumentException("Advisor already has assigned application");
        }
    }

}
