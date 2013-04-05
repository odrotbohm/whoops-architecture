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
package de.olivergierke.whoops.customer;

import java.util.Random;

import org.springframework.util.Assert;

/**
 * Component to generate {@link CustomerNumber} instances based on a configurable alphabet.
 * 
 * @author Oliver Gierke
 */
class CustomerNumberGenerator {

	private static final String DEFAULT_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private String alphabet = DEFAULT_ALPHABET;

	/**
	 * Configures the alphabet that is used to create random new passwords. Defaults to {@value #DEFAULT_ALPHABET}.
	 * 
	 * @param alphabet the alphabet to set
	 */
	public void setAlphabet(String passwordAlphabet) {
		Assert.hasText(passwordAlphabet, "Password alphabet must not be empty!");
		this.alphabet = passwordAlphabet;
	}

	/**
	 * Generates a random {@link CustomerNumber} based on the configured alphabet.
	 * 
	 * @return will never be {@literal null}.
	 */
	public CustomerNumber generateCustomerNumber() {

		StringBuffer buffer = new StringBuffer();
		Random random = new Random();

		for (int i = 0; i < CustomerNumber.LENGTH; i++) {
			buffer.append(alphabet.charAt(random.nextInt(alphabet.length())));
		}

		return new CustomerNumber(buffer.toString());
	}
}
