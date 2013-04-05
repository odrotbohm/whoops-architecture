/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.olivergierke.whoops.domain.customer;

import java.util.ArrayList;
import java.util.List;

import de.olivergierke.whoops.domain.account.Account;

/**
 * @author Oliver Gierke
 */
public class Customer {

	private Long id;

	private final String firstname;
	private final String lastname;
	private final CustomerNumber customerNumber;

	private final List<Account> accounts = new ArrayList<Account>();

	public Customer(String firstname, String lastname, CustomerNumber number) {

		this.firstname = firstname;
		this.lastname = lastname;
		this.customerNumber = number;
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

	public CustomerNumber getCustomerNumber() {
		return customerNumber;
	}
}
