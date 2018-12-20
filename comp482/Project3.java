//comp 482 project 3
//Andrew Tran
//due : Dec 20 2018

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.IOException;

public class Project3{

	// mom method
	public static int median(int a, int b, int c, int d, int e){
		int med;
		int temp;

		ArrayList<Integer> tList = new ArrayList<Integer>();
		tList.add(a); // 0
		tList.add(b);	// 1
		tList.add(c); // 2
		tList.add(d); // 3
		tList.add(e); // 4

		if(tList.get(0) < tList.get(1)){
			Collections.swap(tList, 0, 1);
		}
		if(tList.get(2) < tList.get(3)){
			Collections.swap(tList, 2, 3);
		}
		if(tList.get(0) < tList.get(2)){
			Collections.swap(tList, 0, 2);
			Collections.swap(tList, 1, 3);
		}
		if(tList.get(1) < tList.get(4)){
			Collections.swap(tList, 1, 4);
		}
		if(tList.get(1) > tList.get(2)){
			if(tList.get(2) > tList.get(4)){
				return tList.get(2);
			}else{
				return tList.get(4);
			}
		}else{
			if(tList.get(1) > tList.get(3)){
				return tList.get(1);
			}else{
				return tList.get(3);
			}
		}
	}

	public static int ithItem(int i, int N, ArrayList<Integer> data){
		//init
		int answer;
		int j = 0;
		int k = 0;
		int l;
		int mom;
		ArrayList<Integer> medians;
		ArrayList<Integer> smaller;
		ArrayList<Integer> larger;
		// int[] medians;
		// int[] smaller;
		// int[] larger;

		if(N <= 5){
			Collections.sort(data);
			answer = data.get(i - 1);
		}else{
			// do median of medians algorithm
			medians = new ArrayList<Integer>(N/5); // each cell is going to contain 5 numbers
			smaller = new ArrayList<Integer>(N); // about half of array is going into smaller and larger array
			larger = new ArrayList<Integer>(N);
			// iterate through the list, containing all the numbers (not sorted)
			for(l = 0; l < N/5; l++){
				medians.add(l, median(data.get(5*l), data.get(5*l+1), data.get(5*l+2), data.get(5*l+3), data.get(5*l+4)));
			}
			// System.out.println("medians: " + medians);
			mom = ithItem(N/10, N/5, medians);
			// System.out.println("mom: " + mom);
			// System.out.println("N : " + N);
			for(l = 0; l < N; l++){
				if(data.get(l) <= mom){
					j++;
					smaller.add(data.get(l));
					// System.out.println("j: "+j);
				}else{
					k++;
					larger.add(data.get(l));
					// System.out.println("k: "+k);
				}
			}
			if(i < j){
				answer = ithItem(i, j, smaller);
			}else{
				answer = ithItem(i-j, k, larger);
			}
		}
		return answer;
	}//end ithItem

	public static void main(String[] args){
		try{
			// init
			ArrayList<Integer> list = new ArrayList<Integer>();
			// read file
			Scanner scan = new Scanner(new File("input3.txt"));
			int ith = scan.nextInt();
			int nitems = scan.nextInt();
			for(int i = 0; i < nitems; i++){
				list.add(scan.nextInt());
			}

			System.out.println("real mom is : " + ithItem(ith, nitems, list));

			scan.close();
		}catch(IOException e){
			System.out.println(e);
		}
	}// end main

}//end project 3
