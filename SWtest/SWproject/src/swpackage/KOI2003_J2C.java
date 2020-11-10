package swpackage;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class KOI2003_J2C {
	
	static int input[][];
	static int matrix[][];
	
	static int N;
	static int cnt=0;
	static int sum=0;
	static int a = 0;
	static int b = 1;
	static int c = 2;
	static int d = 3;
	static int e = 4;
	static int f = 5;
	static long mb = 1024*1024;
	
	static ArrayList<Integer> sl = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub


		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
   	 	StringTokenizer st;
   	 	N = Integer.parseInt(br.readLine());
		input = new int[N+1][6];
		
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}

		}
		br.close();
		
		for(int i=0;i<6;i++) {
			sum = 0;
			recursion(0,i);
			sl.add(sum);

		}
		
		System.out.println(Collections.max(sl));

		/*
		for(int i: sl) {
			System.out.println(i);
		}
		*/
		/*
		Runtime.getRuntime().gc();
		System.out.println();
		long used = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println((float) used/mb+"mb");
		*/
	}
	
	static void recursion(int dimention, int idx) {
		if(dimention>=N) return;
		int v;
		int ridx;
		int rv;
		int nextidx;
		int max;
		for (int i=0;i<N;i++) {
			v = input[dimention][idx];
			ridx = Ridx(idx);
			rv = input[dimention][ridx];
			nextidx = findNextIdx(input[dimention+1], rv);
			max = maxInfour(input[dimention], idx, ridx);
			sum +=max;
			idx = nextidx;
			dimention += 1;
		}

		//System.out.printf("\nidx %d v %d ridx %d rv %d nextidx %d max %d sum %d\n", idx, v, ridx, rv, nextidx, max, sum);
		//recursion(++dimention, nextidx);
		
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
