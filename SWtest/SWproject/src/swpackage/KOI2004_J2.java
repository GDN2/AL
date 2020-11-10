package swpackage;

import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.LinkedList;


public class KOI2004_J2 {

	static int[] input;
	static int[] matrix;
	static int[] visit;
	static int[][] dp;
	
	static int N;
	static int cnt;
	
	static ArrayList<Integer> al = new ArrayList<>();
	static ArrayList<Integer> bl = new ArrayList<>();
	static ArrayList<int[]> cl = new ArrayList<>();
	static ArrayList<int[]> dl = new ArrayList<>();
	static LinkedList<Integer> sl = new LinkedList<>();
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		input = new int[N+1];
		matrix = new int[N+1];
		st = new StringTokenizer(br.readLine());
		sl.add(0);
		for(int i=1;i<=N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
			matrix[i] = i;
			sl.add(i);
		}
		

		
		for(int i=1;i<=N;i++) {
			change2(i, input[i]);
		}
		
		for(int i=1;i<=N;i++) {
			System.out.print(sl.get(i)+" ");
		}

	}
	
	static void change(int idx, int a) {
		int temp;
//		System.out.printf("\nidx %d a %d\n matirxidx %d matrixidx-a %d", idx,a,matrix[idx], matrix[idx-a]);
		temp=matrix[idx];
		matrix[idx]=matrix[idx-a];
		matrix[idx-a]=temp;
//		System.out.printf("\nidx %d a %d\n matirxidx %d matrixidx-a %d", idx,a,matrix[idx], matrix[idx-a]);
		
		for(int i=1;i<=N;i++) {
			System.out.print(sl.get(i)+" ");
		}
	}
	
	static void change2(int idx, int a) {
		int temp;
//		System.out.printf("\nidx %d a %d\n matirxidx %d matrixidx-a %d", idx,a,matrix[idx], matrix[idx-a]);
		temp=sl.get(idx);
		sl.remove(idx);
		sl.add(idx-a,temp);

//		System.out.printf("\nidx %d a %d\n matirxidx %d matrixidx-a %d", idx,a,matrix[idx], matrix[idx-a]);
		/*
		for(int i=0;i<=N;i++) {
			System.out.print(sl.get(i)+" ");
		}
		System.out.println();
		 */
	}

}
