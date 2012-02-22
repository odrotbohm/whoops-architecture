package de.olivergierke.whoops.app;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import de.olivergierke.whoops.ApplicationConfig;
import de.olivergierke.whoops.core.Deal;
import de.olivergierke.whoops.core.DealProcessor;
import de.olivergierke.whoops.core.Result;
import de.olivergierke.whoops.core.UnsupportedInstrumentException;
import de.olivergierke.whoops.equities.Equity;

/**
 * Integration test using JavaConfig.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class })
public class JavaConfigTest {

	@Autowired
	DealProcessor processor;

	@Test
	public void processesEquities() {

		Deal deal = new Deal(new Equity("Deutsche Bank"));

		Result result = processor.process(deal);
		assertThat(result.getFee(), is(new BigDecimal(10.5)));
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
