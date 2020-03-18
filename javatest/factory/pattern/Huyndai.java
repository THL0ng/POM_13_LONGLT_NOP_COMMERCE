package factory.pattern;

public class Huyndai extends Car {

	@Override
	public void viewCar() {
		System.out.println("xem cac dong xe cua Huyndai");
		
	}

	@Override
	public String getCarName() {
		String HuyndaiTypeName = "Tucson-Santafe-...";	
		return HuyndaiTypeName;
	}

}
