package PageUIs.liveGuru;

public class LoginPageUI {
	public static final String EMAIL_TEXTBOX = "//input[@id='email']";
	public static final String PASSWORD_TEXTBOX = "//input[@id='pass']";
	public static final String LOGIN_BUTTON = "//button[@id='send2']";
	public static final String EMPTY_EMAIL_ERROR_MESSAGE = "//div[@id='advice-required-entry-email' and text()='%s']";
	// This is a required field.
	public static final String EMPTY_PASSWORD_ERROR_MESSAGE = "//div[@id='advice-required-entry-pass' and text()='%s']";
	// This is a required field.
	public static final String INVALID_EMAIL_ERROR_MESSAGE = "//div[@id='advice-validate-email-email' and text()='%s']";
	// Please enter a valid email address. For example johndoe@domain.com.
	public static final String NOT_EXIST_EMAIL_OR_INCORRECT_PASSWORD_ERROR_MESSAGE = "//li[@class='error-msg']//span[text()='%s']";
	// Invalid login or password.
	public static final String PASSWORD_LESS_THAN_ERROR_MESSAGE = "//div[@id='advice-validate-password-pass' and text()='%s']";
	// Please enter 6 or more characters without leading or trailing spaces.
	






}
