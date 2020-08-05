package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Puzzle8Model {

	public static ArrayList<Integer> solution = new ArrayList<Integer>();
	public static ArrayList<Integer> rows = new ArrayList<Integer>();
	
	public static ArrayList<Integer> row1 = new ArrayList<Integer>();
	public static ArrayList<Integer> row2 = new ArrayList<Integer>();
	public static ArrayList<Integer> row3 = new ArrayList<Integer>();
	
	public static int spaceX;
	public static int spaceY;
	public static int choiceX;
	public static int choiceY;
	
	public static Scanner s = new Scanner(System.in);
	public static String choice;
		
	
	
	
	/** Call after every move to check solution **/
	public static boolean checkSolution(ArrayList<Integer> list, ArrayList<Integer> sol) {
		return list.equals(sol);
	}
	
	/** Check if the shuffled allow for a solvable solution **/
	public static boolean isSolvable(ArrayList<Integer> list) {
		// Logic used: https://www.cs.bham.ac.uk/~mdr/teaching/modules04/java2/TilesSolvability.html
		boolean canSolve = false;
		int inversions = 0;
		
		// Count inversions
		for(int i = 0; i < list.size(); i++) {
			// Don't treat space as 0
			if(list.get(i) == 0)
				continue;
			for(int j = i; j < list.size(); j++) {
				// Don't treat space as 0
				if(list.get(j) == 0)
					continue;
				//System.out.println(list.get(i)+" > "+list.get(j));
				//System.out.println(list.get(i) > list.get(j));
				if(list.get(i) > list.get(j))
					inversions++;
				//System.out.println("Invs: "+inversions);
			} // end of for j
		} // end of for i
		//System.out.println(inversions);
		if(inversions % 2 == 0) // must be an even number of inversions
			canSolve = true;
		
		return canSolve;
	}
	
	// FEEL FREE TO CHANGE THIS MESSAGE
	public static String successMessage() {
		return "The wall has opened, giving you access to a new passage way...";
	}
	
	/** Create solution **/
	public static void makeSolution(ArrayList<Integer> list) {
		Integer[] array = {0,1,2,3,4,5,6,7,8};
		for(int i=0; i < array.length; i++)
			list.add(array[i]);
	}
	
	
	/** Shuffle solution **/
	public static ArrayList<Integer> shuffleTiles(ArrayList<Integer> list) {
		Collections.shuffle(list);	
		return list;
	}
	
	
	/** Display board **/
	public static void buildBoard(ArrayList<Integer> list) {
		int len = (int) Math.sqrt(list.size()); // only works for square tables
		row1.clear();
		row2.clear();
		row3.clear();
		
		for(int i=0; i < len; i++) {
			row1.add(list.get(i));
			row2.add(list.get(i+len));
			row3.add(list.get(i+2*len));
		}
	}
	
		
	/** Check Row and Column for space or "0" **/
	public static boolean isValidMove(ArrayList<Integer> list, int sX, int sY, int cX, int cY) {
		boolean isValid = false;
		
		// Assign column and row values to the space
		// Range is from 1:3
		sX = ((list.indexOf(0)%3)+1); // gets column of 0
		sY = ((list.indexOf(0)+3)/3); // gets row of 0
		
		// Check if space
		if (sX == cX && sY == cY)
			isValid = false; // can't move space
		// Check if the tile and space are in the same row or column
		else if (sX != cX && sY != cY)
			isValid = false;
		// Check if the tiles are neighbors
		else if (Math.abs(cX - sX) > 1 || Math.abs(cY - sY) > 1)
			isValid = false;
		// The move is valid if it passes all tests
		else
			isValid = true;
		
		return isValid;
	} // end of isValidMove()
	
	/** Get tile of choice **/
	public static Integer getTile() {
		Integer tile = null;
		
		if(choiceY == 1)
			tile = row1.get(choiceX-1);
		else if(choiceY == 2)
			tile = row2.get(choiceX-1);
		else if(choiceY == 3)
			tile = row3.get(choiceX-1);
		
		return tile;
	} // end of getTile()
	
	
	/** Get move or input from user in the form of XY **/
	public static void getTileChoice() {
		String pattern = "^[1-3]{2}$";
		Pattern re = Pattern.compile(pattern);
				
		// Check choice for XY format
		while(s.hasNextLine()) {
			choice = s.nextLine();
			Matcher m = re.matcher(choice);
			if(m.find())
				break;
			
			System.out.println("\nThe entry given is not in XY format.\n");
		}
		
		// Save column and row numbers ( deduct 48 from ASCII index to get integer values )
		// Range is from 1:3
		choiceX = choice.charAt(0)-48;
		choiceY = choice.charAt(1)-48;
		
	} // end of getTileChoice()
	
	
	/** Shifts tiles when move is made **/
	public static ArrayList<Integer> shiftTile (ArrayList<Integer> list, int sX, int sY, int cX, int cY) {
		Integer temp;
		ArrayList<Integer> tempList = list;
		System.out.println("Shifting Maybe");
		System.out.println(sX);
		System.out.println(sY);
		System.out.println(cX);
		System.out.println(cY);
		System.out.println(list);
		// Shift column
		if(sX == cX) {
			// Swap if neighboring tiles
			System.out.println("Column match");
			temp = tempList.indexOf(0);				
			tempList.set(tempList.indexOf(getTile()), 0);
			tempList.set(temp, getTile());
		}
		// Shift row
		else if (sY == cY) {
			// Swap if neighboring tiles
			System.out.println("Column match");
			temp = tempList.indexOf(0);
			tempList.set(tempList.indexOf(getTile()), 0);
			tempList.set(temp, getTile());
		}
		return tempList;
	} // end of shiftTile()
	
	/*
	// MAIN FUNCTION
	public static void main(String args[]) {
		
		makeSolution(solution); // create a solution list [0, 1, 2, 3, 4, 5, 6, 7, 8]
		
		makeSolution(rows);
		shuffleTiles(rows); // shuffle solution
		
		//System.out.println(rows + "\n");
		
		System.out.println("Enter tile coordinates in the form of XY, where X is the column number and Y is the row number.");
		System.out.println("For example, '13' represents column 1 and row 3.\n");
		
		while (!checkSolution()) {
			
			buildBoard(rows); // display 3x3 board
			System.out.println("   -– X –-");
			System.out.println("| "+row1);
			System.out.println("Y "+row2);
			System.out.println("| "+row3);
			System.out.println("");
			
			System.out.print("Enter XY: ");
			getTileChoice(); // get move from terminal
			System.out.println("");			
			
			if(!isValidMove(rows)) {
				System.out.println("Can not shift [" + getTile() + "]");
				continue; // restart while loop
			}
			
			//System.out.println(getTile());
			shiftTile();
			
			System.out.println("Shifting tile [" + getTile() + "] over...");
			
			if(checkSolution()) {
				s.close(); // close input stream
				System.out.println("\nCongradulations, you solved the puzzle!");
				break;
			}
		
			
		} // end of while()
		
		
	}	// end of main()
	*/
} // end of class

