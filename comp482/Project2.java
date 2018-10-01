//comp 482 project 2
//due: 10/03/18
//Andrew Tran

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;


public class Project2{

	public static void main(String[] args) throws IOException{

		Scanner scanner = new Scanner(new File("input2.txt"));

		int sizeOfMatrix=0;

		while(!scanner.hasNext("\n")){
			// store this number
			sizeOfMatrix++;
		}

		System.out.println(sizeOfMatrix);

		//init array
		int list[][] = new int[sizeOfMatrix][sizeOfMatrix];

		//read in the matrix
		// read the row of the matrix until hit a new line,
		for(int j = 0; j <= sizeOfMatrix; j++){
			for(int k = 0; k < j; k++){
				list[j][k] = scanner.nextInt();
			}
		}

	}//end main
}//end class
