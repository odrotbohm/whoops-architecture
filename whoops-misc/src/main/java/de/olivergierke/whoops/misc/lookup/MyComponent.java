package de.olivergierke.whoops.misc.lookup;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 *
 * @author Oliver Gierke
 */
@Component
public class MyComponent {

	private final List<MyPlugin> plugins;

	/**
	 * @param plugins
	 */
	@Autowired
	public MyComponent(List<MyPlugin> plugins) {
		Assert.notNull(plugins);
		this.plugins = plugins;
	}

	/**
	 * @return the plugins
	 */
	List<MyPlugin> getPlugins() {
		return plugins;
	}
}
