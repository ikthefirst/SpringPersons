package code.spring.person.gen.generator;

import java.util.ArrayList;
import java.util.Random;

import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import code.spring.person.gen.generator.config.NameGeneratorConfig;
import code.spring.person.gen.generator.impl.RandomNameGenerator;

/**
 * Tests for RandomNameGenerator, using Mockito.
 */
public class TestRandomNameGeneratorMockito {

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
		Random random = mock(Random.class);
		NameGeneratorConfig config = mock(NameGeneratorConfig.class);

		RandomNameGenerator generator = new RandomNameGenerator();
		generator.setRandom(random);
		generator.setConfig(config);

		when(random.nextInt(anyInt())).thenReturn(0);
		when(config.getMenNames()).thenReturn(mockMenNames);
		when(config.getWomenNames()).thenReturn(mockWomenNames);

		// when
		generator.generateFirstName();

		// then
		verify(random, times(2)).nextInt(anyInt());
	}

	@Test
	public void generateLastNameShouldCallRandomOnce() {
		// given
		setUpNameArrays();
		Random random = mock(Random.class);
		NameGeneratorConfig config = mock(NameGeneratorConfig.class);

		RandomNameGenerator generator = new RandomNameGenerator();
		generator.setRandom(random);
		generator.setConfig(config);

		when(random.nextInt(anyInt())).thenReturn(0);
		when(config.getLastNames()).thenReturn(mockNames);

		// when
		generator.generateLastName();

		// then
		verify(random, times(1)).nextInt(anyInt());
	}

	@Test
	public void generateLastNameShouldReturnGivenNameIfListIsSet() {
		// given
		setUpNameArrays();
		Random random = mock(Random.class);
		NameGeneratorConfig config = mock(NameGeneratorConfig.class);

		RandomNameGenerator generator = new RandomNameGenerator();
		generator.setRandom(random);
		generator.setConfig(config);

		when(random.nextInt(anyInt())).thenReturn(0);
		when(config.getLastNames()).thenReturn(mockNames);

		// when

		// then
		assertEquals("Generated last name should be 'a'.", "a", generator.generateLastName());
	}

	@Test
	public void generateFirstNameShouldReturnGivenNameIfListIsSetAndMenIsSelected() {
		// given
		setUpNameArrays();
		Random random = mock(Random.class);
		NameGeneratorConfig config = mock(NameGeneratorConfig.class);

		RandomNameGenerator generator = new RandomNameGenerator();
		generator.setRandom(random);
		generator.setConfig(config);

		when(random.nextInt(anyInt())).thenReturn(0, 0);
		when(config.getMenNames()).thenReturn(mockMenNames);
		when(config.getWomenNames()).thenReturn(mockWomenNames);

		// when

		// then
		assertEquals("Generated first name should be 'man'.", "man", generator.generateFirstName());
	}

	@Test
	public void generateFirstNameShouldReturnGivenNameIfListIsSetAndWomenIsSelected() {
		// given
		setUpNameArrays();
		Random random = mock(Random.class);
		NameGeneratorConfig config = mock(NameGeneratorConfig.class);

		RandomNameGenerator generator = new RandomNameGenerator();
		generator.setRandom(random);
		generator.setConfig(config);

		when(random.nextInt(anyInt())).thenReturn(1, 0);
		when(config.getMenNames()).thenReturn(mockMenNames);
		when(config.getWomenNames()).thenReturn(mockWomenNames);

		// when

		// then
		assertEquals("Generated first name should be 'woman'.", "woman", generator.generateFirstName());
	}

	@Test(expected = NullPointerException.class)
	public void generateFirstNameShouldThrowNullPointerExceptionIfMenNamesNotSetInConfig() {
		// given
		setUpNameArrays();
		Random random = mock(Random.class);
		NameGeneratorConfig config = mock(NameGeneratorConfig.class);

		RandomNameGenerator generator = new RandomNameGenerator();
		generator.setRandom(random);
		generator.setConfig(config);

		when(random.nextInt(anyInt())).thenReturn(0, 0);
		when(config.getMenNames()).thenReturn(null);
		when(config.getWomenNames()).thenReturn(null);

		// when
		generator.generateFirstName();

		// then
	}

	@Test(expected = NullPointerException.class)
	public void generateFirstNameShouldThrowNullPointerExceptionIfWomenNamesNotSetInConfig() {
		// given
		setUpNameArrays();
		Random random = mock(Random.class);
		NameGeneratorConfig config = mock(NameGeneratorConfig.class);

		RandomNameGenerator generator = new RandomNameGenerator();
		generator.setRandom(random);
		generator.setConfig(config);

		when(random.nextInt(anyInt())).thenReturn(1, 0);
		when(config.getMenNames()).thenReturn(null);
		when(config.getWomenNames()).thenReturn(null);

		// when
		generator.generateFirstName();

		// then
	}

	@Test(expected = NullPointerException.class)
	public void generateLastNameShouldThrowNullPointerExceptionIfListsNotSetInConfig() {
		// given
		setUpNameArrays();
		Random random = mock(Random.class);
		NameGeneratorConfig config = mock(NameGeneratorConfig.class);

		RandomNameGenerator generator = new RandomNameGenerator();
		generator.setRandom(random);
		generator.setConfig(config);

		when(random.nextInt(anyInt())).thenReturn(0);
		when(config.getLastNames()).thenReturn(null);

		// when
		generator.generateLastName();

		// then
	}
}
