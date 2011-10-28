package de.olivergierke.whoops.account;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import de.olivergierke.whoops.customer.Customer;

/**
 * Repository to manage {@link Account} instances.
 * 
 * @author Oliver Gierke
 */
interface AccountRepository extends CrudRepository<Account, Long> {

	/**
	 * Returns all accounts belonging to the given {@link Customer}.
	 * 
	 * @param customer
	 * @return
	 */
	List<Account> findByCustomer(Customer customer);
}
