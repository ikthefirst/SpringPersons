package code.spring.person.gen.generator.config;

public class CityEntry {

	private String cityName;
	private String cityState;
	private Integer minPostcode;
	private Integer maxPostcode;

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getCityState() {
		return cityState;
	}

	public void setCityState(String cityState) {
		this.cityState = cityState;
	}

	public Integer getMinPostcode() {
		return minPostcode;
	}

	public void setMinPostcode(Integer minPostcode) {
		this.minPostcode = minPostcode;
	}

	public Integer getMaxPostcode() {
		return maxPostcode;
	}

	public void setMaxPostcode(Integer maxPostcode) {
		this.maxPostcode = maxPostcode;
	}
}
