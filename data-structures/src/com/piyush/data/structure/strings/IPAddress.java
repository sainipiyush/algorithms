package com.piyush.data.structure.strings;

public class IPAddress {

	public static void main(String[] args) {
		
		System.out.println(parseNumericAddress("192.168.1.2"));
	}
	
	public final static long parseNumericAddress(String ipaddr) {
		  
	    //  Check if the string is valid
	    
	    if ( ipaddr == null || ipaddr.length() < 7 || ipaddr.length() > 15)
	      return 0;
	      
	    //  Check the address string, should be n.n.n.n format
	    
	    long result = 0;

	    String[] ipAddressInArray = ipaddr.split("\\.");

	    for (int i = 3; i >= 0; i--) {

	    	long ip = Long.parseLong(ipAddressInArray[3 - i]);

	    	//left shifting 24,16,8,0 and bitwise OR

	    	//1. 192 << 24
	    	//1. 168 << 16
	    	//1. 1   << 8
	    	//1. 2   << 0
	    	result |= ip << (i * 8);

	    }

	    
	    //  Return the integer address
	    
	    return result;
	  }

}
