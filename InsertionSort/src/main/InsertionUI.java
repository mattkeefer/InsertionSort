package main;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import BreezySwing.*;

public class InsertionUI extends GBFrame {

	JLabel inputLabel = addLabel("Input string of numbers:", 1,1,2,1);
	JButton inputButton = addButton("Input", 3,1,1,1);
	JTextField inputField = addTextField("", 2,1,2,1);
	JButton resetButton = addButton("Reset", 3,2,1,1);
	JTextArea output = addTextArea("", 4,1,2,1);
	
	Sorter s;
	int count;
	
	public InsertionUI() {
		count = 0;
		output.setFont(new Font("Arial", Font.TRUETYPE_FONT, 15));
		output.setEditable(false);
	}
	
	public static void main(String[] args) {
		JFrame frm = new InsertionUI();
		frm.getContentPane().setBackground(new Color(255, 204, 94));
		frm.setTitle("Insertion Sort");
		frm.setSize(400, 250);
		frm.setVisible(true);
	}
	
	public void buttonClicked(JButton button) {
		if(button == resetButton) {
			count = 0;
			inputField.setText("");
			output.setText("");
			inputLabel.setText("Input string of numbers:");
		}
		if(button == inputButton) {
			try {
				if(count==0) {
					s = new Sorter(inputField.getText().trim()); //creates new list (Sorter object)
					count++;
				}
				else {
					s.add(inputField.getText().trim());
				}
				inputLabel.setText(s.toString());
				startSort();
			}
			catch(FormatException e) {
				messageBox(e.getMessage());
				if(count==0) {
					inputLabel.setText("Input string of numbers:");
				}
				else {
					inputLabel.setText(s.toString());
					startSort();
				}
			}
			inputField.setText("");
		}
	}
	
	private void startSort() { //method replaces sort button previously included in program, makes program more seamless
		s.sort();
		inputLabel.setText(s.toString());
		output.setText(s.getOutput());
	}
}