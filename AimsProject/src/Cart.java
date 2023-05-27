import java.util.Arrays;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < itemsOrdered.length) {
			itemsOrdered[qtyOrdered++] = disc;
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The cart is almost full");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] == disc) {
				for (int j = i; j < qtyOrdered; j++) {
					itemsOrdered[j] = itemsOrdered[j+1];
				}
				itemsOrdered[--qtyOrdered] = null;
				return;
			}
		}
	}
	
	public float totalCost() {
		float total = 0.0f;
		for (int i = 0; i < qtyOrdered; i++ ) {
			total += itemsOrdered[i].getCost();
		}
		
		return total;
	}
}