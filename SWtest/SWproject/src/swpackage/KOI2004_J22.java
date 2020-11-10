package swpackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class KOI2004_J22 {
	
	static int[][] input;
	static int[] matrix;
	static int[][] visit;
	static int[][] dp;
	
	static int N;
	static int cnt;
	static int R = 1;
	static int B = 2;
	static int Y = 3;
	static int length;
	static int changelength;
	static int lpoint;
	static int rpoint;
	static int halfpoint;
	static int ypoint;
	
	static ArrayList<Integer> al = new ArrayList<>();
	static ArrayList<Integer> bl = new ArrayList<>();
	static ArrayList<int[]> cl = new ArrayList<>();
	
	static boolean ltf = false;
	static boolean rtf = false;
	static boolean ytf = false;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		length = 2*N;
		changelength = length;
		lpoint=0;
		rpoint=length;
		N = 2*N+1;
		matrix = new int[N];
		input = new int[3][2];
		for(int i=0;i<3;i++) {
			for(int j=0;j<2;j++) {
				input[i][j] = sc.nextInt()*2;
				int m = input[i][j];
				if(i==0) {
					matrix[m] = R;
				}else if(i==1) {
					matrix[m] = B;
				}else if(i==2) {
					matrix[m] = Y;
				}
			}
		}
		
//		matrix[4] = 0;

//		printMatrix();
		for(int i=0;i<3;i++) {
			half(input[i][0],input[i][1],R+i);
//			printMatrix();
//			System.out.println(changelength);

		}
		
		System.out.println((double) changelength/2);
		

	}

	static void printMatrix() {
		for(int i=0;i<matrix.length;i++) {
			System.out.printf(matrix[i]+" ");
		}
		System.out.println();
	}
	
	static void half(int m, int n, int color) {
		int max = Math.max(m, n);
		int min = Math.min(m, n);
		int minus = max - min;

		int half = (int) minus/2;
//		System.out.printf("\n min %d max %d half %d\n", min, max,half);
		int point=0;
		if(((min+half-lpoint)>= (double) changelength/2)&&minus!=0) {
			rtf = true;
			ltf = false;
			point = min+half;
			rpoint = point;
		}else if(((min+half-lpoint)< (double) changelength/2)&&minus!=0){
			ltf = true;
			rtf = false;
			point = min+half;
			lpoint = point;
		}
//		System.out.printf("\n lpoint %d, rpoint %d \n", lpoint,rpoint);
		changelength = length - (length-rpoint) - lpoint;
		
		if (color==R) {
			if(input[0][0]==min&&ltf==true) {
				matrix[input[0][0]]=0;
				input[0][0]=0;
			}else if(input[0][1]==min&&ltf==true){
				matrix[input[0][1]]=0;
				input[0][1]=0;

			}else if(input[0][0]==max&&rtf==true) {
				matrix[input[0][0]]=0;
				input[0][0]=0;
			}else if(input[0][1]==max&&rtf==true) {
				matrix[input[0][1]]=0;
				input[0][1]=0;
			}
			
			if(ltf == true) {
				if((point>input[1][0])) {
					matrix[input[1][0]] = 0;
					input[1][0] = input[1][0]+2*(point-input[1][0]);
					matrix[input[1][0]] = B;
				}
				if(point>input[1][1]) {
					
					matrix[input[1][1]] = 0;
					input[1][1] = input[1][1]+2*(point-input[1][1]);
					matrix[input[1][1]] = B;
				}
				if(point>input[2][0]) {
					matrix[input[2][0]] = 0;
					input[2][0] = input[2][0]+2*(point-input[2][0]);
					matrix[input[2][0]] = Y;
				}
				if(point>input[2][1]) {
					matrix[input[2][1]] = 0;
					input[2][1] = input[2][1]+2*(point-input[2][1]);
					matrix[input[2][1]] = Y;
				}
			}else if (rtf == true) {
				if((point<input[1][0])) {
					matrix[input[1][0]] = 0;
					input[1][0] = input[1][0]-2*(input[1][0]-point);
					matrix[input[1][0]] = B;
				}
				if(point<input[1][1]) {
					matrix[input[1][1]] = 0;
					input[1][1] = input[1][1]-2*(input[1][1]-point);
					matrix[input[1][1]] = B;
				}
				if(point<input[2][0]) {
					matrix[input[2][0]] = 0;
					input[2][0] = input[2][0]-2*(input[2][0]-point);
					matrix[input[2][0]] = Y;
				}
				if(point<input[2][1]) {
					matrix[input[2][1]] = 0;
					input[2][1] = input[2][1]-2*(input[2][1]-point);
					matrix[input[2][1]] = Y;
				}
			}
			
		}
		
		if (color==B && minus!=0) {

			if(ltf == true) {
				if(point>input[2][0]) {
					matrix[input[2][0]] = 0;
					input[2][0] = input[2][0]+2*(point-input[2][0]);
					matrix[input[2][0]] = Y;
				}
				if(point>input[2][1]) {
					matrix[input[2][1]] = 0;
					input[2][1] = input[2][1]+2*(point-input[2][1]);
					matrix[input[2][1]] = Y;
				}
			}else if (rtf == true) {
				if(point<input[2][0]) {
					matrix[input[2][0]] = 0;
					input[2][0] = input[2][0]-2*(input[2][0]-point);
					matrix[input[2][0]] = Y;
				}
				if(point<input[2][1]) {
					matrix[input[2][1]] = 0;
					input[2][1] = input[2][1]-2*(input[2][1]-point);
					matrix[input[2][1]] = Y;
				}
			}
			
		}
		
		
	}

}
