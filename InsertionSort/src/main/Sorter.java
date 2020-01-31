package main;
import java.util.*;

public class Sorter {

	private ArrayList unsorted;
	private int[] sorted;
	
	public Sorter(String str) throws FormatException {
		unsorted = new ArrayList<Integer>();
		add(str);
		sorted = new int[25];
	}
	
	public void add(String str) throws FormatException {
		String[] input = str.split(",");
		if(str.replaceAll(",", "").trim().equals("")) {
			throw new FormatException("Invalid input.");
		}
		try {
			for(String s : input) {
				if(unsorted.size()==25) {
					throw new FormatException("Max of 25 numbers accepted.");
				}
				unsorted.add(Integer.parseInt(s.trim()));
			}
		}
		catch(NumberFormatException e) {
			throw new FormatException("Invalid input.");
		}
	}
	
	private void sort() { //uses insertion sort
		
	}
	
	private String getMean() {
		int sum = 0;
		for(int i=0; i<sorted.length; i++) {
			sum += sorted[i];
		}
		return String.format("%f", sum/2.0);
	}
	
	private String getMode() {
		
	}
	
	private String getMedian() {
		
	}
	
	private String getDeviation() {
		
	}
	
	public String getOutput() {
		String out = "";
		out += "Mean: " + getMean() + "\n";
		out += "Mode: " + getMode() + "\n";
		out += "Median: " + getMedian() + "\n";
		out += "Standard Deviation: " + getDeviation() + "\n";
	}
	
	public String toString() { //works for unsorted inputs
		String out = String.format("%d", unsorted.get(0));
		for(int i=1; i<unsorted.size(); i++) {
			out += ", " + String.format("%d", unsorted.get(i));
		}
		return out;
	}
}