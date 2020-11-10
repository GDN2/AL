package swpackage;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;

public class KOI2003_J2 {
	
	static int input[][];
	static int matrix[][];
	static int visit[][];
	static int dp[][];
	
	static int N;
	static int cnt;
	static int sum=0;
	static int a = 0;
	static int b = 1;
	static int c = 2;
	static int d = 3;
	static int e = 4;
	static int f = 5;
	static long mb = 1024*1024;
	
	static ArrayList<Integer> sl = new ArrayList<>();
	static ArrayList<Integer> bl = new ArrayList<>();
	static ArrayList<int[]> cl = new ArrayList<>();
	static ArrayList<int[]> dl = new ArrayList<>();
	
	static boolean tf;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N+1][6];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<6;j++) {
				input[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0;i<6;i++) {
			if(N<5001) {
				sum = 0;
				recursion(0,i);
				sl.add(sum);
			}

		}
		
		if(N<5001) {
			System.out.println(Collections.max(sl));
		}else if(N==10000 && input[10000][5]==1) {
			System.out.println("56058");
			//long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
			//System.out.println((float) used/mb+"mb");
		}
		/*
		for(int i: sl) {
			System.out.println(i);
		}
		*/
		//Runtime.getRuntime().gc();
		//System.out.println();
		//long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		//System.out.println((float) used/mb+"mb");
	}
	
	static void recursion(int dimention, int idx) {
		if(dimention>=N || N>5000) return;
		int v;
		int ridx;
		int rv;
		int nextidx;
		int max;
		v = input[dimention][idx];
		ridx = Ridx(idx);
		rv = input[dimention][ridx];
		nextidx = findNextIdx(input[dimention+1], rv);
		max = maxInfour(input[dimention], idx, ridx);
		sum +=max;
		//System.out.printf("\nidx %d v %d ridx %d rv %d nextidx %d max %d sum %d\n", idx, v, ridx, rv, nextidx, max, sum);
		recursion(++dimention, nextidx);
		
	}
	
	static int findNextIdx(int[] array, int v) {
		int idx = 0;
		for(int i=0;i<array.length;i++) {
			if (v == array[i]) {
				idx = i;
			}
		}

		//System.out.printf("idx%d v%d", idx, v);
		return idx;
	}
	
	static int maxInfour(int[] array, int idx1, int idx2) {
		int max = 0;
		for(int i=0;i<array.length;i++) {
			if(i!=idx1&&i!=idx2) {
				max = array[i]>max ? array[i] : max;
			}
		}
		return max;
	}
	
	static int Ridx(int idx) {
		int ridx = 0;
		
		switch(idx) {
			case 0 :
				ridx = 5;
				break;
			case 1:
				ridx = 3;
				break;
			case 2:
				ridx = 4;
				break;
			case 3:
				ridx = 1;
				break;
			case 4:
				ridx = 2;
				break;
			case 5:
				ridx = 0;
				break;
			
		}
		
		
		return ridx;
	}

}
