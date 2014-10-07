package code.spring.person.gen.config;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import code.spring.person.bo.CityEntry;
import code.spring.person.gen.generator.*;
import code.spring.person.gen.generator.config.*;
import code.spring.person.gen.generator.impl.*;
import code.spring.person.gen.generator.readers.ConfigReader;
import code.spring.person.gen.generator.readers.ResourceFileReader;

@Configuration
@PropertySource("classpath:properties/generator.properties")
public class PersonGeneratorBeanConfig {

	@Bean
	public Random random() {
		return new Random();
	}

	@Bean
	public ResourceFileReader resourceFileReader() {
		return new ResourceFileReader();
	}

	@Bean
	public ConfigReader configFactory() {
		return new ConfigReader();
	}

	@Autowired
	private Environment env;

	@Bean
	public List<String> lastNames() {
		return configFactory().readLines(env.getProperty("generator.lastNames"));
	}

	@Bean
	public List<String> menNames() {
		return configFactory().readLines(env.getProperty("generator.menNames"));
	}

	@Bean
	public List<String> womenNames() {
		return configFactory().readLines(env.getProperty("generator.womenNames"));
	}

	@Bean
	public List<String> emailDomains() {
		return configFactory().readLines(env.getProperty("generator.emailDomains"));
	}

	@Bean
	public List<String> streetNames() {
		return configFactory().readLines(env.getProperty("generator.streetNames"));
	}

	@Bean
	public List<CityEntry> cities() {
		return configFactory().readCityEntries(env.getProperty("generator.cities"));
	}

	@Bean
	public NameGeneratorConfig nameGeneratorConfig() {
		NameGeneratorConfig config = new NameGeneratorConfig();
		config.setLastNames(lastNames());
		config.setMenNames(menNames());
		config.setWomenNames(womenNames());
		return config;
	}

	@Bean
	public EmailGeneratorConfig emailGeneratorConfig() {
		EmailGeneratorConfig config = new EmailGeneratorConfig();
		config.setEmailDomains(emailDomains());
		return config;
	}

	@Bean
	public AddressGeneratorConfig addressGeneratorConfig() {
		AddressGeneratorConfig config = new AddressGeneratorConfig();
		config.setCityEntries(cities());
		config.setStreetNames(streetNames());
		return config;
	}

	@Bean
	public NameGenerator nameGenerator() {
		return new RandomNameGenerator();
	}

	@Bean
	public AddressGenerator addressGenerator() {
		return new RandomAddressGenerator();
	}

	@Bean
	public EmailGenerator emailGenerator() {
		return new RandomEmailGenerator();
	}

	@Bean
	public DateGenerator dateGenerator() {
		RandomDateGenerator generator = new RandomDateGenerator();
		generator.setStartDate(env.getProperty("generator.startBirthDate"));
		generator.setEndDate(env.getProperty("generator.endBirthDate"));
		return generator;
	}

	@Bean
	public PersonGenerator personGenerator() {
		return new PersonGeneratorImpl();
	}

}
