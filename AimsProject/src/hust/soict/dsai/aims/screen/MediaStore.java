package hust.soict.dsai.aims.screen;

import javax.naming.LimitExceededException;
import javax.swing.*;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class MediaStore extends JPanel {
	
	public MediaStore(Media media, Cart cart) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		//add to cart
		JButton btnAdd = new JButton("Add to cart");
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cart.addMedia(media);
				} catch(LimitExceededException e1) {
					e1.printStackTrace();
				}
			}
		});
		container.add(btnAdd);
		
		//play
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog();
                dialog.setTitle("Play Media");
                dialog.setSize(200, 100);
                dialog.setModal(true);

                Playable playableMedia = (Playable) media;
                String mediaInfo = "";
                try {
                    mediaInfo = playableMedia.playGUI();
                } catch (PlayerException e1) {
                    e1.printStackTrace();
                }
                JLabel mediaLabel = new JLabel(mediaInfo);
                mediaLabel.setVerticalAlignment(JLabel.CENTER);
                mediaLabel.setHorizontalAlignment(JLabel.CENTER);

                dialog.add(mediaLabel);
                dialog.setVisible(true);
                dialog.dispose();
			}
		});
		container.add(btnPlay);
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
