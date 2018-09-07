//comp 482 project 1
//due 09/07/18
//Andrew Tran

import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class Project1{

	private static void createSubset(int n, int m, int set[], int subset[], int index, int subIndex){

		//prints the subset array with spaces
		if(subIndex == m){
			for(int i = 0; i < m; i++){
				System.out.print(subset[i] + " ");
			}
			//print a new line
			System.out.println();
			return;
		}

		//fixes the array index out of bounds
		//when the index gets larger than the set array
		if(index >= n){
			// index--; //didnt work, infinite loop w.o return
			//jump out of method when last subset is printed
			return;
		}

		//puts subset of the set into the array
		subset[subIndex] = set[index];
		//go to next index and repeat until subset array is full
		createSubset(n, m, set, subset, index+1, subIndex+1);

		//the subindex doesnt go to the next position
		// but the index of set array goes to the next position
		createSubset(n, m, set, subset, index+1, subIndex);

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

		//close scanner
		scanner.close();

	}//end main
}//end class
