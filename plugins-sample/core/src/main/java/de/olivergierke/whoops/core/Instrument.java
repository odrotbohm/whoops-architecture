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
package de.olivergierke.whoops.core;

import org.springframework.util.Assert;

/**
 * Base class for financial instrument entities.
 *
 * @author Oliver Gierke
 */
public abstract class Instrument {

	private final String issuer;

	public Instrument(String issuer) {
		Assert.hasText(issuer);
		this.issuer = issuer;
	}

	/**
	 * @return the issuer
	 */
	public String getIssuer() {
		return issuer;
	}
}
