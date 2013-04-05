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
package de.olivergierke.whoops.service.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import de.olivergierke.whoops.domain.account.Account;
import de.olivergierke.whoops.domain.customer.Customer;
import de.olivergierke.whoops.repository.account.AccountRepository;

/**
 * Default implementation of {@link AccountService}.
 * 
 * @author Oliver Gierke
 */
@Service
public class AccountServiceImpl implements AccountService {

	private final AccountRepository repository;

	/**
	 * Creates a new {@link AccountServiceImpl} using the given {@link AccountRepository}.
	 * 
	 * @param repository must not be {@literal null}.
	 */
	@Autowired
	public AccountServiceImpl(AccountRepository repository) {

		Assert.notNull(repository);
		this.repository = repository;
	}

	/*
	 * (non-Javadoc)
	 * @see de.olivergierke.whoops.account.AccountService#extendContractsFor(de.olivergierke.whoops.customer.Customer)
	 */
	public void extendContractsFor(Customer customer) {

		Assert.notNull(customer, "Customer must not be null!");
		List<Account> accounts = repository.findByCustomer(customer);

		for (Account account : accounts) {
			account.extend();
		}

		repository.save(accounts);
	}
}
