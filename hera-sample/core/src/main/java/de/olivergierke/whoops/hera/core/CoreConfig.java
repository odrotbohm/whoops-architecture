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
package de.olivergierke.whoops.hera.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.synyx.hera.core.PluginRegistry;
import org.synyx.hera.core.support.PluginRegistryFactoryBean;


/**
 * Configuration for core components.
 * 
 * @author Oliver Gierke
 */
@Configuration
@ComponentScan(basePackageClasses = CoreConfig.class)
public class CoreConfig {

	@Autowired
	ApplicationContext context;

	@Bean
	public PluginRegistry<TransactionFeeProvider, Instrument> feeProviders() {

		return feeProviderFactoryBean().getObject();
	}

	@Bean
	public PluginRegistryFactoryBean<TransactionFeeProvider, Instrument> feeProviderFactoryBean() {

		PluginRegistryFactoryBean<TransactionFeeProvider, Instrument> factory = new PluginRegistryFactoryBean<TransactionFeeProvider, Instrument>();
		factory.setApplicationContext(context);
		factory.setType(TransactionFeeProvider.class);

		return factory;
	}
}
