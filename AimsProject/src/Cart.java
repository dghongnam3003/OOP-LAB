

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

	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (DigitalVideoDisc disc : dvdList) {
			addDigitalVideoDisc(disc);
		}
	}
	
	/*A method addDigitalVideoDisc which allows to pass an arbitrary number of arguments for DVD
	 public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
		for (DigitalVideoDisc disc : dvdList) {
			addDigitalVideoDisc(disc);
		}
	}
	*/
	
	
	/* I personally prefer using the variable-length argument 
	syntax in this case, as it provides more flexibility and simplicity. 
	However, if you prefer a more explicit and structured approach, 
	using an array parameter may be a better choice.*/
	
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
	
	public void print() {
		System.out.println("***********************CART***********************");
		System.out.println("Ordered Items:");
		float totalCost = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			DigitalVideoDisc dvd = itemsOrdered[i];
			System.out.println((i+1) + ". " + dvd.toString());
			totalCost += dvd.getCost();
		}
		System.out.println("Total cost: " + totalCost);
		System.out.println("***************************************************");
	}
	
	public void searchById(int idToSearch) {
		boolean idMatch = false;
		for (DigitalVideoDisc dvd : itemsOrdered) {
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
        for (DigitalVideoDisc dvd : itemsOrdered) {
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
		for (int i = 0; i < qtyOrdered; i++ ) {
			total += itemsOrdered[i].getCost();
		}
		
		return total;
	}
}