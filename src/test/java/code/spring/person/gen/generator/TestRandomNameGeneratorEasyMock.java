package code.spring.person.gen.generator;

import java.util.ArrayList;
import java.util.Random;

import org.junit.*;

import code.spring.person.gen.generator.config.NameGeneratorConfig;
import code.spring.person.gen.generator.impl.RandomNameGenerator;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

/**
 * Tests for RandomNameGenerator, using EasyMock.
 */
public class TestRandomNameGeneratorEasyMock {

	public ArrayList<String> mockNames;
	public ArrayList<String> mockWomenNames;
	public ArrayList<String> mockMenNames;

	public void setUpNameArrays() {
		mockNames = new ArrayList<String>();
		mockNames.add("a");

		mockMenNames = new ArrayList<String>();
		mockMenNames.add("man");

		mockWomenNames = new ArrayList<String>();
		mockWomenNames.add("woman");
	}

	@Test
	public void generateFirstNameShouldCallRandomTwice() {

		// given
		setUpNameArrays();
		Random random = createMock(Random.class);
		NameGeneratorConfig config = createMock(NameGeneratorConfig.class);

		RandomNameGenerator generator = new RandomNameGenerator();
		generator.setRandom(random);
		generator.setConfig(config);

		// when
		expect(config.getMenNames()).andReturn(mockNames);
		expect(config.getWomenNames()).andReturn(mockNames);
		replay(config);

		expect(random.nextInt(anyInt())).andReturn(0);
		expect(random.nextInt(anyInt())).andReturn(0);
		replay(random);

		// then
		generator.generateFirstName();

		verify(random);
	}

	@Test
	public void generateLastNameShouldCallRandomOnce() {

		// given
		setUpNameArrays();
		Random random = createMock(Random.class);
		NameGeneratorConfig config = createMock(NameGeneratorConfig.class);

		RandomNameGenerator generator = new RandomNameGenerator();
		generator.setRandom(random);
		generator.setConfig(config);

		// when
		expect(config.getLastNames()).andReturn(mockNames);
		replay(config);

		expect(random.nextInt(anyInt())).andReturn(0);
		replay(random);

		// then
		generator.generateLastName();

		verify(random);
	}

	@Test
	public void generateLastNameShouldReturnGivenNameIfListIsSet() {
		// given
		setUpNameArrays();
		Random random = createNiceMock(Random.class);
		NameGeneratorConfig config = createNiceMock(NameGeneratorConfig.class);

		RandomNameGenerator generator = new RandomNameGenerator();
		generator.setRandom(random);
		generator.setConfig(config);

		// when
		expect(random.nextInt(anyInt())).andReturn(0);
		replay(random);

		expect(config.getLastNames()).andReturn(mockNames);
		replay(config);

		// then
		assertEquals("Generated last name should be 'a'.", "a", generator.generateLastName());
	}

	@Test
	public void generateFirstNameShouldReturnGivenNameIfListIsSetAndMenIsSelected() {
		// given
		setUpNameArrays();
		Random random = createNiceMock(Random.class);
		NameGeneratorConfig config = createNiceMock(NameGeneratorConfig.class);

		RandomNameGenerator generator = new RandomNameGenerator();
		generator.setRandom(random);
		generator.setConfig(config);

		// when
		expect(random.nextInt(anyInt())).andReturn(0);
		replay(random);

		expect(config.getMenNames()).andReturn(mockMenNames);
		expect(config.getWomenNames()).andReturn(mockWomenNames);
		replay(config);

		// then
		assertEquals("Generated first name should be 'man'.", "man", generator.generateFirstName());
	}

	@Test
	public void generateFirstNameShouldReturnGivenNameIfListIsSetAndWomenIsSelected() {
		// given
		setUpNameArrays();
		Random random = createNiceMock(Random.class);
		NameGeneratorConfig config = createNiceMock(NameGeneratorConfig.class);

		RandomNameGenerator generator = new RandomNameGenerator();
		generator.setRandom(random);
		generator.setConfig(config);

		// when
		expect(random.nextInt(anyInt())).andReturn(1);
		replay(random);

		expect(config.getMenNames()).andReturn(mockMenNames);
		expect(config.getWomenNames()).andReturn(mockWomenNames);
		replay(config);

		// then
		assertEquals("Generated first name should be 'woman'.", "woman", generator.generateFirstName());
	}

	@Test(expected = NullPointerException.class)
	public void generateFirstNameShouldThrowNullPointerExceptionIfMenNamesNotSetInConfig() {

		// given
		Random random = createMock(Random.class);
		NameGeneratorConfig config = createNiceMock(NameGeneratorConfig.class);

		RandomNameGenerator generator = new RandomNameGenerator();
		generator.setRandom(random);
		generator.setConfig(config);

		// when
		expect(random.nextInt(anyInt())).andReturn(0);
		expect(random.nextInt(anyInt())).andReturn(0);
		replay(random);

		// then
		generator.generateFirstName();
	}

	@Test(expected = NullPointerException.class)
	public void generateFirstNameShouldThrowNullPointerExceptionIfWomenNamesNotSetInConfig() {

		// given
		Random random = createMock(Random.class);
		NameGeneratorConfig config = createNiceMock(NameGeneratorConfig.class);

		RandomNameGenerator generator = new RandomNameGenerator();
		generator.setRandom(random);
		generator.setConfig(config);

		// when
		expect(random.nextInt(anyInt())).andReturn(1);
		expect(random.nextInt(anyInt())).andReturn(0);
		replay(random);

		// then
		generator.generateFirstName();
	}

	@Test(expected = NullPointerException.class)
	public void generateLastNameShouldThrowNullPointerExceptionIfListsNotSetInConfig() {

		// given
		Random random = createMock(Random.class);
		NameGeneratorConfig config = createNiceMock(NameGeneratorConfig.class);

		RandomNameGenerator generator = new RandomNameGenerator();
		generator.setRandom(random);
		generator.setConfig(config);

		// when
		expect(random.nextInt(anyInt())).andReturn(0);
		replay(random);

		// then
		generator.generateLastName();
	}
}
