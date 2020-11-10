package swpackage;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class KOI1999_J1 {
	
	static int[][] input;
	static int[][] visit;
	static int[][] matrix;
	static int[][] kmatrix;
	static int[] ij;
	
	static int N;
	static int cnt;
	static int a;
	static int inf = 999;
	static int max = 0;
	
	static ArrayList<int[]> sl = new ArrayList<>();
	static ArrayList<int[]> bl = new ArrayList<>();
	static ArrayList<Integer> cl = new ArrayList<>();
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		input = new int[N][2];
		matrix = new int[N][N];
		kmatrix = new int[N][N];
		for (int i=0;i<N;i++) {
			for (int j=0;j<2;j++) {
				input[i][j] = scanner.nextInt();
			}
		}
		
		/*
		for (int i=0;i<N;i++) {
			for (int j=0;j<2;j++) {
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}
		*/
		
		for (int i=0;i<N;i++) {
			sl.add(input[i]);
		}
		
		/*
		for (int[] i: sl) {
			System.out.print(" "+i[0]+" "+i[1]);
		}
		*/
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				matrix[i][j] = inf;
			}
		}
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				
				if ((sl.get(i)[0]>=sl.get(j)[0]&&sl.get(i)[1]>=sl.get(j)[1])
						||(sl.get(i)[1]>=sl.get(j)[0]&&sl.get(i)[0]>=sl.get(j)[1])  ) {
					matrix[i][j] = 1;
				}
			}
		}
		/*
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				//System.out.print(matrix[i][j]+" ");
				System.out.printf("%3d ", matrix[i][j]);
			}
			System.out.println();
		}
		*/
		
		for (int k=0;k<N;k++) {
			for (int i=0;i<N;i++) {
				for (int j=0;j<N;j++) {

					if ((i!=k)&&(i!=j)&&(j!=k)&&(matrix[i][k]+matrix[k][j] > matrix[i][j]) && (matrix[i][k]+matrix[k][j] <= N)) {
						matrix[i][j] = matrix[i][k] + matrix[k][j];
						kmatrix[i][j] = k;

					}
				}
			}
		}
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				//System.out.print(matrix[i][j]+" ");
				//System.out.printf("%3d ", matrix[i][j]);
				if (matrix[i][j] != inf) {
					max = Math.max(matrix[i][j], max);
				}

			}
			//System.out.println();
		}
		/*
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				//System.out.print(matrix[i][j]+" ");
				System.out.printf("%3d ", kmatrix[i][j]);
			}
			System.out.println();
		}
		*/
		System.out.println(max+1);
		

	}

}
