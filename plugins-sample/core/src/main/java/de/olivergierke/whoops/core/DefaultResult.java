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

import java.math.BigDecimal;

/**
 * {@link Result} value object capturing the fee of a processed deal.
 *
 * @author Oliver Gierke
 */
class DefaultResult implements Result {

	private final BigDecimal fee;

	public DefaultResult(BigDecimal fee) {
		this.fee = fee;
	}

	/*
	 * (non-Javadoc)
	 * @see de.olivergierke.whoops.core.Result#getFee()
	 */
	public BigDecimal getFee() {
		return fee;
	}
}
