package code.spring.person.gen.generator.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import code.spring.person.gen.generator.EmailGenerator;
import code.spring.person.gen.generator.config.EmailGeneratorConfig;

public class RandomEmailGenerator implements EmailGenerator {

	private Random random;
	private EmailGeneratorConfig config;

	@Override
	public String generateEmail(String firstName, String lastName, Date birthDate) {
		List<String> emailDomains = config.getEmailDomains();
		String emailDomain = emailDomains.get(random.nextInt(emailDomains.size()));
		int n = random.nextInt(1000);
		return new StringBuffer().append(firstName).append(".").append(lastName).append(n).append("@")
				.append(emailDomain).toString();
	}

	public Random getRandom() {
		return random;
	}

	@Autowired
	public void setRandom(Random random) {
		this.random = random;
	}

	public EmailGeneratorConfig getConfig() {
		return config;
	}

	@Autowired
	public void setConfig(EmailGeneratorConfig config) {
		this.config = config;
	}

}
