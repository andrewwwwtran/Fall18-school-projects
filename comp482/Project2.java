//comp 482 project 2
//due: 10/03/18
//Andrew Tran

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;


public class Project2{

	public static int getMatrixSize() throws IOException{
		Scanner scanLine = new Scanner(new File("input2.txt"));
		int size = scanLine.nextLine().length()/2 + 1;
		scanLine.close();
		return size;
	}

	public static int getIndSetSize(int size, int[][] list){

		// bruteforce
		// idea: search array til hit 0, save index of i, j
		// then search j, i if theres a 0
		// if so then add to another num to compare to sizeOfIndSet
		// continue search from i, j
		ArrayList<Integer> testList = new ArrayList<Integer>();

		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				if(list[i][j] == 0 && list[j][i] == 0){
					if(!testList.contains(i)){
						testList.add(i);
						list[i][j] = -1;
					}
					if(!testList.contains(j)){
						testList.add(j);
						list[j][i] = -1;
					}
				}
			}
		}
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				System.out.print(list[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println(testList.size());
		return testList.size();
	}

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(new File("input2.txt"));
		//get size of matrix
		int size = getMatrixSize();

		//init array
		int list[][] = new int[size][size];

		//read from file and store into array
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				list[i][j] = sc.nextInt();
			}
		}

		// get the size to compare
		int sizeToCompare = sc.nextInt();
		// get size of independent set
		int sizeIndSet = getIndSetSize(size, list);

		// compare to given number
		if(sizeIndSet >= sizeToCompare){
			System.out.println("Yes.");
		}
		else{
			System.out.println("No.");
		}

		// close scanner
		sc.close();

		//TEST
		// System.out.println("length of first line is "+ size );
		//matrix after marked
		// System.out.println("max ind set size: " + testList.size());
		// for(int i = 0; i < size; i++){
			// for(int j = 0; j < size; j++){
				// System.out.print(list[i][j] + " ");
			// }
			// System.out.println();
		// }
		// System.out.println("independent set size : " + sizeOfIndSet);

	}//end main
}//end class
