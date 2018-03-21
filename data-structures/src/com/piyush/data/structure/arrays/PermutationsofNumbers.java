package com.piyush.data.structure.arrays;

import java.util.Arrays;

public class PermutationsofNumbers {
	
	static boolean nextPerm(int [] nums) 
	  {   int i =  nums.length - 2;
		  while(i >= 0) {
				if(nums[i] < nums[i + 1])
					break;
				i--;
		  }
		  if (i ==  -1) {
			  return false;
		  }
		  int j =  nums.length - 1;
		  while(j > i) {
				if(nums[j]>nums[i])
					break;
				j--;
		  }
		  if (j != i) {
			  swap(i,j,nums);
		  }
		  int k = i + 1;
		  int l = nums.length - 1;
		  while(k < l) {
			  swap(k,l,nums);
			  k++;
			  l--;
		  }
		  return true;
			 
	  }
	static void swap(int i, int j, int[] arr) {
			int temp = arr[j];
			arr[j]=arr[i];
			arr[i]=temp;
		}
	static void generatePermutation(int[] nums) {
		String str = "";
		 while (nextPerm(nums)) {
			 str = "";
			 for (int i : nums)
				 str = str+i;
			 System.out.println(str);
		 }
	  }

	public static void main(String[] args) {
		int[] arr = {0,1,3,2};
		
		Arrays.sort(arr);
		generatePermutation(arr);
		
		int n = 3;
        int[] a = new int[n];

        // insert integers 0..n-1
        for (int i = 0; i < n; i++)
            a[i] = i;

        // shuffle
        /*for (int i = 0; i < n; i++) {
            int r = (int) (Math.random() * (i+1));     // int between 0 and i
            int swap = a[r];
            a[r] = a[i];
            a[i] = swap;
            
            for (int j = 0; j < n; j++)
                System.out.print(a[j] + " ");
            System.out.println("");
        }*/

        // print permutation
        /*for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println("");*/

        // print checkerboard visualization
        /*for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (a[j] == i) System.out.print("* ");
                else           System.out.print(". ");
            }
            System.out.println("");
        }*/
    }

}
