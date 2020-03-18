package factory.pattern;

public class CarFactory {
	public void viewCar(String carType) {
		Car car;
		if(carType.equalsIgnoreCase("Honda")) {
			car = new Honda();
			car.viewCar();
			car.getCarName();
		} else if (carType.equalsIgnoreCase("Lexus")) {
			car = new Lexus();
			car.viewCar();	
			car.getCarName();
		} else if (carType.equalsIgnoreCase("Huyndai")) {
			car = new Lexus();
			car.viewCar();
			car.getCarName();
		}					
	}

}
