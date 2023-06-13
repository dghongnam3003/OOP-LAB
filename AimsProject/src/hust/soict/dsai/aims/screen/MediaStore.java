package hust.soict.dsai.aims.screen;

import javax.swing.*;

import hust.soict.dsai.aims.media.*;

import java.awt.*;
import java.util.*;

public class MediaStore extends JPanel {
	private Media media;
	private JButton btnAddToCart;
	private JButton btnPlay;
	
	public MediaStore(Media media) {
		
		this.media = media;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		container.add(new JButton("Add to cart"));
		if (media instanceof Playable) {
			container.add((new JButton("Play")));
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public JButton getAddToCartButton() {
		return btnAddToCart;
	}
	
	public JButton getPlayButton() {
		return btnPlay;
	}
	
	public Media getMedia() {
		return media;
	}
}
