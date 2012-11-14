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
package de.olivergierke.whoops.app;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.olivergierke.whoops.app.UnsupportedInstrument;
import de.olivergierke.whoops.core.Deal;
import de.olivergierke.whoops.core.DealProcessor;
import de.olivergierke.whoops.core.Result;
import de.olivergierke.whoops.core.UnsupportedInstrumentException;
import de.olivergierke.whoops.equities.Equity;
import de.olivergierke.whoops.options.Option;

/**
 * Integration test using XML configuration.
 * 
 * @author Oliver Gierke
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:META-INF/spring/*-context.xml")
public class XmlConfigTest {

	@Autowired
	DealProcessor processor;

	@Test
	public void processesEquities() {

		Deal deal = new Deal(new Equity("Deutsche Bank"));

		Result result = processor.process(deal);
		assertThat(result.getFee(), is(new BigDecimal(10.5)));
	}

	@Test
	public void processesOptions() {

		Deal deal = new Deal(new Option(new Equity("Deutsche Bank")));

		Result result = processor.process(deal);
		assertThat(result.getFee(), is(new BigDecimal(10.5).multiply(new BigDecimal(1.2))));
	}

	@Test(expected = UnsupportedInstrumentException.class)
	public void handlesUnsupportedInstrument() {

		Deal deal = new Deal(new UnsupportedInstrument());
		Result result = processor.process(deal);

		assertThat(result.getFee(), is(new BigDecimal(0.0)));
	}
}
