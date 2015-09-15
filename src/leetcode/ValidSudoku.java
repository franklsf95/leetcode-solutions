/**
 * @created Sep 15, 2015
 * @author franklsf95
 * 
 * @problem valid-sudoku
 * @difficulty easy
 */

package leetcode;

import java.util.*;

public class ValidSudoku {
	
	static boolean isValidSudoku(char[][] board) {
		final int N = 9;
        // Check rows
		for (int i = 0; i < N; i++) {
			boolean ok = checkRow(board[i]);
			if (!ok) {
				return false;
			}
		}
		// Check columns
		for (int i = 0; i < N; i++) {
			boolean ok = checkCol(board, i);
			if (!ok) {
				return false;
			}
		}
		// Check 3x3 cells
		if (!check3x3(board, 0, 0)) { return false; }
		if (!check3x3(board, 0, 3)) { return false; }
		if (!check3x3(board, 0, 6)) { return false; }
		if (!check3x3(board, 3, 0)) { return false; }
		if (!check3x3(board, 3, 3)) { return false; }
		if (!check3x3(board, 3, 6)) { return false; }
		if (!check3x3(board, 6, 0)) { return false; }
		if (!check3x3(board, 6, 3)) { return false; }
		if (!check3x3(board, 6, 6)) { return false; }
		
		return true;
    }
	
	static boolean check3x3(char[][] board, int dr, int dc) {
		boolean[] a = new boolean[10];
		for (int r = dr; r < dr + 3; r++) {
			for (int co = dc; co < dc + 3; co++) {
				char c = board[r][co];
				if (c == '.') {
					continue;
				}
				int n = c - '0';
				if (n < 0 || n > 9) {
					return false;
				}
				if (a[n]) {
					return false;
				}
				a[n] = true;
			}
		}
		return true;
	}
	
	static boolean checkCol(char[][] board, int col) {
		boolean[] a = new boolean[10];
		for (int r = 0; r < 9; r++) {
			char c = board[r][col];
			if (c == '.') {
				continue;
			}
			int n = c - '0';
			if (n < 0 || n > 9) {
				return false;
			}
			if (a[n]) {
				return false;
			}
			a[n] = true;
		}
		return true;
	}
	
	static boolean checkRow(char[] row) {
		boolean[] a = new boolean[10];
		for (char c: row) {
			if (c == '.') {
				continue;
			}
			int n = c - '0';
			if (n < 0 || n > 9) {
				return false;
			}
			if (a[n]) {
				return false;
			}
			a[n] = true;
		}
		return true;
	}
	
	public static void main(String[] args) {
		char[][] board = {
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, 
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'}, 
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'}, 
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'}, 
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'}, 
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'}, 
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'}, 
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'}, 
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
		System.out.println(isValidSudoku(board));
	}
}
