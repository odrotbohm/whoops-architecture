package de.olivergierke.whoops.misc.lookup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * A simple Spring component showing that the container will inject all Spring beans of a given type if we autowire a
 * {@link List} of beans.
 * 
 * @author Oliver Gierke
 */
@Component
public class MyComponent {

	private final List<MyPlugin> plugins;

	/**
	 * Creates a ne {@link MyComponent} instance
	 * 
	 * @param plugins will be all Spring beans implementing {@link MyPlugin}.
	 */
	@Autowired
	public MyComponent(List<MyPlugin> plugins) {
		Assert.notNull(plugins);
		this.plugins = plugins;
	}

	/**
	 * Returns the {@link MyPlugin} instances set in the constructor.
	 * 
	 * @return the plugins
	 */
	List<MyPlugin> getPlugins() {
		return plugins;
	}
}
