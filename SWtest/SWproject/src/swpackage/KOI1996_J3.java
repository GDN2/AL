package swpackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class KOI1996_J3 {
	
	static int[][] matrix;
	static int[][] Area;
	static int[][] visit;
	
	static int N;
	static int cnt;
	static int totalArea;
	
	static ArrayList<Integer> al = new ArrayList<Integer>();
	static int[] square = new int[4];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		matrix = new int[4][4];
		Area = new int[100][100];
		visit = new int[100][100];

		for (int i=0;i<4;i++) {
			String line = scanner.nextLine();
			String[] lineNum = line.split(" ");
			for (int j=0;j<lineNum.length;j++) {
				matrix[i][j] = Integer.parseInt(lineNum[j]);
			}

		}
		/*
		
		for (int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		*/
		
		for (int i=0;i<4;i++) {
			//square[i] = (matrix[i][2] - matrix[i][0]) * (matrix[i][3]-matrix[i][1]);
			/*
			for (int j=i+1;j<4;j++) {
				if (matrix[j][0]>=matrix[i][0]&&matrix[j][2]<=matrix[i][0]
						&&matrix[j][1]>=matrix[j][1]&&matrix[j][3]<=matrix[i][3])
			}
			*/
			cnt = 0;
			for (int m=matrix[i][0]; m<matrix[i][2]; m++) {
				for (int n=matrix[i][1]; n<matrix[i][3]; n++) {
					if (visit[m][n] == 0) {
						cnt++;
						visit[m][n] = 1;
					}
				}
			}
			square[i]=cnt;
		}
		
		for (int i=0;i<square.length;i++) {
			//System.out.print("+"+square[i]);
			totalArea += square[i];
		}
		
		System.out.println(totalArea);
		
	}

}
