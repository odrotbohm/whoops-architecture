/*
 * Copyright 2011-2016 the original author or authors.
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
package de.olivergierke.whoops.web.account;

import de.olivergierke.whoops.domain.account.Account;
import de.olivergierke.whoops.service.account.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

/**
 * Stub web component managing {@link Account} through an {@link AccountService}.
 * 
 * @author Oliver Gierke
 */
@Controller
public class AccountController {

	@SuppressWarnings("unused") private final AccountService accountService;

	/**
	 * Creates a new {@link AccountController} using the given {@link AccountService}.
	 * 
	 * @param accountService must not be {@literal null}.
	 */
	@Autowired
	public AccountController(AccountService accountService) {

		Assert.notNull(accountService);
		this.accountService = accountService;
	}

	// controller methods go here
}
