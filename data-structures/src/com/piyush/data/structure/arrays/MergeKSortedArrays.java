package com.piyush.data.structure.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import org.w3c.dom.stylesheets.LinkStyle;

class Node{
    int listNo;
    int index;
    int num;
    public Node(int listNo, int index, int num){
        this.listNo=listNo;
        this.index=index;
        this.num=num;
    }
}

public class MergeKSortedArrays {
	public static int[] mergeKSortedArray(int[][] arr) {

		PriorityQueue<Node> queue = new PriorityQueue<Node>(new Comparator<Node>() {
			
			public int compare(Node n1, Node n2) {
				return n1.num - n2.num;
			}
		});
		
		int length = 0;
		for(int i=0; i<arr.length; i++) {
			System.out.println("init: " + arr[i][0]);
			Node node = new Node(i, 0, arr[i][0]);
			queue.offer(node);
			length += arr[i].length;
		}
		
		int[] result = new int[length];
		int j=0;
		while(!queue.isEmpty()) {
			
			Node node = queue.poll();
			result[j] = node.num;
			
			int listNo = node.listNo;
			int index = node.index;
			System.out.println("listno: " + listNo + " index: " + index);
			if(index <= arr[listNo].length - 2)
				queue.offer(new Node(listNo, index+1, arr[listNo][index+1]));
			j++;
		}
		
		return result;
	}
 
	public static void main(String[] args) {
		int[] arr1 = { 1, 3, 5, 7 };
		int[] arr2 = { 2, 4, 6, 8 };
		int[] arr3 = { 0, 9, 10, 11 };
 
		int[] result = mergeKSortedArray(new int[][] { arr1, arr2, arr3 });
		System.out.println(Arrays.toString(result));
	}
}
