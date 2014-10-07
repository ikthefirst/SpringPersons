package code.spring.proba.printer;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class SingleResourcePrinter implements ApplicationContextAware {

	private ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.ctx = applicationContext;
	}

	public void printResource(String resourceURL) {
		System.out.println(resourceURL + " : ");
		Resource resource = ctx.getResource(resourceURL);
		try {
			List<String> lines = FileUtils.readLines(resource.getFile());
			for (String line : lines) {
				System.out.println("\t" + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
