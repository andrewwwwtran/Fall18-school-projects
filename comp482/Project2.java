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

	public static int[] checkArray(int array[], int k, int l){
		for(int i : array){
			if(i == k){
				//dont add into array
			}
			else{
				//its not in the array, add it

			}
		}
	}

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(new File("input2.txt"));

		int size = getMatrixSize();

		// storeMatrix(size);

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

		// bruteforce
		// idea: search array til hit 0, save index of i, j
		// then search j, i if theres a 0
		// if so then add to another num to compare to sizeOfIndSet
		// continue search from i, j
		// going to add 2 times bc once it hits j, i its gonna check i, j then add

		int testSize=0;
		int arraySet[] = new int[];

		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(list[i][j] == 0 && list[j][i] == 0){
					//add 2 vertices
					checkArray(arraySet, i, j);
					//mark them
					list[i][j] = -1;
					list[j][i] = -1;
				}
			}
		}
		//compare to given number
		if(testSize >= sizeOfIndSet){
			System.out.println("Yes.");
		}
		if(testSize < sizeOfIndSet){
			System.out.println("No.");
		}

		//TEST
		System.out.println("length of first line is "+ size );
		System.out.println("max ind set size: " + testSize);
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				System.out.print(list[i][j] + " ");
			}
			System.out.println();
		}

		// System.out.println("independent set size : " + sizeOfIndSet);

	}//end main
}//end class
