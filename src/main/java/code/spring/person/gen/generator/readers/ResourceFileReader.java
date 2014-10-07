package code.spring.person.gen.generator.readers;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;

public class ResourceFileReader implements ApplicationContextAware {

	ApplicationContext ctx;

	public List<String> readPropertyFile(String resourceURL) {
		Resource resource = ctx.getResource(resourceURL);
		try {
			return FileUtils.readLines(resource.getFile());
		} catch (IOException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.ctx = applicationContext;
	}
}
