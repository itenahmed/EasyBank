package com.easybytes.accounts.Repository;

import com.easybytes.accounts.Entity.Accounts;
import com.easybytes.accounts.Entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {

}
