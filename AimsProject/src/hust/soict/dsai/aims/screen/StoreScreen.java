package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;

public class StoreScreen extends JFrame {
	private static Store store = new Store();
	private static Cart cart = new Cart();
	
	public StoreScreen(Store store) {
		StoreScreen.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem smAddBook = new JMenuItem("Add Book");
		JMenuItem smAddCD = new JMenuItem("Add CD");
		JMenuItem smAddDVD = new JMenuItem("Add DVD");
		smUpdateStore.add(smAddBook);
		smUpdateStore.add(smAddCD);
		smUpdateStore.add(smAddDVD);
		
		smAddBook.addActionListener(new btnMenuListener());
		smAddCD.addActionListener(new btnMenuListener());
		smAddDVD.addActionListener(new btnMenuListener());
		
		menu.add(smUpdateStore);

		JMenuItem viewStoreMenu = new JMenuItem("View Store");
		JMenuItem viewCartMenu = new JMenuItem("View Cart");
		menu.add(viewStoreMenu);
		menu.add(viewCartMenu);
		
		viewStoreMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new StoreScreen(store);
			}
		});
		
		viewCartMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new CartScreen(cart);
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		
		return menuBar;
	}
	
	private class btnMenuListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("Add Book")) {
				new AddBookToStoreScreen(store);
			} else if (command.equals("Add CD")) {
				new AddCDToStoreScreen(store);
			} else if (command.equals("Add DVD")) {
				new AddDVDToStoreScreen(store);
			}
		}
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton cart = new JButton("View cart");
		cart.setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;
	}
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < mediaInStore.size(); i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
	
	public static void initMedia() {
        Book book1 = new Book("The Lean Startup", "Business/Entrepreneurship", 14.99f);
        store.addMedia(book1);
        Book book2 = new Book("1984", "Fiction/Dystopian", 10.99f);
        store.addMedia(book2);
        Book book3 = new Book("The Da Vinci Code", "Fiction/Thriller", 9.99f);
        store.addMedia(book3);

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The God Father", "Crime/Drama", "Francis Ford Coppola", 175, 12.99f);
        store.addMedia(dvd1);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("The Dark Knight", "Action/Crime/Drama", "Christopher Nolan", 152, 10.99f);
        store.addMedia(dvd2);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("The ShawShank Redemption", "Drama", "Frank Darabont", 142, 9.99f);
        store.addMedia(dvd3);

        CompactDisc cd1 = new CompactDisc("Thriller", "Pop", 9.99f, null, "Michael Jackson");
        store.addMedia(cd1);
        CompactDisc cd2 = new CompactDisc("Back in Black", "Rock", 11.99f, null, "AC/DC");
        store.addMedia(cd2);
        CompactDisc cd3 = new CompactDisc("21", "Pop", 12.99f, null, "Adele");
        store.addMedia(cd3);
    }
    public static void main(String[] args) {
        initMedia();
        new StoreScreen(store);
    }
}
