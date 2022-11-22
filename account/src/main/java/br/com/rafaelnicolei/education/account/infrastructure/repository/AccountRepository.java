package br.com.rafaelnicolei.education.account.infrastructure.repository;

import br.com.rafaelnicolei.education.account.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
}
