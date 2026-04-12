package com.easybytes.accounts.Audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;



@Component("AuditAwareImp")

public class AuditAwareImp implements AuditorAware< String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("Iten");
    }
}
