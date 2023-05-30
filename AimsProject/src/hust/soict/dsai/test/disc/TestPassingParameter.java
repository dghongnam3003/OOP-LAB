package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.util.concurrent.atomic.AtomicReference;

public class TestPassingParameter {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
		System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("jungle dvd title: " + jungleDVD.getTitle());
	}
	
	/*public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}*/
	
	//hello
	
	public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        AtomicReference<DigitalVideoDisc> temp = new AtomicReference<>(dvd1);
        dvd1 = dvd2;
        dvd2 = temp.get();
    }
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}


