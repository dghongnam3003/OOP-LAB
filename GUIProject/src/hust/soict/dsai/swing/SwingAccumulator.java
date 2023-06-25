package hust.soict.dsai.swing;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class SwingAccumulator extends JFrame {
	private JTextField tfInPut;
	private JTextField tfOutPut;
	private int sum = 0;		//Accumulated sum, init to 0
	
	//Constructor to setup the GUI components and event handlers
	public SwingAccumulator() {
		Container cp = getContentPane();
		cp.setLayout(new GridLayout(2, 2));
		
		cp.add(new JLabel("Enter an Integer: "));
		
		tfInPut = new JTextField(10);
		cp.add(tfInPut);
		tfInPut.addActionListener(new TFInputListener());
		
		cp.add(new JLabel("The Accumulated Sum is: "));
		
		tfOutPut = new JTextField(10);
		tfOutPut.setEditable(false);
		cp.add(tfOutPut);
		
		setTitle("Swing Accumulator");
		setSize(350, 120);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SwingAccumulator();
	}
	
	private class TFInputListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			int numberIn = Integer.parseInt(tfInPut.getText());
			sum += numberIn;
			tfInPut.setText("");
			tfOutPut.setText(sum + "");
		}
	}
}
