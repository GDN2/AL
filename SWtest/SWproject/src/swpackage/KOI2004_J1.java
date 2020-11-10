package swpackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class KOI2004_J1{
	
	static int[] input;
	static int[] matrix;
	static int[] visit;
	static int[] dp;
	
	static int N;
	static int cnt;
	
	static ArrayList<Integer> al = new ArrayList<>();
	static ArrayList<Integer> bl = new ArrayList<>();
	static ArrayList<int[]> cl = new ArrayList<>();
	static ArrayList<int[]> dl = new ArrayList<>();
	
	static boolean tf = false;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = 7;
		input = new int[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(input);
		System.out.println(input[input.length-1]);
		System.out.println(input[input.length-2]);

	}

}
