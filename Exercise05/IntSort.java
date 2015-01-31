/**
This class reads integers from the user and adds them to an array, which it sorts and then prints, under the assumption that the user will not enter more than
100 integers.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class IntSort{
	
	public static void main(String[] args){
		
		ArrayList<Integer> intArr = new ArrayList<Integer>(1);
		Scanner stdin = new Scanner(System.in);
		int num;
		
		System.out.println("This program lets you build an array of integers, which is then sorted. It can have up to 100 elements.");
		
		for(int i = 0; i < 100; i ++){
			
			System.out.println("Please type in an integer. Enter 0 to stop.");
			num = stdin.nextInt();
			if(num == 0)
				break;
			else
				intArr.add(num);
			
		}
		
		intArr = insertionSort(intArr);
		
		for(int number:intArr){
			System.out.println(number);
		}
		
	}
	
	/**
		This function returns a sorted Integer ArrayList, using the insertion sort algorithm.
		Precondition: An Integer ArrayList, that is not null.
		Postcondition: An Integer Arraylist, which is sorted.
		
		@param unsorted An unsorted Integer Arraylist.
		@return A sorted Integer Arraylist.
	*/
	private static ArrayList<Integer> insertionSort(ArrayList<Integer> toSort){
				
		for(int itemSorted = 1; itemSorted < toSort.size(); itemSorted++){
			
			int temp = toSort.get(itemSorted);
			int loc = itemSorted - 1;
			
			while(loc >= 0 && toSort.get(loc) > temp){
				
				toSort.set(loc + 1, toSort.get(loc));
				loc -= 1;
				
			}
			
			toSort.set(loc + 1, temp);
	
		}
		
		return toSort;
		
	}
	
}