package sudoku;

import java.util.*;

public class Grid {
	private int[][] values;

	//
	// DON'T CHANGE THIS.
	//
	// Constructs a Grid instance from a string[] as provided by TestGridSupplier.
	// See TestGridSupplier for examples of input.
	// Dots in input strings represent 0s in values[][].
	//
	public Grid(String[] rows) {
		values = new int[9][9];
		for (int j = 0; j < 9; j++) {
			String row = rows[j];
			char[] charray = row.toCharArray();
			for (int i = 0; i < 9; i++) {
				char ch = charray[i];
				if (ch != '.')
					values[j][i] = ch - '0';
			}
		}
	}

	//
	// DON'T CHANGE THIS.
	//
	public String toString() {
		String s = "";
		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				int n = values[j][i];
				if (n == 0)
					s += '.';
				else
					s += (char) ('0' + n);
			}
			s += "\n";
		}
		return s;
	}

	//
	// DON'T CHANGE THIS.
	// Copy ctor. Duplicates its source. You'll call this 9 times in next9Grids.
	//
	Grid(Grid src) {
		values = new int[9][9];
		for (int j = 0; j < 9; j++)
			for (int i = 0; i < 9; i++)
				values[j][i] = src.values[j][i];
	}

	//
	// Finds an empty member of values[][]. Returns an array list of 9 grids that
	// look like the current grid,
	// except the empty member contains 1, 2, 3 .... 9. Returns null if the current
	// grid is full. Don't change
	// this grid. Build 9 new grids.
	//
	//
	// Example: if this grid = 1........
	// .........
	// .........
	// .........
	// .........
	// .........
	// .........
	// .........
	// .........
	//
	// Then the returned array list would contain:
	//
	// 11....... 12....... 13....... 14....... and so on 19.......
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	// ......... ......... ......... ......... .........
	//
	public ArrayList<Grid> next9Grids() {
		// Returns null if the current grid is full.
		if (isFull()) {
			return null;
		}

		int xOfNextEmptyCell = 0;
		int yOfNextEmptyCell = 0;

		// Finds x,y of an empty cell.
		for (int row = 0; row < values.length; row++) {
			for (int column = 0; column < values[0].length; column++) {

				if (values[row][column] == 0) {
					xOfNextEmptyCell = row;
					yOfNextEmptyCell = column;
				}
			}
		}

		// Constructs an array list to contain 9 new grids.
		ArrayList<Grid> grids = new ArrayList<Grid>(9);

		// Creates 9 new grids as described in the comments above. Adds them to grids.
		for (int i = 1; i <= 9; i++) {
			Grid myGrid = new Grid(this);
			myGrid.values[xOfNextEmptyCell][yOfNextEmptyCell] = i;
			grids.add(myGrid);
		}

		return grids;
	}

	// Helper method that checks every row. If an illegal row is found, return
	// false.
	public boolean isLegalRow() {
		for (int row = 0; row < values.length; row++) {
			ArrayList<Integer> rowValues = new ArrayList<Integer>(9);

			for (int column = 0; column < values[0].length; column++) {
				int value = values[row][column];

				if (rowValues.contains(value) && value != 0) {
					return false;
				}

				rowValues.add(value);
			}
		}

		return true;
	}

	// Helper method that checks every column. If an illegal column is found, return
	// false.
	public boolean isLegalColumn() {
		for (int column = 0; column < values[0].length; column++) {
			ArrayList<Integer> columnValues = new ArrayList<Integer>(9);

			for (int row = 0; row < values.length; row++) {
				int value = values[row][column];

				if (columnValues.contains(value) && value != 0) {
					return false;
				}

				columnValues.add(value);
			}
		}

		return true;
	}

	// Helper method that checks every block. If an illegal block is found, return
	// false.
	public boolean isLegalBlock() {
		for (int row = 0; row < values.length; row = row + 3) {
			for (int column = 0; column < values[0].length; column = column + 3) {
				ArrayList<Integer> blockValues = new ArrayList<Integer>(9);

				for (int blockRow = row; blockRow < row + 3; blockRow++) {
					for (int blockColumn = column; blockColumn < column + 3; blockColumn++) {
						int value = values[blockRow][blockColumn];

						if (blockValues.contains(value) && value != 0) {
							return false;
						}

						blockValues.add(value);
					}
				}
			}
		}

		return true;
	}

	//
	// Returns true if this grid is legal. A grid is legal if no row, column, or
	// 3x3 block contains a repeated 1, 2, 3, 4, 5, 6, 7, 8, or 9.
	//
	public boolean isLegal() {
		return isLegalRow() && isLegalColumn() && isLegalBlock();
	}

	//
	// Returns true if every cell member of values[][] is a digit from 1-9.
	//
	public boolean isFull() {
		for (int row = 0; row < values.length; row++) {
			for (int column = 0; column < values[0].length; column++) {
				if (!(values[row][column] >= 1 && values[row][column] <= 9)) {
					return false;
				}
			}
		}

		return true;
	}

	//
	// Returns true if x is a Grid and, for every (i,j),
	// x.values[i][j] == this.values[i][j].
	//
	public boolean equals(Object x) {
		Grid otherGrid = (Grid) x;

		for (int row = 0; row < values.length; row++) {
			for (int column = 0; column < values[0].length; column++) {
				if (otherGrid.values[row][column] != this.values[row][column]) {
					return false;
				}
			}
		}

		return true;
	}

	//
	// Main method to test some of the methods from the Grid class.
	//
	public static void main(String[] args) {
		System.out.println(TestGridSupplier.getSolution2().isLegal());
		System.out.println(TestGridSupplier.getPuzzle3().next9Grids());
	}
}
