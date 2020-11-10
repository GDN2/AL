package swpackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class KOI2004_J3 {
	
	static int[][] input;
	static int[][] matrix;
	static int[][] visit;
	static int[][] dp;
	
	static int cN;
	static int iN;
	static int cnt;
	
	static ArrayList<Integer> al = new ArrayList<>();
	static ArrayList<int[]> bl = new ArrayList<>();
	static ArrayList<int[]> cl = new ArrayList<>();
	
	static boolean tf = true;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		cN = sc.nextInt();
		matrix = new int[cN+1][cN+1];
		iN = sc.nextInt();
		input = new int[iN][2];

		
		for(int i=0;i<iN;i++) {
			for(int j=0;j<2;j++) {
				input[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<iN;i++) {
			matrix[input[i][0]][input[i][1]] =1 ;
			matrix[input[i][1]][input[i][0]] =1 ;
		}
		
		for(int i=1;i<=cN;i++) {
			for(int j=1;j<=cN;j++) {
				if(matrix[i][j]!=1) {
					matrix[i][j] = 999;
					if(i==j) {
						matrix[i][j]=1;
					}
				}
			}
		}
		/*
		for(int i=1;i<=cN;i++) {
			for(int j=1;j<=cN;j++) {
				System.out.printf("%3d ", matrix[i][j]);
			}
			System.out.println();
		}
		*/
		for(int k=1;k<=cN;k++) {
			for(int i=1;i<=cN;i++) {
				for(int j=1;j<=cN;j++) {
					matrix[i][j] = (matrix[i][k]+matrix[k][j]<matrix[i][j]) ? matrix[i][k]+matrix[k][j] : matrix[i][j];
				}
			}
		}
		
		/*
		System.out.println();
		System.out.println();
		for(int i=1;i<=cN;i++) {
			for(int j=1;j<=cN;j++) {
				System.out.printf("%3d ", matrix[i][j]);
			}
			System.out.println();
		}
		*/
		for(int i=1;i<=cN;i++) {
			if(matrix[1][i]>=1&&matrix[1][i]<999) {
				cnt++;
			}
		}
		
		System.out.println(cnt-1);
		
		

	}

}
