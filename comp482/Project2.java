//comp 482 project 2
//due: 10/03/18
//Andrew Tran

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;


public class Project2{

	public static int getMatrixSize() throws IOException{
		Scanner scanLine = new Scanner(new File("input2.txt"));
		return scanLine.nextLine().length()/2 + 1;
	}

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(new File("input2.txt"));

		int size = getMatrixSize();

		//init array
		int list[][] = new int[size][size];

		//read from file
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				list[i][j] = sc.nextInt();
			}
		}

		//get the size of the independent set
		int sizeOfIndSet = sc.nextInt();


		//TEST
		System.out.println("length of first line is "+ size );
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				System.out.print(list[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("independent set size : " + sizeOfIndSet);

	}//end main
}//end class
