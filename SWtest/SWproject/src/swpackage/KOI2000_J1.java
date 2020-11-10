package swpackage;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;


public class KOI2000_J1 {
	
	public static int[] input;
	public static int[][] matrix;
	
	public static int N;
	public static int half;
	public static int cnt;
	public static int second;
	
	public static ArrayList<int[]> al = new ArrayList<>();
	public static ArrayList<int[]> bl = new ArrayList<>();
	public static ArrayList<Integer> nl = new ArrayList<>();
	public static ArrayList<Integer> nl2 = new ArrayList<>();
	
	public static boolean tf = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		half = (int) Math.round(N/2);
		input = new int[half];
		
		for (int i=half;i<=N;i++) {
			find(N,i);
			if(nl.size()>nl2.size()) {
				nl2.clear();
				nl2.addAll(nl);
				second = i;
			}
			nl.clear();
		}
		System.out.println(nl2.size()+2);
		System.out.printf("%d %d ", N, second);
		for(int i: nl2) {
			System.out.print(i+" ");
		}
		
	}
	
	public static void find(int a, int b) {
		
		if ((a - b)>=0) {
			nl.add(a-b);
			find(b,(a-b));
		}

	}

}
