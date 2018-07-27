package Board;

import java.util.Random;

public class BoardFunctions {
	
	public static int[][] fillArray(int rows, int minesNumber) {
		int[][] mines=new int[rows][rows];
		
		for(int i=0;i<minesNumber;i++) {
			int randomNumber=generateRandomFunction(rows*rows-1);
			System.out.print(randomNumber+" ");
			if(mines[randomNumber/rows][randomNumber%rows]==-1) {
				--i;
				System.out.println("same");
				continue;
			}
			System.out.println("ok");
			mines[randomNumber/rows][randomNumber%rows]=-1;
		}
		return mines;
	}
	
	public static int generateRandomFunction(int max) {
		// TODO Auto-generated method stub
		// create instance of Random class
		Random randomNum = new Random();
		int num = randomNum.nextInt(max);
		return num;
	}
	
	public static void fillWithNumbers(int[][] arr, int n) {
		// TODO Auto-generated method stub
		//int[][] output = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]!=-1) {
					countNeighbouringMines(arr,i,j);
				}
			}
		}
		//return arr;
	}
	
	private static void countNeighbouringMines(int[][] arr,int row,int col) {
		// TODO Auto-generated method stub
		//int ans=0;
		for(int i=-1;i<2;i++) {
			for(int j=-1;j<2;j++) {
				if((row+i>=0 && row+i<=7) && (col+j>=0 && col+j<=7)) {
					if(arr[row+i][col+j]==-1) {
						++arr[row][col];
					}
				}
			}
		}
		
		//return ans;
	}

	public static void main(String[] args) {
		
		int[][] arr = fillArray(8,10);
		fillWithNumbers(arr,8);
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				if(arr[i][j]==-1)
					System.out.print(". ");
				else
					System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		new BoardUI();
	}
}
