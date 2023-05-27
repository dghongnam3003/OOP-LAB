
public class Aims {
	public static void main(String[] args) {
		Cart an0ther = new Cart();
		
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
		an0ther.addDigitalVideoDisc(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
		an0ther.addDigitalVideoDisc(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
		an0ther.addDigitalVideoDisc(dvd3);
		
		an0ther.removeDigitalVideoDisc(dvd3);
		
		System.out.println("Total Cost is: ");
		System.out.println(an0ther.totalCost());
	}
}
