package code.spring.person.gen.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import code.spring.person.gen.generator.config.CityEntry;

@Configuration
@PropertySource("classpath:properties/generator.properties")
public class PersonGeneratorPropertiesConfig extends PersonGeneratorBeanConfig {}
