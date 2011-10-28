package de.olivergierke.whoops.domain.customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import de.olivergierke.whoops.domain.account.Account;


/**
 * @author Oliver Gierke
 */
@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String firstname;
	private String lastname;
	private final CustomerNumber customerNumber;

	private final List<Account> accounts = new ArrayList<Account>();

	public Customer(String firstname, String lastname, CustomerNumber number) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.customerNumber = number;
	}

	protected Customer() {

		this.firstname = null;
		this.lastname = null;
		this.customerNumber = null;
	}


	public Long getId() {

		return id;
	}


	public String getFirstname() {

		return firstname;
	}


	public String getLastname() {

		return lastname;
	}

	/**
	 * @return the customerNumber
	 */
	public CustomerNumber getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * Adds an {@link Account} to the {@link Customer}.
	 * 
	 * @param account
	 * @return
	 */
	public Customer add(Account account) {

		if (account != null) {
			this.accounts.add(account);
		}

		return this;
	}

	/**
	 * Returns all {@link Account}s of the {@link Customer}.
	 * 
	 * @return
	 */
	public List<Account> getAccounts() {
		return Collections.unmodifiableList(accounts);
	}
}
