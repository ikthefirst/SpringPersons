package code.spring.person.gen.generator.readers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import code.spring.person.gen.generator.config.CityEntry;

public class ConfigReader {

	private ResourceFileReader resourceFileReader;

	public List<String> readLines(String resourceURL) {
		return resourceFileReader.readPropertyFile(resourceURL);
	}

	public List<CityEntry> readCityEntries(String resourceURL) {
		List<CityEntry> addressEntries = new ArrayList<>();
		List<String> lines = resourceFileReader.readPropertyFile(resourceURL);
		for (String line : lines) {
			addressEntries.add(createCityEntry(line));
		}
		return addressEntries;
	}

	public CityEntry createCityEntry(String line) {
		String[] tokens = line.split(",");
		CityEntry entry = new CityEntry();
		entry.setCityName(tokens[0].trim());
		entry.setCityState(tokens[1].trim());
		entry.setMinPostcode(Integer.parseInt(tokens[2].trim()));
		entry.setMaxPostcode(Integer.parseInt(tokens[3].trim()));
		return entry;
	}

	public ResourceFileReader getResourceFileReader() {
		return resourceFileReader;
	}

	@Autowired
	public void setResourceFileReader(ResourceFileReader resourceFileReader) {
		this.resourceFileReader = resourceFileReader;
	}

}
