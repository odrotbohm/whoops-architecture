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
package de.olivergierke.whoops.domain.account;

import de.olivergierke.whoops.domain.customer.Customer;
import lombok.Getter;

import org.joda.time.LocalDate;
import org.joda.time.Years;

/**
 * @author Oliver Gierke
 */
@Getter
public class Account {

	private Long id;
	private Customer customer;
	private LocalDate expiryDate;

	/**
	 * Extends the {@link Account}'s expiry date by a year.
	 */
	public void extend() {
		this.expiryDate = expiryDate.plus(Years.ONE);
	}
}
