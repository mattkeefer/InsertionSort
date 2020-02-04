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
				input.add(Integer.parseInt(s.trim())); //trims then parses each value existing between commas
				addToArray();
				size = input.size(); //updates size variable
			}
		}
		catch(NumberFormatException e) {
			throw new FormatException("Invalid input.");
		}
	}
	
	public void sort() { //uses insertion sort to reorder the input
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
	
	private double getMean() { //finds average value of numbers in array
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
			count = 0; //resets count for each number
			for(int j=0; j<size; j++) { //if a value in the array matches the current value, add one to the count
				if(arr[i]==arr[j] && !mode.contains(arr[i])) { //ensures each number is only counted once
					count++;
				}
			}
			if(count>modeCount) { //sets new modeCount, resets mode array list, adds num to mode array list
				mode.clear();
				mode.add(arr[i]);
				modeCount = count;
			}
			else if(count==modeCount && modeCount>1) { //adds num to mode array list
				mode.add(arr[i]);
			}
		}
		if(mode.isEmpty()) { //if no number occurs more than once in the array --> no mode
			return "None";
		}
		String out = "";
		for(int i : mode) { //formats output for mode
			if(i==mode.get(0)) {
				out += String.format("%d", i);
			}
			else {
				out += ", " + String.format("%d", i);
			}
		}
		out += " (" + modeCount + " occurences)"; //number of times a number appears in the array
		return out;
	}
	
	private String getMedian() {
		if(size%2!=0) {
			return String.format("%d", arr[size/2]);
		}
		double median = (arr[size/2-1]+arr[size/2])/2.0;
		if(median==(int)median) {
			return String.format("%d", (int)median); //formats as integer
		}
		return String.format("%.1f", median); //if median isn't integer it will be n+0.5
	}
	
	private String getDeviation() { //finds standard deviation
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
	
	public String getOutput() { //formats output for mean, median, mode, standard deviation
		String out = "";
		out += "Mean: " + String.format("%.3f", getMean()) + "\n";
		out += "Median: " + getMedian() + "\n"; 
		if(getMode().contains(",")) {
			out += "Modes: " + getMode() + "\n"; //if multiple modes, makes
		}
		else {
			out += "Mode: " + getMode() + "\n";
		}
		out += "Standard Deviation: " + getDeviation() + "\n";
		return out;
	}
	
	public String toString() { //outputs array as list of numbers separated by commas
		String out = String.format("%d", arr[0]);
		for(int i=1; i<size; i++) {
			out += ", " + String.format("%d", arr[i]);
		}
		return out;
	}
}