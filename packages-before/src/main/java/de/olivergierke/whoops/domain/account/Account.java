package de.olivergierke.whoops.domain.account;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.joda.time.LocalDate;
import org.joda.time.Years;

import de.olivergierke.whoops.domain.customer.Customer;

/**
 * @author Oliver Gierke
 */
@Entity
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	private Customer customer;

	@Temporal(TemporalType.DATE)
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
