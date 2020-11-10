package swpackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class KOI2004_J12 {

	static int[] input;
	static String[] matrix;
	static int[] visit;
	static int[][] dp;
	static char[] ca;
	
	static int N;
	static int fn;
	static int cnt;
	static String As = "000000";
	static int Ai = 0b000000;
	static String Bs = "001111";
	static int Bi = Integer.parseInt(Bs,2);
	static String Cs = "010011";
	static int Ci = Integer.parseInt(Cs,2);
	static String Ds = "011100";
	static int Di = Integer.parseInt(Ds,2);
	static String Es = "100110";
	static int Ei = Integer.parseInt(Es,2);
	static String Fs = "101001";
	static int Fi = Integer.parseInt(Fs,2);
	static String Gs = "110101";
	static int Gi = 0b110101;
	static String Hs = "111010";
	static int Hi = 0b111010;
	
	static int CASE;
	
	static ArrayList<String> cl = new ArrayList<>();
	
	static boolean tf = true;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt()*6;
		fn = (int) N/6;
		input = new int[N+1];
		matrix = new String[6];
		dp = new int[8][2];
		visit = new int[8];
		ca = new char[9];
		String str = sc.next();
		for(int i=1;i<=N;i++) {
			input[i] = str.charAt(i-1)-'0';
		}
		/*
		for(int i=1;i<=N;i++) {
			System.out.print(input[i]+" ");
		}
		System.out.println();
		*/
		/*
		int a = 0b000010;
		int b = 0b000001;
		System.out.println(a^b);
		System.out.println(Gi^Hi);
		String aa = Integer.toBinaryString(9036);
		String bb = Integer.toBinaryString(28);
		System.out.println("ci "+Ci);
		System.out.println("bi" +Bi);
		System.out.println(bb);
		System.out.println(Cs);
		System.out.println(Bs);
		*/
		
		for(int i=0;i<fn;i++) {
			
			tf = ConvertAlphabet(i);
			
			if(tf == false) {
				break;
			}
		}
		
		if(tf == true) {
			for(int i=0;i<cl.size();i++) {
				System.out.print(cl.get(i));
			}
		}else {
			System.out.println(cnt);
		}
		
	}
	
	static boolean ConvertAlphabet(int idx) {
		cnt++;
		boolean tf = true;
		for(int i=0;i<6;i++) {

			matrix[i] = Integer.toString(input[(6*idx)+1+i]);
		}
		
		arrayclear();
		for(int i=0;i<6;i++) {
			if(matrix[i].charAt(0)==As.charAt(i)) {
				visit[0]++;
			}
			if(matrix[i].charAt(0)==Bs.charAt(i)) {
				visit[1]++;
			}
			if(matrix[i].charAt(0)==Cs.charAt(i)) {
				visit[2]++;
			}
			if(matrix[i].charAt(0)==Ds.charAt(i)) {
				visit[3]++;
			}
			if(matrix[i].charAt(0)==Es.charAt(i)) {
				visit[4]++;
			}
			if(matrix[i].charAt(0)==Fs.charAt(i)) {
				visit[5]++;
			}
			if(matrix[i].charAt(0)==Gs.charAt(i)) {
				visit[6]++;
			}
			if(matrix[i].charAt(0)==Hs.charAt(i)) {
				visit[7]++;
			}
			
		}

		CASE = 0;
		if(visit[0]==6||visit[0]==5) {
			CASE = 1;
			cl.add("A");
		}
		if(visit[1]==6||visit[1]==5) {
			CASE = 2;
			cl.add("B");
		}
		if(visit[2]==6||visit[2]==5) {
			CASE = 3;
			cl.add("C");
		}
		if(visit[3]==6||visit[3]==5) {
			CASE = 4;
			cl.add("D");
		}
		if(visit[4]==6||visit[4]==5) {
			CASE = 5;
			cl.add("E");
		}
		if(visit[5]==6||visit[5]==5) {
			CASE = 6;
			cl.add("F");
		}
		if(visit[6]==6||visit[6]==5) {
			CASE = 7;
			cl.add("G");
		}
		if(visit[7]==6||visit[7]==5) {
			CASE = 8;
			cl.add("H");
		}

		
		if(CASE ==0) {
			tf = false;
		}
		return tf;
	}
	
	static void arrayclear() {
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i],0);
		}
		Arrays.fill(visit,0);		
	}
	

}
