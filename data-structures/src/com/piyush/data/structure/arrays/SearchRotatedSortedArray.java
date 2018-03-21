package com.piyush.data.structure.arrays;

public class SearchRotatedSortedArray {
	
	public static int searchRotatedNoDup(int[] arr, int target) {
		
		if(arr == null || arr.length == 0)
			return -1;
		
		int low = 0;
		int high = arr.length - 1;
		
		while(low <= high) {
			int mid = low + (high - low) /2;
			if(target == arr[mid])
				return mid;
			if(arr[low] <= arr[mid]) {
				if(arr[mid] > target && arr[low] <= target)
					high = mid - 1;
				else 
					low = mid + 1;
			} else{
				if(arr[mid] < target && arr[high] >= target)
					low = mid + 1;
				else
					high = mid - 1;
			}
		}
		
		return -1;
	}
	
	public static int searchRotatedDup(int[] arr, int target) {
		
		if(arr == null || arr.length == 0)
			return -1;
		
		int low = 0;
		int high = arr.length - 1;
		
		while(low <= high) {
			int mid = low + (high - low) /2;
			if(target == arr[mid])
				return mid;
			if(arr[low] < arr[mid]) {
				if(arr[mid] > target && arr[low] <= target)
					high = mid - 1;
				else 
					low = mid + 1;
			} else if(arr[low] > arr[mid]){
				if(arr[mid] < target && arr[high] >= target)
					low = mid + 1;
				else
					high = mid - 1;
			} else {
				low++;
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {

		int[] arr1 = {5, 6, 7, 1, 2, 3};
		int[] arr2 = {4, 5, 6, 7, 1, 2, 3};
		int[] arr3 = {2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2};
		System.out.println(searchRotatedNoDup(arr1, 3));
		System.out.println(searchRotatedNoDup(arr2, 7));
		System.out.println(searchRotatedDup(arr3, 0));
	}

}
