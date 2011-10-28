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
package de.olivergierke.whoops.hera.options;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.synyx.hera.core.PluginRegistry;

import de.olivergierke.whoops.hera.core.Instrument;
import de.olivergierke.whoops.hera.core.TransactionFeeProvider;

/**
 *
 * @author Oliver Gierke
 */
@Component
class OptionTransactionFeeProvider implements TransactionFeeProvider {

	private PluginRegistry<TransactionFeeProvider, Instrument> feeProviders;
	private BigDecimal multiplier = new BigDecimal(1.2);

	/**
	 * Creates a new {@link OptionTransactionFeeProvider}
	 * @param feeProviders
	 */
	@Autowired
	public OptionTransactionFeeProvider(PluginRegistry<TransactionFeeProvider, Instrument> feeProviders) {
		this.feeProviders = feeProviders;
	}

	/*
	 * (non-Javadoc)
	 * @see org.synyx.hera.core.Plugin#supports(java.lang.Object)
	 */
	public boolean supports(Instrument delimiter) {
		return delimiter instanceof Option;
	}

	/*
	 * (non-Javadoc)
	 * @see de.olivergierke.whoops.hera.core.TransactionFeeProvider#getTransactionFee(de.olivergierke.whoops.hera.core.Instrument)
	 */
	public BigDecimal getTransactionFee(Instrument instrument) {

		Option option = (Option) instrument;
		Instrument underlying = option.getUnderlying();

		TransactionFeeProvider provider = feeProviders.getPluginFor(underlying);
		BigDecimal fee = provider.getTransactionFee(underlying);

		return fee.multiply(multiplier);
	}
}
