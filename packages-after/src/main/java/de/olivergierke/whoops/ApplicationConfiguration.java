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
package de.olivergierke.whoops;

import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

/**
 * Central application configuration.
 * 
 * @author Oliver Gierke
 */
@Configuration
@ComponentScan(excludeFilters = @Filter(Controller.class))
public class ApplicationConfiguration {

	public static <T> Answer<T> withArgument() {
		return new ArgumentAnswer<T>();
	}

	private static class ArgumentAnswer<T> implements Answer<T> {

		@SuppressWarnings("unchecked")
		public T answer(InvocationOnMock invocation) throws Throwable {
			return (T) invocation.getArguments()[0];
		}
	}
}
