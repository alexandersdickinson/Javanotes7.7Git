/**This class reads a file and prints a list of the words in alphabetical order, with no duplicates.*/
import java.util.Collections;
import java.util.ArrayList;

public class Alphabetizer{

	public static void main(String[] args){
	
		ArrayList<String> words = new ArrayList<String>(1);
		String[] tempWords;
		
		TextIO.readFile("text.txt");
		tempWords = TextIO.getln().split(" ");
		for(int i = 0; i < tempWords.length; i++){
			tempWords[i] = tempWords[i].toLowerCase();
			words.add(tempWords[i]);	
		}
		
		unique(words);
		for(String word:words){
			System.out.print(word + " ");
		}
		System.out.println();
		
		selectionSort(words);
		for(String word:words){
			System.out.print(word + " ");
		}
	
	}
	
	static void unique(ArrayList<String> ary){
		
		int start;
		
		for(int i = 0; i < ary.size(); i++){
			
			start = i + 1;
			for(int j = start; j < ary.size(); j++){
				
				if(ary.get(i).equals(ary.get(j)))
					ary.remove(j);
				
			}
			
		}
			
	}
	
	/**
		This function takes an unsorted String array and sorts it using the selection sort method.
		Precondition: An array of String values.
		Postcondition: A sorted array of String values.
		
		@param baseArr This is the array that is to be sorted.
		@return The sorted baseArr.
	*/
	static void selectionSort(ArrayList<String> baseArr){
		
		int lastPlace;
		int maxPos;
		
		for(lastPlace = baseArr.size() - 1; lastPlace > 0; lastPlace--){//Decreases part of the array to be iterated by one each search cycle.
			
			maxPos = 0;//Index of the largest element in the subarray.
			
			for(int i = 1; i <= lastPlace; i++){
				
				int j = 0;
				
				while(baseArr.get(i).charAt(j) == baseArr.get(maxPos).charAt(j) && j < baseArr.get(i).length() - 1 && j < baseArr.get(maxPos).length() - 1){
					j++;
				}
			
				if(baseArr.get(maxPos).charAt(j) < baseArr.get(i).charAt(j))
					maxPos = i;
				
			}
			
			String temp = baseArr.get(lastPlace);
			baseArr.set(lastPlace, baseArr.get(maxPos));
			baseArr.set(maxPos, temp);
			
		}
		
	}

}