package com.piyush.data.structure.arrays;

public class MaxProductSubarray {

	public static int maxProductSubarray(int[] a) {
		
		int max_ending_here = 1;
		int min_ending_here = 1;
		int max_so_far = 1;
		
		for(int i=0; i<a.length; i++) {
			if(a[i] > 0) {
				max_ending_here = max_ending_here * a[i];
				min_ending_here = Math.min(1, min_ending_here * a[i]);
			} else if(a[i] == 0) {
				max_ending_here = 1;
				min_ending_here = 1;
			} else {
				int temp = max_ending_here;
				max_ending_here = Math.max(1, min_ending_here * a[i]);
				min_ending_here = temp * a[i];
			}
			
			if(max_ending_here > max_so_far)
				max_so_far = max_ending_here;
		}
		
		return max_so_far;
	}
	
	public static void main(String[] args) {
		System.out.println(maxProductSubarray(new int[]{6, -3, -10, 0, 2}));
		System.out.println(maxProductSubarray(new int[]{-1, -3, -10, 0, 60}));
		System.out.println(maxProductSubarray(new int[]{-2, -3, 0, -2, -40}));
		System.out.println(maxProductSubarray(new int[]{2, 3, -2, 4}));
	}

}
