package code.spring.person.gen;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import code.spring.person.bo.Person;
import code.spring.person.gen.generator.PersonGenerator;

public class GeneratorApplication {

	public static void main(String[] args) {
		ApplicationContext ctx;

		ctx = new ClassPathXmlApplicationContext("generate_person.xml");

		// ctx = new
		// AnnotationConfigApplicationContext(PersonGeneratorBeanConfig.class);

		PersonGenerator generator = (PersonGenerator) ctx.getBean("personGenerator");
		List<Person> personList = generator.generate(25);
		for (Person person : personList) {
			System.out.println(person);
		}

	}
}
