package code.spring.person.gen;

import java.util.List;

import org.springframework.aop.aspectj.annotation.AnnotationAwareAspectJAutoProxyCreator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import code.spring.person.bo.Person;
import code.spring.person.gen.config.PersonGeneratorBeanConfig;
import code.spring.person.gen.config.PersonGeneratorBeanConfigAOP;
import code.spring.person.gen.generator.PersonGenerator;

public class GeneratorApplicationAOP {

	public static void main(String[] args) {
		// ApplicationContext ctx;
		// ctx = new ClassPathXmlApplicationContext("generate_person_aop.xml");

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				PersonGeneratorBeanConfigAOP.class);

		PersonGenerator generator = (PersonGenerator) ctx.getBean("personGenerator");
		List<Person> personList = generator.generate(25);
		for (Person person : personList) {
			System.out.println(person);
		}

	}
}
