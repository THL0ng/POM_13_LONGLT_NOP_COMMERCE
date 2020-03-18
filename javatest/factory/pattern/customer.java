package factory.pattern;

public class customer {
	
	public static void main(String arrg[]) {
		customer customer = new customer();
		
		customer.viewHonda();
		customer.viewLexus();
		customer.viewHuyndai();
		
		CarFactory carFactory = new CarFactory();
		carFactory.viewCar("Honda");
		carFactory.viewCar("Lexus");
		carFactory.viewCar("Huyndai");

		
		
	}
	public void viewHonda() {
		Honda honda = new Honda();
		honda.viewCar();
		System.out.println(honda.getCarName());
	}
	
	public void viewLexus() {
		Lexus lexus = new Lexus();
		lexus.viewCar();
		System.out.println(lexus.getCarName());
	}
	
	
	public void viewHuyndai() {
		Huyndai huyndai = new Huyndai();
		huyndai.viewCar();
		System.out.println(huyndai.getCarName());
	}

}
