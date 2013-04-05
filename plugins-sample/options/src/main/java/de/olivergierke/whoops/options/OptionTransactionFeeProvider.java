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
package de.olivergierke.whoops.options;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.plugin.core.PluginRegistry;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import de.olivergierke.whoops.core.Instrument;
import de.olivergierke.whoops.core.TransactionFeeProvider;

/**
 * {@link TransactionFeeProvider} implementation for {@link Option}s. Uses a {@link PluginRegistry} of
 * {@link TransactionFeeProvider}s in turn to delegate fee calculation for the {@link Option}'s underlying.
 * 
 * @author Oliver Gierke
 */
@Component
class OptionTransactionFeeProvider implements TransactionFeeProvider {

	private final PluginRegistry<TransactionFeeProvider, Instrument> feeProviders;
	private final BigDecimal multiplier = new BigDecimal(1.2);

	/**
	 * Creates a new {@link OptionTransactionFeeProvider} using the given {@link TransactionFeeProvider}s.
	 * 
	 * @param feeProviders must not be {@literal null}.
	 */
	@Autowired
	public OptionTransactionFeeProvider(PluginRegistry<TransactionFeeProvider, Instrument> feeProviders) {

		Assert.notNull(feeProviders, "FeeProviders must not be null!");
		this.feeProviders = feeProviders;
	}

	/*
	 * (non-Javadoc)
	 * @see org.springframework.plugin.core.Plugin#supports(java.lang.Object)
	 */
	public boolean supports(Instrument delimiter) {
		return delimiter instanceof Option;
	}

	/*
	 * (non-Javadoc)
	 * @see de.olivergierke.whoops.core.TransactionFeeProvider#getTransactionFee(de.olivergierke.whoops.core.Instrument)
	 */
	public BigDecimal getTransactionFee(Instrument instrument) {

		Option option = (Option) instrument;
		Instrument underlying = option.getUnderlying();

		TransactionFeeProvider provider = feeProviders.getPluginFor(underlying);
		BigDecimal fee = provider.getTransactionFee(underlying);

		return fee.multiply(multiplier);
	}
}
