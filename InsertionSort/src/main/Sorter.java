package main;
import java.util.*;

public class Sorter {

	private ArrayList<Integer> input;
	private int[] arr;
	private int size;
	
	public Sorter(String str) throws FormatException {
		input = new ArrayList<Integer>();
		arr = new int[25];
		add(str);
	}
	
	private void addToArray() {
		for(int i=size; i<input.size(); i++) {
			arr[i] = input.get(i);
		}
	}
	
	public void add(String str) throws FormatException {
		String[] in = str.split(",");
		if(str.replaceAll(",", "").trim().equals("")) {
			throw new FormatException("Invalid input.");
		}
		try {
			for(String s : in) {
				if(input.size()==25) {
					throw new FormatException("Max of 25 numbers accepted.");
				}
				input.add(Integer.parseInt(s.trim()));
			}
			addToArray();
			size = input.size();
		}
		catch(NumberFormatException e) {
			throw new FormatException("Invalid input.");
		}
	}
	
	public void sort() { //uses insertion sort
		int hole;
		int val;
		System.out.println(size);
		for(int i=1; i<=size; i++) {
			hole = i;
			val = arr[i];
			while(hole>0 && arr[hole-1]>val) {
				arr[hole] = arr[hole-1];
				hole -= 1;
			}
			arr[hole] = val;
		}
	}
	
	private String getMean() {
		int sum = 0;
		for(int i=0; i<size; i++) {
			sum += arr[i];
		}
		return String.format("%.3f", sum/(double)size);
	}
	
	private String getMode() {
		int mode = 1;
		int count = 1;
		for(int i=0; i<size-1; i++) {
			if(arr[i]==arr[i+1]) {
				count++;
			}
			if(count>mode) {
				mode = count;
			}
		}
		if(mode==1) {
			return "None";
		}
		return String.format("%d", mode);
	}
	
	private String getMedian() {
		if(size%2!=0) {
			return String.format("%d", arr[size/2]);
		}
		return String.format("%.3f", (arr[size/2]+arr[size/2+1])/2.0);
	}
	
//	private String getDeviation() {
//		
//	}
	
	public String getOutput() {
		String out = "";
		out += "Mean: " + getMean() + "\n";
		out += "Mode: " + getMode() + "\n";
		out += "Median: " + getMedian() + "\n";
		//out += "Standard Deviation: " + getDeviation() + "\n";
		return out;
	}
	
	public String toString() { //works for arr inputs
		String out = String.format("%d", arr[0]);
		for(int i=1; i<size; i++) {
			out += ", " + String.format("%d", arr[i]);
		}
		return out;
	}
}