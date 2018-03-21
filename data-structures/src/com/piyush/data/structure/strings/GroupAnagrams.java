package com.piyush.data.structure.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {

	public static List<List<String>> groupAnagrams(String[] strs) {
	    List<List<String>> result = new ArrayList<List<String>>();
	 
	    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
	    for(String str: strs) {
	        char[] arr = new char[26];
	        for(int i=0; i<str.length(); i++) {
	        	if(str.charAt(i) == ' ') {
	        		continue;
	        	}
	      
	            arr[str.charAt(i)-'a']++;
	        }
	        
	        String ns = new String(arr);
	 
	        if(map.containsKey(ns)){
	            map.get(ns).add(str);
	        } else {
	            ArrayList<String> al = new ArrayList<String>();
	            al.add(str);
	            map.put(ns, al);
	        }
	    }
	 
	    result.addAll(map.values());
	 
	    return result;
	}
	
	public static void main(String[] args) {
		
		String[] strArray = {"bad credit", "dirty room", "astronomer", "dormitory", "debit card"};
		List<List<String>> result = groupAnagrams(strArray);
		
		for(List<String> list : result) {
			if(list.size()>1)
				System.out.println(list);
		}
	}
}
