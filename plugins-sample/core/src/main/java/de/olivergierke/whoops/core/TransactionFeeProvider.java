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

import org.springframework.plugin.core.Plugin;

/**
 * SPI interface to plug in calculation of transaction fees for an {@link Instrument}.
 *
 * @author Oliver Gierke
 */
public interface TransactionFeeProvider extends Plugin<Instrument> {

	public static BigDecimal NO_FEE = BigDecimal.ZERO;

	/**
	 * Returns the fee to be payed for processing the given {@link Instrument}.
	 * 
	 * @param instrument will never be {@literal null}.
	 * @return must not be {@literal null}.
	 */
	BigDecimal getTransactionFee(Instrument instrument);
}
