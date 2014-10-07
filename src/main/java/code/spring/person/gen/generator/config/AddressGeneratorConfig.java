package code.spring.person.gen.generator.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import code.spring.person.bo.CityEntry;

public class AddressGeneratorConfig {

	private List<CityEntry> cityEntries;
	private List<String> streetNames;

	public List<CityEntry> getCityEntries() {
		return cityEntries;
	}

	public void setCityEntries(List<CityEntry> cityEntries) {
		this.cityEntries = cityEntries;
	}

	public List<String> getStreetNames() {
		return streetNames;
	}

	public void setStreetNames(List<String> streetNames) {
		this.streetNames = streetNames;
	}

}
