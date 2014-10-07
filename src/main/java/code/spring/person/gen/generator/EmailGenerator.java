package code.spring.person.gen.generator;

import java.util.Date;

public interface EmailGenerator {

	public String generateEmail(String firstName, String lastName,
			Date birthDate);

}
