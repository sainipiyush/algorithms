package com.piyush.data.structure.arrays;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	
	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permute(num, 0, result);
		return result;
	}
	 
	static void permute(int[] num, int start, ArrayList<ArrayList<Integer>> result) {
	 
		if (start >= num.length) {
			ArrayList<Integer> item = convertArrayToList(num);
			result.add(item);
		}
	 
		for (int j = start; j <= num.length - 1; j++) {
			swap(num, start, j);
			permute(num, start + 1, result);
			swap(num, start, j);
		}
	}
	 
	private static ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}
	 
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static ArrayList<ArrayList<Integer>> permuteIterative(int[] numbers) {
	    // we use a list of lists rather than a list of arrays 
	    // because lists support adding in the middle
	    // and track current length
		ArrayList<ArrayList<Integer>> permutations = new ArrayList<ArrayList<Integer>>();
	    // Add an empty list so that the middle for loop runs
	    permutations.add(new ArrayList<Integer>());

	    for ( int i = 0; i < numbers.length; i++ ) {
	        // create a temporary container to hold the new permutations 
	        // while we iterate over the old ones
	    	ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
	        for ( List<Integer> permutation : permutations ) {
	            for ( int j = 0; j < permutation.size() + 1; j++ ) {
	            	ArrayList<Integer> temp = new ArrayList<Integer>(permutation);
	                temp.add(j, numbers[i]);
	                current.add(temp);
	            }
	        }
	        permutations = new ArrayList<ArrayList<Integer>>(current);
	       
	        /*System.out.println("permutation : "+ i);
	        printPermutation(permutations);*/
	    }

	    return permutations;
	}
	
	static void printPermutation(ArrayList<ArrayList<Integer>> list) {
		
		for(ArrayList<Integer> li : list) {
			
			System.out.println(li);
		}
	}

	public static void main(String[] args) {
		int[] num = {1,2,3};
		
		ArrayList<ArrayList<Integer>> result = permuteIterative(num);
		
		for(ArrayList<Integer> list : result) {
			
			System.out.println(list);
		}
 
	}

}
