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
package de.olivergierke.whoops.service.customer;

import java.util.Random;

import de.olivergierke.whoops.domain.customer.CustomerNumber;

/**
 * 
 * @author Oliver Gierke
 */
class CustomerNumberGenerator {

	private static final String DEFAULT_ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	private String alphabet = DEFAULT_ALPHABET;

	/**
	 * Configures the alphabet that is used to create random new passwords. Defaults to
	 * {@value #DEFAULT_ALPHABET}.
	 * 
	 * @param alphabet the alphabet to set
	 */
	public void setAlphabet(String passwordAlphabet) {

		this.alphabet = passwordAlphabet;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.synyx.minos.umt.service.PasswordCreator#generatePassword()
	 */
	public CustomerNumber generatePassword() {

		StringBuffer buffer = new StringBuffer();
		Random random = new Random();

		for (int i = 0; i < CustomerNumber.LENGTH; i++) {
			buffer.append(alphabet.charAt(random.nextInt(alphabet.length())));
		}

		return new CustomerNumber(buffer.toString());
	}
}
