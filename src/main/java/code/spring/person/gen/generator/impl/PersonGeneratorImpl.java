package code.spring.person.gen.generator.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import code.spring.person.gen.generator.AddressGenerator;
import code.spring.person.gen.generator.DateGenerator;
import code.spring.person.gen.generator.EmailGenerator;
import code.spring.person.gen.generator.NameGenerator;
import code.spring.person.gen.generator.PersonGenerator;
import code.spring.person.gen.person.Person;

public class PersonGeneratorImpl implements PersonGenerator {

	private NameGenerator nameGenerator;
	private AddressGenerator addressGenerator;
	private EmailGenerator emailGenerator;
	private DateGenerator dateGenerator;

	@Override
	public Person generate() {
		Person person = new Person();
		person.setFirstName(nameGenerator.generateFirstName());
		person.setLastName(nameGenerator.generateLastName());
		person.setDateOfBirth(dateGenerator.generateDate());
		person.setEmail(emailGenerator.generateEmail(person.getFirstName(), person.getLastName(),
				person.getDateOfBirth()));
		person.setAddress(addressGenerator.generateAddress());
		return person;
	}

	@Override
	public List<Person> generate(int n) {
		List<Person> generated = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			generated.add(generate());
		}
		return generated;
	}

	public NameGenerator getNameGenerator() {
		return nameGenerator;
	}

	@Autowired
	public void setNameGenerator(NameGenerator nameGenerator) {
		this.nameGenerator = nameGenerator;
	}

	public AddressGenerator getAddressGenerator() {
		return addressGenerator;
	}

	@Autowired
	public void setAddressGenerator(AddressGenerator addressGenerator) {
		this.addressGenerator = addressGenerator;
	}

	public EmailGenerator getEmailGenerator() {
		return emailGenerator;
	}

	@Autowired
	public void setEmailGenerator(EmailGenerator emailGenerator) {
		this.emailGenerator = emailGenerator;
	}

	public DateGenerator getDateGenerator() {
		return dateGenerator;
	}

	@Autowired
	public void setDateGenerator(DateGenerator dateGenerator) {
		this.dateGenerator = dateGenerator;
	}

}
