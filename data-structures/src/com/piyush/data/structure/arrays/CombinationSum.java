package com.piyush.data.structure.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 * @author Piyush
 * 
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), 
   find all unique combinations in C where the candidate numbers sums to T.

	The same repeated number may be chosen from C unlimited number of times.
	
	Note:
	All numbers (including target) will be positive integers.
	The solution set must not contain duplicate combinations.
	For example, given candidate set [2, 3, 6, 7] and target 7, 
	A solution set is: 
	
	[
	  [7],
	  [2, 2, 3]
	] 
 * 
 */

public class CombinationSum {

	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        combinations(candidates, target, new ArrayList<Integer>(), 0, result);
                        
        return result;
    }
    
    public static void combinations(int[] candidates, int target, List<Integer> list, int start, List<List<Integer>> result) {
            
        if(target == 0) {
            result.add(new ArrayList<Integer>(list));
    //        System.out.println("found new combination = " + result.size());
        } else if (target > 0) {
            for(int i=start; i<candidates.length; i++) {
                list.add(candidates[i]);
                combinations(candidates, target - candidates[i], list, i, result);
                list.remove(list.indexOf(candidates[i]));
            }
        }
    
    }
    
    public static void main(String[] args) {
		int[] num = {2,3,6,7};
		
		List<List<Integer>> result = combinationSum(num, 7);
		
		for(List<Integer> list : result) {
			
			System.out.println(list);
		}
 
	}
}
