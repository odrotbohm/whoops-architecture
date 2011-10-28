package de.olivergierke.whoops.repository.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import de.olivergierke.whoops.domain.customer.Customer;

/**
 * Repository to manage {@link Customer} instances.
 * 
 * @author Oliver Gierke
 */
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	/**
	 * Returns a page of {@link Customer}s with the given lastname.
	 * 
	 * @param lastname
	 * @param pageable
	 * @return
	 */
	Page<Customer> findByLastname(String lastname, Pageable pageable);
}
