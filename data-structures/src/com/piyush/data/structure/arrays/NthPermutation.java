package com.piyush.data.structure.arrays;

import java.util.LinkedHashSet;

public class NthPermutation {


static String result = null;
static int nth = 0;

	public static int nthPerm(int n) {
	    nth = n;
	    LinkedHashSet<Integer> set = new LinkedHashSet<>();
	
	    for(int i = 0; i < 10; i++) {
	        set.add(i);
	    }
	    nthPerm("", set);
	    return Integer.parseInt(result);
	}
	
	public static void nthPerm(String cur, LinkedHashSet<Integer> nums) {
	    if(result != null) return;
	    if(nums.size() == 0) {
	        nth--;
	    }
	    if(nth == 0) {
	        result = cur;
	        return;
	    }
	
	    for(int i = 0; i < 10; i++) {
	        if(nums.contains(i)) {
	            nums.remove(i);
	            nthPerm(cur+i, nums);
	            nums.add(i);
	        }
	    }
	}


}
