package code.spring.person.gen.generator.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public class EmailGeneratorConfig {

	private List<String> emailDomains;

	public List<String> getEmailDomains() {
		return emailDomains;
	}

	public void setEmailDomains(List<String> emailDomains) {
		this.emailDomains = emailDomains;
	}

}
