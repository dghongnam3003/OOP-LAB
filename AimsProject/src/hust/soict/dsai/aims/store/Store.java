package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc [] itemsInStore = new DigitalVideoDisc[0];
	
	public void addDVD(DigitalVideoDisc dvd) {
		DigitalVideoDisc [] newItemsInStore = new DigitalVideoDisc[itemsInStore.length + 1];
		for (int i = 0; i < itemsInStore.length; i++) {
			newItemsInStore[i] = itemsInStore[i];
		}
		newItemsInStore[itemsInStore.length] = dvd;
		itemsInStore = newItemsInStore;
	}
	
	public void removeDVD(DigitalVideoDisc dvd) {
		for (int i = 0; i < itemsInStore.length; i++) {
			if (dvd.getId() == itemsInStore[i].getId()) {
				DigitalVideoDisc [] newItemsInStore = new DigitalVideoDisc[itemsInStore.length -1];
				for (int j = i+1; j < itemsInStore.length; j++) {
					itemsInStore[j-1] = itemsInStore[j];
				}
				itemsInStore[itemsInStore.length-1] = null;
				for (int j = 0; j < itemsInStore.length - 1; j++) {
					newItemsInStore[j] = itemsInStore[j];
				}
				itemsInStore = newItemsInStore;
			}
		}
	}
	
	public DigitalVideoDisc[] getItemsInStore() {
	    return itemsInStore;
	}
}
