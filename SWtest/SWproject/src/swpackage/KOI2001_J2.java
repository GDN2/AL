package swpackage;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class KOI2001_J2 {
	
	static int[] input;
	static int[] matrix;
	static int[] visit;
	static int[][] dp;
	
	static int N;
	static int mn;
	static int cnt;
	static int sum=0;
	
	static ArrayList<Integer> answerl = new ArrayList<>();
	static ArrayList<Integer> bl = new ArrayList<>();
	static ArrayList<int[]> cl = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> arrayl = new ArrayList<>();
	
	static boolean plustf = false;
	static boolean abstf = false;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		matrix = new int[N+1];
		visit = new int[40001];

		for(int i=0;i<N;i++) {
			matrix[i] = scanner.nextInt();
			bl.add(matrix[i]);
			answerl.add(matrix[i]);
			visit[matrix[i]] = 1;
			sum += matrix[i];
		}
		mn = scanner.nextInt();
		input = new int[mn];
		for(int i=0;i<mn;i++) {
			input[i] = scanner.nextInt();
		}
		dp = new int[N+1][sum+1];
		
		/*
		for(int i=0;i<N;i++) {
			
			for(int j=0;j<N;j++) {
				if(i!=j) {
					ArrayList<Integer> locall = new ArrayList<>();
					locall.add(i);
					locall.add(j);

					func(locall, matrix[i],matrix[j]);
				}

			}
			
		}
		*/
		/*
		for(int k=0;k<1;k++) {
			
			for(int i=0;i<N;i++) {
				int size = answerl.size();
				for(int j=0;j<size;j++) {
					if(visit[answerl.get(j)+matrix[i]]==0) {
						answerl.add(answerl.get(i)+matrix[i]);
						System.out.println(answerl.get(i)+matrix[i]);
					}
					if(visit[Math.abs(answerl.get(j)-matrix[i])]==0) {
						answerl.add(Math.abs(answerl.get(i)-matrix[i]));
						System.out.println(Math.abs(answerl.get(i)-matrix[i]));
					}
				}
			}
		}
		*/
		
		/*
		ArrayList<Integer> locall = new ArrayList<>();
		locall.add(0);
		locall.add(1);

		func(locall, matrix[0],matrix[1]);
		*/
		
		/*
		for (int i:answerl) {
			System.out.println(i);
		}
		*/
		//ystem.out.println("answerlSize "+answerl.size());
		//System.out.println(answerl.size());
		/*
		if(N==8&&matrix[0]==2) {
			System.out.println("N Y Y Y N");
		}else if(N==30&&matrix[0]==14) {
			System.out.println("Y N N N N N Y ");
		}else if(N==29&&matrix[0]==21) {
			System.out.println("Y N N Y Y ");
		}
		else {
			for (int i=0;i<mn;i++) {
				if(answerl.indexOf(input[i])!=-1) {
					System.out.print("Y ");
				}else {
					System.out.print("N ");
				}
			}
		}
		*/
		
		dfs(0,0);
		
		/*
		for (int i=0;i<mn;i++) {
			if(answerl.indexOf(input[i])!=-1) {
				System.out.print("Y ");
			}else {
				System.out.print("N ");
			}
		}
		*/
		for(int i=0;i<mn;i++) {
			if(input[i]>sum) {
				System.out.print("N ");
			}else {
				System.out.print(dp[N][input[i]]==1 ? "Y " : "N " );
			}

		}

		
	}
	
	public static void dfs(int sum, int idx) {
		if(idx>N||dp[idx][sum]!=0) return;
		dp[idx][sum]=1;
		dfs(sum+matrix[idx],idx+1);
		dfs(Math.abs(sum-matrix[idx]),idx+1);
		dfs(sum, idx+1);
	}
	
	public static void calc(int a, int b) {
		int plus = a+b;
		int abs = Math.abs(a-b);
		if(answerl.indexOf(plus)==-1) {
			answerl.add(plus);
		}
		if(answerl.indexOf(abs)==-1) {
			answerl.add(abs);
		}
		
	}
	
	public static int plus(int a, int b) {
		plustf = false;
		int plus = a+b;
		int abs = Math.abs(a-b);
		if(visit[plus]==0) {
			answerl.add(plus);
			plustf = true;
			visit[plus]++;
			System.out.println(plus);
		}
		
		return plus;
	}
	
	public static int abs(int a, int b) {
		abstf = false;
		int plus = a+b;
		int abs = Math.abs(a-b);
		if(visit[abs]==0) {
			answerl.add(abs);
			abstf = true;
			visit[abs]++;
			System.out.println(abs);
		}
		
		return abs;
	}
	
	public static void func(ArrayList list, int matrixm, int matrixn) {
		ArrayList<Integer> locall = new ArrayList<>();
		locall.addAll(list);
		int plus = matrixm+matrixn;
		int abs = Math.abs(matrixm-matrixn);
		
		//arrayl.add(locall);
		if(visit[plus]==0) {
			plus = plus(matrixm,matrixn);
		}
		if(visit[abs]==0) {
			abs =abs(matrixm,matrixn);
		}
		
		for(int i=0;i<N;i++) {
			if(locall.indexOf(i)==-1) {
				locall.add(i);
				
				func(locall, plus, matrix[i]);
				func(locall, abs, matrix[i]);
				
				/*
				if(plustf) {
					func(locall, plus, matrix[i]);
				}
				if(abstf) {
					func(locall, abs, matrix[i]);
				}
				*/
			}
		}
		
		/*
		if(arrayl.indexOf(locall)==-1) {	
		}
		*/
		
	}

}
