package Board;

import java.util.Random;

public class BoardFunctions {
	
	public static int[][] fillArray(int rows, int mineCount) {
		int[][] mines=new int[rows][rows];
		int[] mine_pos = fisherYates(rows*rows, mineCount);
		for(int i=0; i<mineCount; i++){
			mines[mine_pos[i]/rows][mine_pos[i]%rows]==-1
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

	public static int[] fisherYates(int max, int number){
		int[] rands = new int [max];
		int[] out = new int [number];
		for(int i=0; i<max; i++){
			rands[i] = i;
		}
		int temp_max=max-1;
		for(int i=0; i<number; i++){
			Random randomNum = new Random();
			int num = randomNum.nextInt(temp_max);
      		{
      			int swap_temp = rands[temp_max];
				rands[temp_max] = rands[num];
      			rands[num]=swap_temp;
      		}
			out[i]=rands[temp_max];
			temp_max-=1;
		}
		return out;
	}
	
	public static int[][] fillWithNumbers(int[][] arr, int n) {
		// TODO Auto-generated method stub
		//int[][] output = new int[n][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				if(arr[i][j]!=-1) {
					countNeighbouringMines(arr,i,j);
				}
			}
		}
		return arr;
	}
	
	private static void countNeighbouringMines(int[][] arr,int row,int col) {
		// TODO Auto-generated method stub
		//int ans=0;
		for(int i=-1;i<2;i++) {
			for(int j=-1;j<2;j++) {
				if((row+i>=0 && row+i<=7) && (col+i>=0 && col+i<=7)) {
					if(arr[row+i][col+i]==-1) {
						++arr[row][col];
					}
				}
			}
		}
		
		//return ans;
	}

	public static void main(String[] args) {
		int[][] arr = fillArray(8,10);
		int[][] out = fillWithNumbers(arr,8);
		for(int i=0;i<8;i++) {
			for(int j=0;j<8;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}

	
}
