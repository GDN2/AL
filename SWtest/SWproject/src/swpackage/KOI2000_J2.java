package swpackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;



public class KOI2000_J2 {
	
	public static int[] input;
	public static int[][] visit;
	public static int[][] matrix;
	
	public static int N;
	public static int M;
	public static int cnt;
	public static int multiply;
	public static int on = 1;
	public static int off = 0;
	public static int man = 1;
	public static int woman = 2;
	
	public static ArrayList<int[][]> al = new ArrayList<>();
	public static ArrayList<int[][]> bl = new ArrayList<>(); 
	public static ArrayList<Integer> cl = new ArrayList<>(); 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		input = new int[N+1];
		for (int i=1;i<N+1;i++) {
			input[i] = scanner.nextInt();
		}
		M = scanner.nextInt();
		matrix = new int[M][2];
		for (int i=0;i<M;i++) {
			for (int j=0;j<2;j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		
		for (int i=0;i<M;i++) {
			cnt =1;
			multiply=1;
			if(matrix[i][0]==man) {
				switchM(matrix[i][1]);
			}else {
				switchW(matrix[i][1]);
			}
		}
		
		for(int i=1;i<N+1;i++) {
			System.out.print(input[i]+" ");
			if(i%20==0) {
				System.out.println();
			}
		}
		
		
	}
	
	public static void switchM(int Num) {
			
		if(input[Num*multiply]==on) {
			input[Num*multiply]=off;
		}else {
			input[Num*multiply]=on;
		}
		
		multiply++;
		if(Num*multiply>=1&&Num*multiply<N+1) {
			switchM(Num);
		}
	}
	
	
	public static void switchW(int Num) {
		
		int cntminus = cnt-1;
		
		if((Num-cnt)>=1&&(Num+cnt)<N+1) {
			
			if(input[Num-cnt]==input[Num+cnt]) {
				cnt++;
				switchW(Num);
			}else {
				for(int i=Num-cntminus;i<=Num+cntminus;i++) {
					if(input[i]==on) {
						input[i]=off;
					}else {
						input[i]=on;
					}

				}
			}
		
		}else {
			for(int i=Num-cntminus;i<=Num+cntminus;i++) {
				if(input[i]==on) {
					input[i]=off;
				}else {
					input[i]=on;
				}

			}
			
		}
		
	}

}
