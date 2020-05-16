package Commons;

import java.util.Locale;

import com.github.javafaker.Faker;

public class DataHelper {
	
	// Language
	private Locale locale = new Locale("en");
	
	// Init with language
	private Faker faker = new Faker(locale);
	
	
	
	public static DataHelper getData() {
		return new DataHelper();
	}
	
	public String getFirstName() {
		return faker.name().firstName();
	}
	
	public String getLastName() {
		return faker.name().lastName();
	}
	
	public String getFullName() {
		return faker.name().fullName();
	}
	
	public String getAddress() {
		return faker.address().streetAddress();
	}
	
	public String getEmail() {
		return faker.internet().emailAddress();
	}
	
	public String getPassword() {
		return faker.internet().password(6, 20);
	}
	
	public String getPhone() {
		return faker.phoneNumber().phoneNumber();
	}
	
	public String getCompany() {
		return faker.company().name();
	}
	
	public String getCellPhone() {
		return faker.phoneNumber().cellPhone();
	}
	
	public String getCityName() {
		return faker.address().cityName();
	}

}
