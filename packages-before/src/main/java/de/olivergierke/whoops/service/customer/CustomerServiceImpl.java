/*
 * Copyright 2011-2013 the original author or authors.
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
package de.olivergierke.whoops.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import de.olivergierke.whoops.domain.customer.Customer;
import de.olivergierke.whoops.domain.customer.CustomerNumber;
import de.olivergierke.whoops.repository.customer.CustomerRepository;

/**
 * Implementation of {@link CustomerService}.
 * 
 * @author Oliver Gierke
 */
@Service
class CustomerServiceImpl implements CustomerService {

	private final CustomerNumberGenerator generator = new CustomerNumberGenerator();
	private final CustomerRepository repository;

	/**
	 * Creates a new {@link CustomerServiceImpl}.
	 * 
	 * @param repository must not be {@literal null}.
	 */
	@Autowired
	public CustomerServiceImpl(CustomerRepository repository) {

		Assert.notNull(repository);
		this.repository = repository;
	}

	/*
	 * (non-Javadoc)
	 * @see de.olivergierke.whoops.customer.CustomerService#createCustomer(java.lang.String, java.lang.String)
	 */
	public Customer createCustomer(String firstname, String lastname) {

		Assert.hasText(firstname, "Firstname must not be null or empty!");
		Assert.hasText(lastname, "Lastname must not be null or empty!");

		CustomerNumber number = generator.generateCustomerNumber();
		Customer customer = new Customer(firstname, lastname, number);

		return repository.save(customer);
	}
}
