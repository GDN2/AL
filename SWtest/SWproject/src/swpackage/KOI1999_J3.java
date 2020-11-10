package swpackage;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class KOI1999_J3 {

	static int[] input;
	static int[] first;
	static int[] reverse;
	static int[][]  matrix;
	static int[][] visit;
	
	static int N;
	static int lN;
	static int cnt;
	static int rcnt;
	static int u = 2;
	static int d = 4;
	static int r = 1;
	static int l = 3;
	

	static ArrayList<int[]> firstl = new ArrayList<>();
	static ArrayList<int[]> reversel = new ArrayList<>();
	static ArrayList<int[]> inputl = new ArrayList<>();
	static ArrayList<int[]> answerl = new ArrayList<>();
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		first = new int[N];
		reverse = new int[N];
		for(int i=0;i<N;i++) {
			first[i] = scanner.nextInt();
		}
		lN = scanner.nextInt();
		for (int i=0;i<lN;i++) {
			input = new int[N];
			for (int j=0;j<N;j++) {
				input[j]= scanner.nextInt();
			}
			inputl.add(input);
		}
		/*
		System.out.println(first[9]);
		for(int[] input: inputl) {
			System.out.println(input[0]+" "+input[9]);
		}
		*/
		makefirstl(first);
		reverse = makereverse(first);
		makereversel(reverse);
		for (int i=0;i<lN;i++) {

			for (int j=0;j<N;j++) {
				cnt = 0;
				rcnt = 0;
				for (int k=0;k<N;k++) {
					if(inputl.get(i)[k] == firstl.get(j)[k]) {
						cnt++;
					}
					if(inputl.get(i)[k] == reversel.get(j)[k]) {
						rcnt++;
					}
					if (cnt == N) {
						answerl.add(inputl.get(i));
						//System.out.println("first");
					}else if(rcnt == N) {
						answerl.add(inputl.get(i));
						//System.out.println("reverse");
					}
				}
			}
		}
		
		System.out.println(answerl.size());
		for (int i=0;i<answerl.size();i++) {
			for (int j=0;j<N;j++) {
				System.out.printf("%d ",answerl.get(i)[j]);
			}
			System.out.println();
		}

	}
	
	public static void makefirstl(int[] f) {
		firstl.add(f);

		for(int i=1;i<N;i++) {
			input = new int[N];
			for (int j=0;j<N;j++) {
				if (j+i<N) {
					input[j] = f[j+i];
				}else {
					input[j] = f[j+i-N];
				}
			}
			firstl.add(input);
		}
	}
	
	public static void makereversel(int[] r) {
		reversel.add(r);

		for(int i=1;i<N;i++) {
			input = new int[N];
			for (int j=0;j<N;j++) {
				if (j+i<N) {
					input[j] = r[j+i];
				}else {
					input[j] = r[j+i-N];
				}
			}
			reversel.add(input);
		}
	}
	
	public static int[] makereverse(int[] f) {
		input = new int[N];
		for (int i=N-1;i>=0;i--) {
			input[i] = f[N-1-i];
		}
		for (int i=0;i<N;i++) {
			if (input[i]==r) {
				input[i] = l;
			}else if(input[i]==l) {
				input[i]=r;
			}else if(input[i]==u) {
				input[i]=d;
			}else if(input[i]==d) {
				input[i]=u;
			}
			
		}
		
		return input;
	}

}
