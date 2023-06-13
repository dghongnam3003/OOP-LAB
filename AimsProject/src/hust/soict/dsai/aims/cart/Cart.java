package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.List;
import java.util.ArrayList;

public class Cart {
	
	public static final int MAX_NUMBERS_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

	public void addMedia(Media dvd) {
		if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
			itemsOrdered.add(dvd);
			System.out.println("The disc has been added");
		}
		else {
			System.out.println("The cart is full");
		}
	}

	public void removeMedia(Media dvd) {
		if (itemsOrdered.contains(dvd)) {
			itemsOrdered.remove(dvd);
		}
	}
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		float totalCost = 0;
		for (int i = 0; i < itemsOrdered.size(); i++) {
			Media dvd = itemsOrdered.get(i);
			System.out.println((i+1) + ". " + dvd.toString());
			totalCost += dvd.getCost();
		}
		System.out.println("Total cost: " + totalCost);
		System.out.println("***************************************************");
	}
	
	public void searchById(int idToSearch) {
		boolean idMatch = false;
		for (Media dvd : itemsOrdered) {
			if (dvd != null) {
				if (dvd.getId() == idToSearch) {
					System.out.println(dvd.toString());
					idMatch = true;
					break;
				}
				else {
					break;
				}
			}
		}
		if (idMatch == false) {
			System.out.println("No DVD found with ID " + idToSearch);
		}
	}
	
	public void searchByTitle(String titleToSearch) {
        boolean titleMatch = false;
        for (Media dvd : itemsOrdered) {
        	if (dvd != null ) {
        		if (dvd.isMatch(titleToSearch)) {
                    System.out.println(dvd.toString());
                    titleMatch = true;
                    break;
                }
        		else {
        			break;
        		}
        	}
            
        }
        if (!titleMatch) {
            System.out.println("No DVD found with title " + titleToSearch);
        }
    }
	
	public float totalCost() {
		float total = 0.0f;
		for (int i = 0; i < itemsOrdered.size(); i++ ) {
			total += itemsOrdered.get(i).getCost();
		}
		
		return total;
	}
}