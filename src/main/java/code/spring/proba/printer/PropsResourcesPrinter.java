package code.spring.proba.printer;

import java.util.Map.Entry;
import java.util.Properties;

public class PropsResourcesPrinter implements ResourcesPrinter {

	private SingleResourcePrinter printer;
	private Properties resourceURLs;

	public Properties getResourceURLs() {
		return resourceURLs;
	}

	public void setResourceURLs(Properties resourceURLProperties) {
		this.resourceURLs = resourceURLProperties;
	}

	public SingleResourcePrinter getPrinter() {
		return printer;
	}

	public void setPrinter(SingleResourcePrinter printer) {
		this.printer = printer;
	}

	@Override
	public void print() {
		for (Entry<Object, Object> entry : resourceURLs.entrySet()) {
			printer.printResource(entry.getValue().toString());
		}
	}

}
