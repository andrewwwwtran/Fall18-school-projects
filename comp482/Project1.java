//comp 482 project 1
//due 09/07/18
//Andrew Tran

import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class Project1{

	private static void createSubset(int n, int m, int set[], int subset[], int index, int subIndex){


		if(subIndex == m){
			//print the subset array
			for(int i = 0; i < m; i++){
				System.out.print(subset[i] + " ");
			}
			System.out.println();
			subIndex--;
		}

		subset[subIndex] = set[index];
		createSubset(n, m, set, subset, index+1, subIndex+1);

	}//end createSubset

	public static void main(String[] args) throws IOException{

		Scanner scanner = new Scanner(new File("input1.txt"));

		//hold the first number as N and second number as M
		int n = scanner.nextInt();
		int m = scanner.nextInt();

		//create arrays of size n and m
		int setArray[] = new int[n];
		int subsetArray[] = new int[m];

		//fill set array with num from 1 to n
		for(int i = 0; i < n; i++){
			setArray[i] = i+1;
		}

		//call method with index starting at 0
		createSubset(n, m, setArray, subsetArray, 0, 0);

	}//end main
}//end class
