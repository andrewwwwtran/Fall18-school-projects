// Andrew Tran
// Project 4 Comp 482
// Due 12/20/18

import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class Project4{

	public static int nogasGame(int[][] list){
		int highscore = 0;
		ArrayList<Integer> highScoreList = new ArrayList<Integer>();

		// iterate through matrix
		for(int row = 0; row < list.length; row++){
			for(int col = 0; col < list[row].length; col++){
				// check if you can go right or down
				while(col+1 < list[row].length || row+1 < list.length){
					if(col+1 < list[row].length){
						// can still go right
						// check right side
						if(list[row][col] > list[row][col+1]){
							// add number you're at to list
							highScoreList.add(list[row][col]);
							System.out.println("hslist " + highScoreList);
							highscore++;
							col++;
						}
						// can't go right, check if you can go down
						else if(list[row][col] > list[row+1][col]){
							highScoreList.add(list[row][col]);
							System.out.println("hslist " + highScoreList);
							highscore++;
							row++;
						}
					}
					else if(row+1 < list.length){
						// can still go down
						// check below
						if(list[row][col] > list[row+1][col]){
							highScoreList.add(list[row][col]);
							System.out.println("hslist " + highScoreList);
							highscore++;
							row++;
						}
						// can't go down, check if you can go right
						else if(list[row][col] > list[row][col+1]){
							highScoreList.add(list[row][col]);
							System.out.println("hslist " + highScoreList);
							highscore++;
							col++;
						}
					}
					System.out.println("row: " + row);
					System.out.println("col: " + col);
					if(list[row][col] < list[row+1][col] && list[row][col] < list[row][col+1]){
						break;
					}
				}// end while
				// // update high score
				// if(highScoreList.size() < highscore){
				// 	highscore = highScoreList.size();
				// 	// reset high score list
				// 	highScoreList.clear();
				// }
			}// end for loop col
		}// end for loop row
		return highscore;
	}

	public static void main(String[] args) {
		try{
			// init
			int[][] list;
			int highscore = 0;
			Scanner scan = new Scanner(new File("input4.txt"));

			// read file
			int row = scan.nextInt();
			int col = scan.nextInt();
			list = new int[row][col];
			for(int i = 0; i < row; i++){
				for(int j = 0; j < col; j++){
					list[i][j] = scan.nextInt();
				}
			}

			// run the game
			System.out.println("high score: " + nogasGame(list));

		}catch(IOException e){
			System.out.println(e);
		}
	}
}
