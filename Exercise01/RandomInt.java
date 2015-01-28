/**
This program creates an array with a specified number of different, random integers. It prints the array.
*/

import java.util.ArrayList;

public class RandomInt{
		
	public static void main(String[] args){
		
		int indices = 100;
		int[] randInts = arrayGen(indices);
				
		for(int i = 0; i < indices; i++){
			System.out.println(randInts[i]);
		}
		
	}
	
	/**
		This subroutine creates an int array made up of a specified number of elements, all of which are random, and different from one another.
		Precondition: A positive integer number of indices.
		Postcondition: An int array.
		
		@param indices The size of the array to be created.
		@return An array with a specified number of elements, all of which are random, and different.
	*/
	static int[] arrayGen(int indices){
		
		//create an Integer ArrayList from 1 - indices.
		ArrayList<Integer> randPool = new ArrayList<Integer>();//list of ordered integers from which random numbers are pulled. Ensures no repeats.
		int[] randArr = new int[indices];
		int randIndex;//index of randomly found element in randPool.
		
		for(int i = 0; i < indices; i++){
			randPool.add(i);
		}
		//create an empty int[] of length indices.
		//for indices of empty int[] pick a random index from the ArrayList and assign that value to the current index of int[]
		for(int i = 0; i < indices; i++){
			
			//get random element of ArrayList and assign it to randArr.
			randIndex = (int)(Math.random() * randPool.size());
			randArr[i] = randPool.get(randIndex);
			randPool.remove(randIndex);
			
		}
		
		return randArr;
		
	}
	
}