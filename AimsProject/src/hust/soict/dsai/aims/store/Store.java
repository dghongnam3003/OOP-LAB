package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media dvd) {
		itemsInStore.add(dvd);
	}
	
	public void removeMedia(Media dvd) {
		if (itemsInStore.contains(dvd)) {
			itemsInStore.remove(dvd);
		}
	}
	
	public ArrayList<Media> getItemsInStore() {
	    return itemsInStore;
	}
}
