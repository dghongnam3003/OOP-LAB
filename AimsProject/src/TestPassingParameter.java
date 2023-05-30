
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
	
	public static void swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title) {
		String oldTitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldTitle);
	}
}


/*
 - The title of the objects jungleDVD and cinderellaDVD remains the same after the call to swap(jungleDVD, cinderellaDVD) because Java passes arguments to methods by value.

In the swap method, the values of o1 and o2 are swapped using a temporary variable tmp. However, the swapping operation only modifies the local copies of the references o1 and o2 within the swap method. These local copies are distinct from the original references jungleDVD and cinderellaDVD in the main method.

Therefore, the swap operation performed inside the swap method does not affect the original references jungleDVD and cinderellaDVD in the main method.
- After the call to changeTitle(jungleDVD, cinderellaDVD.getTitle()), the title of jungleDVD appears to be changed because the changeTitle method modifies the dvd object's title by using getter and setter
*/
