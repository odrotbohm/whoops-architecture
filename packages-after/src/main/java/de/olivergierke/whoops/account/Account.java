package de.olivergierke.whoops.account;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import de.olivergierke.whoops.customer.Customer;

/**
 * @author Oliver Gierke
 */
public class Account {

	private Long id;
	private Customer customer;
	private LocalDate expiryDate;

	public Long getId() {
		return id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	/**
	 * Extends the {@link Account}'s expiry date by a year.
	 */
	public void extend() {
		this.expiryDate = expiryDate.plus(Years.ONE);
	}
}
