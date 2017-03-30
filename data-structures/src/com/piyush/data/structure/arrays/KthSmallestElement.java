package com.piyush.data.structure.arrays;

// Kth smallest and largest element 
public class KthSmallestElement {
	
	public static int findKthSmallestElement(int[] arr, int start, int end, int k) {
		
		int i = start;
		int j = end;
		int pivot = arr[end];
		
		while(true) {
			
			while(i<j && arr[i]<=pivot)
				i++;
			
			while(i<j && arr[j]>=pivot)
				j--;
			
			if(i==j)
				break;
			
			swap(arr, i, j);

		}
		
		swap(arr, i, end);
		
		if(i == k-1)
			return pivot;
		else if(i < k-1)
			return findKthSmallestElement(arr, i+1, end, k);
		else
			return findKthSmallestElement(arr, start, i-1, k);
		
	}
	
	
	private static void swap(int[] arr, int i, int j) {
	        int temp = arr[i];
	        arr[i] = arr[j];
	        arr[j] = temp;
	}
	
	
	public static void main(String[] args) {

		int[] arr = {45, 11, 32, 7, 22, 5, 17, 28};
		
		// 5, 7, 11, 17, 22, 28, 32, 45	
		int k = 3;
		
		// Kth smallest element 
		System.out.println(findKthSmallestElement(arr, 0, arr.length-1, k));
		
		// Kth largest element 
		System.out.println(findKthSmallestElement(arr, 0, arr.length-1, arr.length - k + 1));
		
	}

}
