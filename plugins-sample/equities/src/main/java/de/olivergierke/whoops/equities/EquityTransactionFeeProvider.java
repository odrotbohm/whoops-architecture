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
package de.olivergierke.whoops.equities;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import de.olivergierke.whoops.core.Instrument;
import de.olivergierke.whoops.core.TransactionFeeProvider;

/**
 *
 * @author Oliver Gierke
 */
@Component
class EquityTransactionFeeProvider implements TransactionFeeProvider {

	private static String VMWARE = "VMware";

	/*
	 * (non-Javadoc)
	 * @see org.springframework.plugin.core.Plugin#supports(java.lang.Object)
	 */
	public boolean supports(Instrument delimiter) {
		return delimiter instanceof Equity;
	}

	/*
	 * (non-Javadoc)
	 * @see de.olivergierke.whoops.core.TransactionFeeProvider#getTransactionFee(de.olivergierke.whoops.core.Instrument)
	 */
	public BigDecimal getTransactionFee(Instrument instrument) {

		Equity equity = (Equity) instrument;

		return VMWARE.equals(equity.getIssuer()) ? TransactionFeeProvider.NO_FEE : new BigDecimal(10.5);
	}
}
