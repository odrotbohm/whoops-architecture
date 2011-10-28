package de.olivergierke.whoops.repository.account;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.olivergierke.whoops.domain.account.Account;
import de.olivergierke.whoops.domain.customer.Customer;

/**
 * Repository to manage {@link Account} instances.
 * 
 * @author Oliver Gierke
 */
public interface AccountRepository extends CrudRepository<Account, Long> {

	/**
	 * Returns all accounts belonging to the given {@link Customer}.
	 * 
	 * @param customer
	 * @return
	 */
	List<Account> findByCustomer(Customer customer);
}
