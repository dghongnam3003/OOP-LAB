package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;
import java.util.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.screen.controller.CartScreenController;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.*;
import javafx.scene.*;

public class CartScreen extends JFrame {
	private Cart cart;
	
	public CartScreen(Cart cart) {
		super();
		
		this.cart = cart;
		
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setSize(1024,768);
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass()
							.getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void main(String[] args) {
		//create a new cart
				Cart cart = new Cart();
				
				DigitalVideoDisc dvd1 = new DigitalVideoDisc("The God Father", "Crime/Drama", "Francis Ford Coppola", 175, 12.99f);
		        cart.addMedia(dvd1);
		        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Dark Knight", "Action/Crime/Drama", "Christopher Nolan", 152, 10.99f);
		        cart.addMedia(dvd2);
		        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The ShawShank Redemption", "Drama", "Frank Darabont", 142, 9.99f);
		        cart.addMedia(dvd3);
		        
		        Track track1 = new Track("Java", 20);
		        Track track2 = new Track("labOOP", 40);
		        
		        
		        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", 9.99f);
		        cd1.addTrack(track1);
		        cd1.addTrack(track2);
		        cart.addMedia(cd1);
		        CompactDisc cd2 = new CompactDisc("Back in Black", "Rock", 11.99f);
		        cart.addMedia(cd2);
		        CompactDisc cd3 = new CompactDisc("21", "Pop", 12.99f);
		        cart.addMedia(cd3);
				
				new CartScreen(cart);
	}
}
