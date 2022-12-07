package sg.nus.iss.demoTransaction.repository;

import java.util.Optional;

import javax.persistence.LockModeType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import sg.nus.iss.demoTransaction.model.Account;

@Repository
@Transactional(readOnly = true)
public interface AccountRepository extends JpaRepository<Account, Long>{
    Optional<Account> findByAccountId(Long id);
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
	@Transactional
	@Query("SELECT a FROM Account a WHERE a.accountId = ?1")
	Optional<Account> getAccountForUpdate(Long id);
}
