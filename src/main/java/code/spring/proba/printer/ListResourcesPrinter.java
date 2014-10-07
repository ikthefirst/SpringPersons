package code.spring.proba.printer;

import java.util.List;

public class ListResourcesPrinter implements ResourcesPrinter {

	private SingleResourcePrinter printer;
	private List<String> resourceURLs;

	public void print() {
		for (String url : resourceURLs) {
			printer.printResource(url);
		}
	}

	public SingleResourcePrinter getPrinter() {
		return printer;
	}

	public void setPrinter(SingleResourcePrinter printer) {
		this.printer = printer;
	}

	public List<String> getResourceURL() {
		return resourceURLs;
	}

	public void setResourceURLs(List<String> resourceURLs) {
		this.resourceURLs = resourceURLs;
	}

}
