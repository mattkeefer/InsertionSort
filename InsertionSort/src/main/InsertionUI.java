package main;
import java.awt.Color;
import javax.swing.*;
import BreezySwing.*;

public class InsertionUI extends GBFrame {

	JLabel inputLabel = addLabel("Input string of numbers:", 1,1,4,1);
	JButton inputButton = addButton("Input", 3,1,1,1);
	JTextField inputField = addTextField("", 2,1,4,1);
	JButton resetButton = addButton("Reset", 3,3,1,1);
	JButton sortButton = addButton("Sort", 3,4,1,1);
	
	Sorter s;
	
	public InsertionUI() {
		sortButton.setEnabled(false);
	}
	
	public static void main(String[] args) {
		JFrame frm = new InsertionUI();
		frm.getContentPane().setBackground(new Color(255, 204, 94));
		frm.setTitle("Insertion Sort");
		frm.setSize(400, 200);
		frm.setVisible(true);
	}
	
	public void buttonClicked(JButton button) {
		if(button == resetButton) {
			inputField.setText("");
			inputLabel.setText("Input string of numbers:");
			sortButton.setEnabled(false);
		}
		if(button == inputButton) {
			try {
				s = new Sorter(inputField.getText().trim());
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
			}
		}
	}
}