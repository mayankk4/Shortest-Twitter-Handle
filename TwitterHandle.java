package com.twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

// http://api.twitter.com/1/users/show.json?screen_name=".$usn;

public class TwitterHandle {
	
	public static void swap(char[] input, int i, int j){
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;		
	}
	
	public static void checkValidHandles(char[] input, int length) throws IOException{
		recStringPermut(input, 0, "", length);
	}
	
	public static void recStringPermut(char[] input, int startIndex, String s, int length) throws IOException{
		
		if(startIndex < length){
			for(int i=startIndex; i< input.length;i++){
				swap(input, i, startIndex);
				recStringPermut(input, startIndex + 1, s + input[startIndex], length);
				swap(input, i, startIndex);
			}			
		}else{
			try{
				URL pythonAPI = new URL("http://www.twitter.com/"+s);
				
		        URLConnection yc = null;
		        yc = pythonAPI.openConnection();
		        	
		        BufferedReader in = new BufferedReader(
		                                new InputStreamReader(
		                                yc.getInputStream()));
				//		        String inputLine;
				//		        
				//		        while ((inputLine = in.readLine()) != null) 
				//		            System.out.println(inputLine);
				//		        in.close();
			}catch (Exception e) {
				System.out.println(s + " is available !!");
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		StringBuffer validChars = new StringBuffer();
		
		for(int i=48; i<=57;i++)
			validChars.append((char)i);
		for(int i=97; i<=122;i++)
			validChars.append((char)i);
		validChars.append('_');
		
		char[] input = validChars.toString().toCharArray();
		
		for(int i=1; i<=5; i++){
			System.out.println("Checking for length " + i);
			checkValidHandles(input, i);
			System.out.println("Completed checking for length " + i);
		}	
	}
}
