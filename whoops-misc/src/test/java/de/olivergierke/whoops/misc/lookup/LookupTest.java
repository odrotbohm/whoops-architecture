/*
 * Copyright 2011-2012 the original author or authors.
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
package de.olivergierke.whoops.misc.lookup;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Integration test showing the container injecting all beans of a given type when autowiring a {@link List} of a given
 * type.
 * 
 * @author Oliver Gierke
 */
public class LookupTest {

	@Configuration
	static class Config {

		@Autowired
		List<MyPlugin> plugins;

		@Bean
		public MyComponent myComponent() {
			return new MyComponent(plugins);
		}

		@Bean
		public MyPlugin firstPlugin() {
			return new FirstPlugin();
		}

		@Bean
		public MyPlugin secondPlugin() {
			return new SecondPlugin();
		}
	}

	@Configuration
	@ComponentScan(basePackageClasses = MyComponent.class)
	static class ComponentScanConfig {

	}

	@Test
	public void bootstrapJavaConfigContainer() {

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		MyComponent component = context.getBean(MyComponent.class);
		assertThat(component, is(notNullValue()));

		List<MyPlugin> plugins = component.getPlugins();
		assertThat(plugins.size(), is(2));
	}

	@Test
	public void bootstrapComponentScanContainer() {

		ApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
		MyComponent component = context.getBean(MyComponent.class);
		assertThat(component, is(notNullValue()));

		List<MyPlugin> plugins = component.getPlugins();
		assertThat(plugins.size(), is(2));
	}
}
