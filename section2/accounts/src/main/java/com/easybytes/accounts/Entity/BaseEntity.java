package com.easybytes.accounts.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

@MappedSuperclass
@Setter @Getter @ToString
public class BaseEntity {
@Column(updatable = false)
private LocalDateTime createdAt;
@Column(updatable = false)
private String createdBy;
@Column(insertable = false )
private String updatedBy;
@Column(insertable = false )
private LocalDateTime updatedAt;
}
