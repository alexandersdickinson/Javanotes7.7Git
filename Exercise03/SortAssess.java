/**
	This program takes an array of random integers or strings and sorts them with selection sort and Arrays.sort() and determines which method of sorting is faster.
*/

import java.util.Arrays;

public class SortAssess{
	
	/**
		This function takes an unsorted integer array and sorts it using the selection sort method.
		Precondition: An array of int values.
		Postcondition: A sorted array of int values.
		
		@param baseArr This is the array that is to be sorted.
		@return The sorted baseArr.
	*/
	static int[] selectionSort(int[] baseArr){
		
		int lastPlace;
		int maxPos;
		
		for(lastPlace = baseArr.length - 1; lastPlace > 0; lastPlace--){//Decreases part of the array to be iterated by one each search cycle.
			
			maxPos = 0;//Index of the largest element in the subarray.
			
			for(int i = 1; i <= lastPlace; i++){
				
				if(baseArr[maxPos] < baseArr[i])
					maxPos = i;
				
			}
			
			int temp = baseArr[lastPlace];
			baseArr[lastPlace] = baseArr[maxPos];
			baseArr[maxPos] = temp;
			
		}
		
		return baseArr;
		
	}
	
	/**
		This function takes an unsorted String array and sorts it using the selection sort method.
		Precondition: An array of String values.
		Postcondition: A sorted array of String values.
		
		@param baseArr This is the array that is to be sorted.
		@return The sorted baseArr.
	*/
	static String[] selectionSort(String[] baseArr){
		
		int lastPlace;
		int maxPos;
		
		for(lastPlace = baseArr.length - 1; lastPlace > 0; lastPlace--){//Decreases part of the array to be iterated by one each search cycle.
			
			maxPos = 0;//Index of the largest element in the subarray.
			
			for(int i = 1; i <= lastPlace; i++){
				
				int j = 0;
				
				while(baseArr[i].charAt(j) == baseArr[maxPos].charAt(j) && j < baseArr[i].length() && j < baseArr[maxPos].length()){
					j++;
				}
			
				if(baseArr[maxPos].charAt(j) < baseArr[i].charAt(j))
					maxPos = i;
				
			}
			
			String temp = baseArr[lastPlace];
			baseArr[lastPlace] = baseArr[maxPos];
			baseArr[maxPos] = temp;
			
		}
		
		return baseArr;
		
	}
	
	public static void main(String[] args){
		
		int[] randInts = new int[10000];
		String[] randStrings = new String[10000];
		String randString;//A single string to be added to randStrings, with random characters and length.
		long start, end, elapsed;//start of timer, end, and difference.
		
		//assign random values to randInts
		for(int i = 0; i < randInts.length; i++){
			randInts[i] = (int)(Math.random() * 100000);
		}
		
		//assign random values to randStrings
		for(int i = 0; i < randStrings.length; i++){
			
			randString = "";//initializes the string.
			
			//Create string at i of random length and with each index a random character
			for(int j = 0; j < ((int)(Math.random() * 40) + 5); j++){//creates a random length.
				randString += String.valueOf((char)((int)(Math.random() * 26) + 65));//generates ASCII code for character, which is converted to char and added 
				//to string.
			}
			
			randStrings[i] = randString;
			
		}
		
		start = System.currentTimeMillis();
		selectionSort(randInts);
		end = System.currentTimeMillis();
		elapsed = end - start;
		System.out.println("Selection sort of random integers took " + elapsed + " milliseconds.");
		
		start = System.currentTimeMillis();
		Arrays.sort(randInts);
		end = System.currentTimeMillis();
		elapsed = end - start;
		System.out.println("Built-in sort of random integers took " + elapsed + " milliseconds.");
		
		start = System.currentTimeMillis();
		selectionSort(randStrings);
		end = System.currentTimeMillis();
		elapsed = end - start;
		System.out.println("Selection sort of random strings took " + elapsed + " milliseconds.");
		
		start = System.currentTimeMillis();
		Arrays.sort(randStrings);
		end = System.currentTimeMillis();
		elapsed = end - start;
		System.out.println("Built-in sort of random strings took " + elapsed + " milliseconds.");
		
	}
		
}