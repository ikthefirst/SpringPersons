package code.spring.person.gen.generator.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class NameGeneratorConfig {

	private List<String> lastNames;
	private List<String> menNames;
	private List<String> womenNames;

	public List<String> getLastNames() {
		return lastNames;
	}

	public void setLastNames(List<String> lastNames) {
		this.lastNames = lastNames;
	}

	public List<String> getMenNames() {
		return menNames;
	}

	public void setMenNames(List<String> menNames) {
		this.menNames = menNames;
	}

	public List<String> getWomenNames() {
		return womenNames;
	}

	public void setWomenNames(List<String> womenNames) {
		this.womenNames = womenNames;
	}

}
