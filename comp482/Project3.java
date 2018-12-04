//comp 482 project 3
//Andrew Tran
//due : Dec 17 2018

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.IOException;

public class Project3{

	public static void main(String[] args){
		//init
		ArrayList<Integer> list = new ArrayList<Integer>();
		int answer = 0;
		int j = 0;
		int k = 0;
		int mom;

		try{
			//read File
			Scanner scan = new Scanner(new File("input3.txt"));

			//read the first two numbers and store them
			int ithItem = scan.nextInt();
			int nitems = scan.nextInt();

			//write to an array
			while(scan.hasNextInt()){
				list.add(scan.nextInt());
			}
			if(nitems <= 30){
				Collections.sort(list);
				answer = list.get(ithItem - 1);
			}else{
				//do median of median algorithm
				
			}



			System.out.println(list);
			System.out.println(answer);

			//close scanner
			scan.close();
		}catch(Exception exception){//if file not found
			System.out.println(exception);
		}
	}//end main

}//end project 3
