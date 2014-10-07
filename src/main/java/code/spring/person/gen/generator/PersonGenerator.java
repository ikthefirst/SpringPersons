package code.spring.person.gen.generator;

import java.util.List;

import code.spring.person.gen.person.Person;

/**
 * Interface for generating person objects.
 */
public interface PersonGenerator {

	/**
	 * Generate n person objects.
	 * 
	 * @return
	 */
	public List<Person> generate(int n);

	/**
	 * Generate a person object.
	 * 
	 * @return
	 */
	public Person generate();
}
