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
package de.olivergierke.whoops.domain.customer;

import javax.persistence.Embeddable;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * Value object to represent customer numbers.
 * 
 * @author Oliver Gierke
 */
@Embeddable
public class CustomerNumber {

	public static final int LENGTH = 10;

	private static final String REGEX = "[A-Z0-9]{" + LENGTH + "}";
	private final String number;

	/**
	 * Creates a new {@link CustomerNumber} from the given {@link String}.
	 * 
	 * @param number must not be {@literal null} or empty.
	 */
	public CustomerNumber(String number) {

		Assert.isTrue(isValid(number));
		this.number = number;
	}

	/**
	 * Returns whether the given {@link String} is a valid {@link CustomerNumber}.
	 * 
	 * @param number
	 * @return
	 */
	public static boolean isValid(String number) {
		return StringUtils.hasText(number) && number.matches(REGEX);
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return number;
	}
}
