package de.olivergierke.whoops.hera.app;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.olivergierke.whoops.hera.core.CoreConfig;
import de.olivergierke.whoops.hera.core.Deal;
import de.olivergierke.whoops.hera.core.DealProcessor;
import de.olivergierke.whoops.hera.core.Result;
import de.olivergierke.whoops.hera.core.UnsupportedInstrumentException;
import de.olivergierke.whoops.hera.equities.Equity;
import de.olivergierke.whoops.hera.options.Option;

/**
 * Integration test using JavaConfig.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { CoreConfig.class })
public class JavaConfigTest {

	@Autowired
	DealProcessor processor;

	@Test
	public void processesEquities() {

		Deal deal = new Deal(new Equity("Deutsche Bank"));

		Result result = processor.process(deal);
		assertThat(result.getFee(), is(new BigDecimal(10.5)));
	}

	@Test
	//	@Ignore
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

	@Test
	public void vmWareEquitiesIsFree() {

		Deal deal = new Deal(new Equity("VMware"));
		Result result = processor.process(deal);

		assertThat(result.getFee(), is(BigDecimal.ZERO));
	}
}
