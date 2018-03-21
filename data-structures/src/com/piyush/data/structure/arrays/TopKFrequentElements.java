package com.piyush.data.structure.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


class Pair{
    int num;
    int count;
    public Pair(int num, int count){
        this.num=num;
        this.count=count;
    }
}

public class TopKFrequentElements {

	public List<Integer> topKFrequentUsingHeap(int[] nums, int k) {
        //count the frequency for each element
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int num: nums) {
            if(map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num, 1);
            }
        }
 
        // create a min heap
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.count - b.count;
            }
        });
 
        //maintain a heap of size k. 
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            Pair p = new Pair(entry.getKey(), entry.getValue());
            queue.offer(p);
            
            Iterator<Pair> it = queue.iterator();
            System.out.print("After insert : ");
            while(it.hasNext()) {
            	System.out.print(it.next().num + " ");
            }
            System.out.println();
            		
            if(queue.size() > k){
                queue.poll();
                
                Iterator<Pair> it1 = queue.iterator();
                System.out.print("After delete : ");
                while(it1.hasNext()) {
                	System.out.print(it1.next().num + " ");
                }
                System.out.println();
            }
        }
 
        //get all elements from the heap
        List<Integer> result = new ArrayList<Integer>();
        while(queue.size()>0){
            result.add(queue.poll().num);
        }
        
        //reverse the order
        Collections.reverse(result);
 
        return result;
    }
	
	public List<Integer> topKFrequentUsingBucketSort(int[] nums, int k) {
	    //count the frequency for each element
	    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	    for(int num: nums){
	        if(map.containsKey(num)){
	            map.put(num, map.get(num)+1);
	        }else{
	            map.put(num, 1);
	        }
	    }
	 
	    //get the max frequency
	    int max = 0;
	    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
	        max = Math.max(max, entry.getValue());
	    }
	 
	    //initialize an array of ArrayList. index is frequency, value is list of numbers
	    ArrayList<Integer>[] arr = (ArrayList<Integer>[]) new ArrayList[max+1];
	    for(int i=1; i<=max; i++){
	        arr[i]=new ArrayList<Integer>();
	    }
	 
	    for(Map.Entry<Integer, Integer> entry: map.entrySet()){
	        int count = entry.getValue();
	        int number = entry.getKey();
	        arr[count].add(number);
	    }
	 
	    List<Integer> result = new ArrayList<Integer>();
	 
	    //add most frequent numbers to result
	    for(int j=max; j>=1; j--){
	        if(arr[j].size()>0){
	            for(int a: arr[j]){
	                result.add(a);
	            }
	        }
	 
	        if(result.size()>=k)
	            break;
	    }
	 
	    return result;
	}
	
	public static void main(String[] args) {
		
		TopKFrequentElements top = new TopKFrequentElements();
		
		int[] nums = {1,2,3,4,5,4,2,3,2,4,1,1};
		int k = 2;
		List<Integer> result1 = top.topKFrequentUsingHeap(nums, k);
		System.out.println("Result1 : " + result1);
		
		List<Integer> result2 = top.topKFrequentUsingBucketSort(nums, k);
		System.out.println("Result2 : " + result2);
		
	}
	
}

