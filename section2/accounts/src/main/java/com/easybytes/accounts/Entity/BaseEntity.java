package com.easybytes.accounts.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@Setter
@Getter
@ToString
public class BaseEntity {
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;
    @Column(updatable = false,nullable = false)
    private String createdBy;
    @Column(insertable = false)
    private String updatedBy;
    @Column(insertable = false)
    private LocalDateTime updatedAt;
}
