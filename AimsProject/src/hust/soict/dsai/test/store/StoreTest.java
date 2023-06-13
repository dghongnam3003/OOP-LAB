package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class StoreTest {
	public static void main(String[] args) {
		Store store = new Store();
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Godfather", "Crime", "Francis Ford Coppola", 10.99f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Dark Knight", "Action", "Christopher Nolan", 9.99f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Pulp Fiction", "Crime", "Quentin Tarantino", 8.99f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        
        // Print the items in the store
        ArrayList<Media> itemsInStore = store.getItemsInStore();
        System.out.println("Items in store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println(itemsInStore.get(i).toString());
        }
        
        // Remove a DVD from the store
        store.removeMedia(dvd2);
        
        // Print the items in the store again
        itemsInStore = store.getItemsInStore();
        System.out.println("Items in store after removing " + dvd2.getTitle() + ":");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println(itemsInStore.get(i).toString());
        }
	}
}
