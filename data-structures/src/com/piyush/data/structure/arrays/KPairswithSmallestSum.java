package com.piyush.data.structure.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KPairswithSmallestSum {

	public static List<int[]> findKPairsWithSmallestSum(int[] arr1, int[] arr2, int k) {
		List<int[]> result = new ArrayList<int[]>();
		
		int[] idx = new int[arr1.length];
		
		while(k>0) {
			int min = Integer.MAX_VALUE;
			int t = 0;
			for(int i=0; i<arr1.length; i++) {
				if(idx[i] < arr2.length && arr1[i] + arr2[idx[i]] < min) {
					t = i;
					min = arr1[i] + arr2[idx[i]];
				}
			}
			
			int[] pair = { arr1[t], arr2[idx[t]] };
			result.add(pair);
			idx[t]++;
			k--;			
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] arr1 = { 1, 5, 8 };
		int [] arr2 = { 2, 4, 7 };
		
		List<int[]> result = findKPairsWithSmallestSum(arr1, arr2, 3);
		
		for(int[] res : result)
			System.out.println(Arrays.toString(res));
		
	}

}
