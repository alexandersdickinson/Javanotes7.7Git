/**
	This class prints the transpose of a given int[][].
*/

import java.util.Arrays;

public class TransposePrint{

	public static void main(String[] args){
		
		int[][] arr = new int[10][10];
		
		for(int i = 0; i < 10; i++){//rows
			
			for(int j = 0; j < 10; j++){//columns
				
				arr[i][j] = j;
				
			}
				
		}
	
		arr = transpose(arr);
		
		for(int[] i:arr){
			
			for(int j:i){
				
				System.out.print(j + "  ");
				
			}
			
			System.out.println();
			
		}
		
	}
	
	/**
		This function takes an int[][] and returns the transpose, where M[i][j] = M[j][i].
		@param baseArr A symmetric, two dimensional array.
	*/
	static int[][] transpose(int[][] baseArr){
		
		int[][] transArr = new int[baseArr.length][];
		
		for(int i = 0; i < baseArr.length; i++){//for each row
			
			transArr[i] = Arrays.copyOf(baseArr[i], i + 1);
			
		}
		
		return transArr;
				
	}

}