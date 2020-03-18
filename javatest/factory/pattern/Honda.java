package factory.pattern;

public class Honda extends Car {

	@Override
	public void viewCar() {
		System.out.println("xem cac dong xe cua Honda");
	}

	@Override
	public String getCarName() {
		String hondaTypeName = "CRV - HRV - ...";	
		return hondaTypeName;
	}

}
