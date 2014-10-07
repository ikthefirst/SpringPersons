package code.spring.person.gen.generator.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import code.spring.person.gen.generator.DateGenerator;

public class RandomDateGenerator implements DateGenerator {

	private Random random;
	private SimpleDateFormat dateFormat;
	private String startDate;
	private String endDate;

	@Override
	public Date generateDate() {
		Date start = null;
		Date end = null;

		try {
			start = dateFormat.parse(startDate);
			end = dateFormat.parse(endDate);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}

		if (start.getTime() > end.getTime()) {
			throw new RuntimeException("Start date must be before end date.");
		}

		long startTime = start.getTime();
		long endTime = end.getTime();
		double r = random.nextDouble();
		long genTime = startTime + (long) (r * (endTime - startTime));

		return new Date(genTime);
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public SimpleDateFormat getFormat() {
		return dateFormat;
	}

	@Value("yyyy.MM.dd")
	public void setFormat(SimpleDateFormat format) {
		this.dateFormat = format;
	}

	public Random getRandom() {
		return random;
	}

	@Autowired
	public void setRandom(Random random) {
		this.random = random;
	}

}
