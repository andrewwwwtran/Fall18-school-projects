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
		ArrayList<Integer> highScoreList = new ArrayList<Integer>();
		int highScore = 0;

		// iterate through matrix
		for(int row = 0; row < list.length; row++){
			for(int col = 0; col < list[row].length; col++){
				System.out.println("OUTSIDE WHILE row num: " + row);
				System.out.println("OUTSIDE WHILE col num: " + col);
				// go down or right if number is less than where you are
				while(list[row][col] > list[row+1][col] || list[row][col] > list[row][col+1]){
					if(list[row][col+1] > list[row+1][col]){
						// go right
						System.out.println("RIGHT row num: " + row);
						System.out.println("RIGHT col num: " + col);
						highScoreList.add(list[row][col]);
						System.out.println("list so far: " + highScoreList);
						col++;
						System.out.println("RIGHT col++ num: " + col);
					}else{
						// go down
						System.out.println("DOWN row num: " + row);
						System.out.println("DOWN col num: " + col);
						highScoreList.add(list[row][col]);
						System.out.println("list so far: " + highScoreList);
						row++;
					}
					// prevent out of bounds error
					if(row > list.length){
						row--;
					}
					if(col > list[row].length){
						col--;
					}
				}// end while

				System.out.println("outside while row num: " + row);
				System.out.println("outside while col num: " + col);

				System.out.println("high score list : " + highScoreList);

				// update high score
				if(highScore < highScoreList.size()){
					highScore = highScoreList.size();
				}
				// reset high score list
				highScoreList.clear();
			}
		}
		return highScore;
	}

	public static void main(String[] args) {
		try{
			// init
			int[][] list;
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
