package main;
import java.util.*;

public class Sorter {

	private ArrayList unsorted;
	
	public Sorter(String str) throws FormatException {
		unsorted = new ArrayList<Integer>();
		String[] input = str.split(",");
		if(str.replaceAll(",", "").trim().equals("")) {
			throw new FormatException("Invalid input.");
		}
		try {
			for(String s : input) {
				unsorted.add(Integer.parseInt(s.trim()));
			}
			System.out.println(unsorted);
		}
		catch(NumberFormatException e) {
			throw new FormatException("Invalid input.");
		}
	}
	
	private void sort() {
		
	}
}