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
		arr[size] = input.get(size);
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
				addToArray();
				size = input.size();
			}
		}
		catch(NumberFormatException e) {
			throw new FormatException("Invalid input.");
		}
	}
	
	public void sort() { //uses insertion sort
		int hole;
		int val;
		for(int i=1; i<size; i++) {
			hole = i;
			val = arr[i];
			while(hole>0 && arr[hole-1]>val) {
				arr[hole] = arr[hole-1];
				hole -= 1;
			}
			arr[hole] = val;
		}
	}
	
	private double getMean() {
		int sum = 0;
		for(int i=0; i<size; i++) {
			sum += arr[i];
		}
		return sum/(double)size;
	}
	
	private String getMode() {
		ArrayList<Integer> mode = new ArrayList<>();
		int modeCount =1;
		int count;
		for(int i=0; i<size; i++) {
			count = 0;
			for(int j=0; j<size; j++) {
				if(arr[i] == arr[j]) {
					count++;
				}
			}
			if(count>modeCount) {
				mode.clear();
				mode.add(arr[i]);
				modeCount = count;
			}
			else if(count==modeCount && modeCount>1) {
				mode.add(arr[i]);
			}
		}
		System.out.println(mode);
		
		
		
		
//		int modeCount = 1;
//		int count = 1;
//		ArrayList<Integer> mode = new ArrayList<>();
//		for(int i=1; i<size; i++) {
//			if(arr[i]==arr[i-1]) {
//				count++;
//				System.out.println(count + " " + modeCount + " " + mode);
//			}
//			if(arr[i]!=arr[i-1] || i==size-1) {
//				if(count>modeCount) {
//					mode.clear();
//					mode.add(arr[i-1]);
//					modeCount = count;
//					count = 1;
//					System.out.println("\n");
//				}
//				else if(count==modeCount && modeCount>1) {
//					mode.add(arr[i-1]);
//					count = 1;
//					System.out.println("\n");
//				}
//			}
//		}
		if(mode.isEmpty()) {
			return "None";
		}
		String out = "";
		for(int i : mode) {
			if(i==mode.get(0)) {
				out += String.format("%d", i);
			}
			else {
				out += ", " + String.format("%d", i);
			}
		}
		return out;
	}
	
	private String getMedian() {
		if(size%2!=0) {
			return String.format("%d", arr[size/2]);
		}
		double median = (arr[size/2-1]+arr[size/2])/2.0;
		if(median==(int)median) {
			return String.format("%d", (int)median);
		}
		return String.format("%.3f", median);
	}
	
	private String getDeviation() {
		double[] dev = new double[size];
		for(int i=0; i<size; i++) {
			dev[i] = Math.pow(arr[i]-getMean(), 2);
		}
		double sum = 0;
		for(double d : dev) {
			sum += d;
		}
		return String.format("%.3f", Math.sqrt(sum/size));
	}
	
	public String getOutput() {
		String out = "";
		out += "Mean: " + String.format("%.3f", getMean()) + "\n";
		out += "Median: " + getMedian() + "\n"; 
		if(getMode().contains(",")) {
			out += "Modes: " + getMode() + "\n";
		}
		else {
			out += "Mode: " + getMode() + "\n";
		}
		out += "Standard Deviation: " + getDeviation() + "\n";
		return out;
	}
	
	public String toString() {
		String out = String.format("%d", arr[0]);
		for(int i=1; i<size; i++) {
			out += ", " + String.format("%d", arr[i]);
		}
		return out;
	}
}