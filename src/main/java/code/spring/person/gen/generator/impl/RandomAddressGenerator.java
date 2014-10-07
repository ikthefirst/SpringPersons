package code.spring.person.gen.generator.impl;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import code.spring.person.bo.CityEntry;
import code.spring.person.gen.generator.AddressGenerator;
import code.spring.person.gen.generator.config.AddressGeneratorConfig;

public class RandomAddressGenerator implements AddressGenerator {

	private Random random;
	private AddressGeneratorConfig config;

	@Override
	public String generateAddress() {
		CityEntry entry = getRandomAddressEntry();
		String street = generateRandomStreetName();

		int number = random.nextInt(100);
		int postcode = generateRandomPostcode(entry);

		StringBuffer sb = new StringBuffer();
		sb.append(number);
		sb.append(". ");
		sb.append(street);
		sb.append(" st");
		sb.append(", ");
		sb.append(entry.getCityName());
		sb.append(", ");
		sb.append(entry.getCityState());
		sb.append(", ");
		sb.append(postcode);

		return sb.toString();
	}

	private int generateRandomPostcode(CityEntry entry) {
		int postcode = entry.getMinPostcode() + random.nextInt(entry.getMaxPostcode() - entry.getMinPostcode() + 1);
		return postcode;
	}

	private String generateRandomStreetName() {
		List<String> streetNames = config.getStreetNames();
		return streetNames.get(random.nextInt(streetNames.size()));
	}

	private CityEntry getRandomAddressEntry() {
		List<CityEntry> cityEntries = config.getCityEntries();
		CityEntry entry = cityEntries.get(random.nextInt(cityEntries.size()));
		return entry;
	}

	public Random getRandom() {
		return random;
	}

	@Autowired
	public void setRandom(Random random) {
		this.random = random;
	}

	public AddressGeneratorConfig getConfig() {
		return config;
	}

	@Autowired
	public void setConfig(AddressGeneratorConfig config) {
		this.config = config;
	}

}
