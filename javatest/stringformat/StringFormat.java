package stringformat;

public class StringFormat {
	public static void Main(String[] args) {
		String EMPTY_EMAIL_MESSAGE = "//div[@id='advice-required-entry-email' and text()='%S']";
		
		EMPTY_EMAIL_MESSAGE = String.format(EMPTY_EMAIL_MESSAGE,"This is a required field.");

	}

}
