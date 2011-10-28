/*
 * Copyright 2011 the original author or authors.
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
package de.olivergierke.whoops.web.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import de.olivergierke.whoops.service.customer.CustomerService;

/**
 * 
 * @author Oliver Gierke
 */
@Controller
public class CustomerController {

	@SuppressWarnings("unused")
	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		Assert.notNull(customerService);
		this.customerService = customerService;
	}
}
