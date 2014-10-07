package code.spring.person.gen.generator.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import code.spring.person.gen.generator.NameGenerator;
import code.spring.person.gen.generator.config.NameGeneratorConfig;

public class RandomNameGenerator implements NameGenerator {

	private Random random;
	private NameGeneratorConfig config;

	@Override
	public String generateFirstName() {
		int gender = random.nextInt(2);
		if (gender == 0) {
			List<String> menNames = config.getMenNames();
			return menNames.get(random.nextInt(menNames.size()));
		} else {
			List<String> womenNames = config.getWomenNames();
			return womenNames.get(random.nextInt(womenNames.size()));
		}
	}

	@Override
	public String generateLastName() {
		List<String> lastNames = config.getLastNames();
		return lastNames.get(random.nextInt(lastNames.size()));
	}

	public Random getRandom() {
		return random;
	}

	@Autowired
	public void setRandom(Random random) {
		this.random = random;
	}

	public NameGeneratorConfig getConfig() {
		return config;
	}

	@Autowired
	public void setConfig(NameGeneratorConfig config) {
		this.config = config;
	}

}
