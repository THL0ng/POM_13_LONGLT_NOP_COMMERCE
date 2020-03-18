package factory.pattern;

public class Lexus extends Car{

	@Override
	public void viewCar() {
		System.out.println("xem cac dong xe cua Lexus");
	
	}

	@Override
	public String getCarName() {
		String LexusTypeName = "570-350-...";	
		return LexusTypeName;

	}

}
