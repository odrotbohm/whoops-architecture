/*
 * Copyright 2011-2014 the original author or authors.
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
package de.olivergierke.whoops;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.olivergierke.whoops.domain.customer.Customer;
import de.olivergierke.whoops.repository.account.AccountRepository;
import de.olivergierke.whoops.repository.customer.CustomerRepository;
import de.olivergierke.whoops.service.account.AccountService;
import de.olivergierke.whoops.service.account.AccountServiceImpl;
import de.olivergierke.whoops.service.customer.CustomerService;

/**
 * @author Oliver Gierke
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class ApplicationConfigurationTest {

	@Autowired AccountRepository accountRepository;
	@Autowired CustomerRepository customerRepository;

	@Autowired AccountService accountService;
	@Autowired CustomerService customerService;

	// This should not be allowed to work actually
	@Autowired AccountServiceImpl accountServiceImpl;

	@Test
	public void createNewUser() {

		Customer customer = customerService.createCustomer("Dave", "Matthews");
		assertThat(customer.getCustomerNumber(), is(notNullValue()));
	}
}
