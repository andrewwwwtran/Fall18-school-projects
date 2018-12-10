//comp 482 project 3
//Andrew Tran
//due : Dec 17 2018

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.IOException;

public class Project3{

	public int median(int a, int b, int c, int d, int e){
		int med;
		int[] testMedian = [a,b,c,d,e];
		testMedian.sort();
		med = testMedian[2];
		return med;
	}

	public int ithItem(int i, int N, ArrayList<Integer> data){
		//init
		int answer;
		int j = 0;
		int k = 0;
		int l;
		int mom;
		int[] medians;
		int[] smaller;
		int[] larger;

		if(nitems <= 30){
			Collections.sort(data);
			answer = data.get(i - 1);
		}else{
			//do median of median algorithm
			medians = new int[N/5]; // each cell is going to contain 5 numbers
			smaller = new int[N/2]; // half of array is going into smaller and larger array
			larger = new int[N/2];
			// iterate through the list, containing all the numbers (not sorted)
			for(l = 0; l < N/5; l++){
				medians[l] = median(data.get(5*l), data.get(5*l+1), data.get(5*l+2), data.get(5*l+3), data.get(5*l+4));
			}
			mom = ithItem(N/10, N/5, medians);
			for(l = 0; l < N; j++){
				if(data[l] <= mom){
					smaller[j++] = data[l];
				}else{
					larger[k++] = data[l];
				}
			}
			if(i < j){
				answer = ithItem(i, j, smaller)
			}else{
				answer = ithItem(i-j, k, larger)
			}
			return answer;
		}

	}//end ithItem

	public static void main(String[] args){
		// init
		ArrayList<Integer> list = new ArrayList<Integer>();
		// read file
		Scanner scan = new Scanner(new File("input3.txt"));
		int ith = scan.nextInt();
		int nitems = scan.nextInt();
		while(scan.hasNextInt()){
			list.add(scan.nextInt());
		}

		ithItem(ith, nitems, list);

		scan.close();
	}// end main

}//end project 3
