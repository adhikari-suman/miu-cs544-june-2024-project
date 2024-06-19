package edu.miu.attendance.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;

import java.time.LocalDateTime;

@Embeddable
@Data
public class AuditData {
//    @Column(insertable = false, updatable = false)
    private LocalDateTime createdOn;
//    @Column(insertable = false, updatable = false)
    private LocalDateTime updatedOn;
    private String updatedBy ="";
    @Column(nullable = false)
    private String createdBy = "";

    @PrePersist
    protected void onCreate() {
        createdOn = LocalDateTime.now();
        updatedOn = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedOn = LocalDateTime.now();
    }
}
