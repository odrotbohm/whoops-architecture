package de.olivergierke.whoops.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
}
