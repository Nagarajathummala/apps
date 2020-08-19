package com.app;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {
	
	public static void main(String args[]) {
		
	final char[][] input = {
			 { 8, 6 ,3 , 9, 2, '.' , 7, 4, 1 },
			 { 4, 1, 2 , 7, 8, 6 , 3, 5, 9 },
			 { 7 ,5 ,9 , 4, 1, 3 , 2, 8, 6 } ,
			 {'.',7 ,1 , 2, 6, 4 , 8, 3, 5 },
			 { 3, 4,'.' , 8, 5, 7 , 9, 1, 2 },
			 { 2 ,8 ,5 , 3, '.', 1 , 4, 6, 7 } ,
			 { 1 ,9 ,8 , 6, 3, 2 , 5, 7, 4 },
			 { 5 ,2 ,4 , 1, 7, 8 , 6, 9, 3 },
			 { 6 ,3 ,7 , 5, 4, 9 , 1, 2, '.'}
			};
	
	Sudoku solution = new Sudoku();
	
	if(solution.isValidSudoku(input)) {
		System.out.println("Valid Sudoku");
	}else {
		System.out.println("Not Valid Sudoku");
	}
}

public boolean isValidSudoku(char[][] board) {
	if (board == null || board.length == 0)
		return true;
	int rowlen = board.length, collen = board[0].length;
	for (int i = 0; i < rowlen; i++) {
		Set<Character> rowSet = new HashSet<>();
		Set<Character> colSet = new HashSet<>();
		Set<Character> gridSet = new HashSet<>();
		for (int j = 0; j < collen; j++) {
			if (board[i][j] != '.' && !rowSet.add(board[i][j]))
				return false;
			if (board[j][i] != '.' && !colSet.add(board[j][i]))
				return false;
			int RowIndex = 3 * (i / 3);
			int ColIndex = 3 * (i % 3);
			if (board[RowIndex + j / 3][ColIndex + j % 3] != '.'
					&& !gridSet.add(board[RowIndex + j / 3][ColIndex + j % 3]))
				return false;
		}
	}

	return true;

}

/*
{

 { 8, 6 ,3 , 9, 2, 5 , 7, 4, 1 },
 { 4, 1, 2 , 7, 8, 6 , 3, 5, 9 },
 { 7, 5, 9 , 4, 1, 3 , 2, 8, 6 }, 
 { 9, 7 ,1 , 2, 6, 4 , 8, 3, 5 },
 { 3 ,4 ,6 , 8, 5, 7 , 9, 1, 2 },
 { 2 ,8 ,5 , 3, 9, 1 , 4, 6, 7 }, 
 { 1 ,9 ,8 , 6, 3, 2 , 5, 7, 4 },
 { 5 ,2 ,4 , 1, 7, 8 , 6, 9, 3 },
 { 6 ,3 ,7 , 5, 4, 9 , 1, 2, 8 }
 
 }

*/
}
