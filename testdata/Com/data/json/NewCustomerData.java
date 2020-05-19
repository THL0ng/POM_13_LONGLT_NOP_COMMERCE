package Com.data.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class NewCustomerData {
	public static NewCustomerData getNewCustomerData(String filename) throws JsonParseException,JsonMappingException,IOException{
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
		return mapper.readValue(new File(filename), NewCustomerData.class);
	}
	
	@JsonProperty("firstname")
	String firstname;
	
	@JsonProperty("lastname")
	String lastname;
	
	@JsonProperty("dob")
	String DOB;
	
	@JsonProperty("email")
	String email;
	
	@JsonProperty("address")
	String address;

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public String getDOB() {
		return DOB;
	}

	public String getEmail() {
		return email;
	}

	public String getAddress() {
		return address;
	}
	

}
