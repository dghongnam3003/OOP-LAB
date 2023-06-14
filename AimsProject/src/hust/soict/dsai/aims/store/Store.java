package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.Collections;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	private Cart cart;
	
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
	
	public void displayStore() {
        System.out.println("Items in the store:");
        System.out.println("--------------------------------");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
        System.out.println("--------------------------------");
    }
	
	public Media search(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        return null;
    }
	
	public void filterCartById(int id) {
        ArrayList<Media> filteredList = new ArrayList<>();
        for (Media media : cart.getItemsOrdered()) {
            if (media.getId() == id) {
                filteredList.add(media);
            }
        }
        displayFilteredList(filteredList);
    }
	
	public void filterCartByTitle(String title) {
        ArrayList<Media> filteredList = new ArrayList<>();
        for (Media media : cart.getItemsOrdered()) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                filteredList.add(media);
            }
        }
        displayFilteredList(filteredList);
    }
	
	private void displayFilteredList(ArrayList<Media> filteredList) {
        if (filteredList.isEmpty()) {
            System.out.println("No media found.");
        } else {
            System.out.println("Filtered medias:");
            System.out.println("--------------------------------");
            for (Media media : filteredList) {
                System.out.println(media.toString());
            }
            System.out.println("--------------------------------");
        }
    }
	
	public void sortCartByTitle() {
        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_TITLE_COST);
        System.out.println("Medias in cart have been sorted by title.");
    }
	
	 public void sortCartByCost() {
	        Collections.sort(cart.getItemsOrdered(), Media.COMPARE_BY_COST_TITLE);
	        System.out.println("Medias in cart have been sorted by cost.");
	 }
	 
	 public Media searchCart(String title) {
	        for (Media media : itemsInStore) {
	            if (media.getTitle().equalsIgnoreCase(title)) {
	                return media;
	            }
	        }
	        return null;
	 }
	 
	 public void addToCart(Media media) {
		 cart.addMedia(media);
	 }
	 
	 public void removeFromCart(Media media) {
	        cart.removeMedia(media);
	 }
	 
	 public void displayCart() {
	        if (itemsInStore.isEmpty()) {
	            System.out.println("The cart is empty.");
	        } else {
	            System.out.println("Items in the cart:");
	            System.out.println("--------------------------------");
	            for (Media media : itemsInStore) {
	                System.out.println(media.toString());
	            }
	            System.out.println("--------------------------------");
	        }
	 }
	 
	 public void placeOrder() {
	        itemsInStore.clear();
	 }
}
