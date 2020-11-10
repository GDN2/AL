package swpackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KOI2003_J3 {
	
	static int[][] matrix;
	static int[] input;
	static int[][] visit;
	static int[][] dp;
	
	static int N;
	static int maxN;
	static int mini=3;
	static int cnt;
	static int sum=0;
	static int answer;
	
	static ArrayList<Integer> al = new ArrayList<>();
	static ArrayList<Integer> bl = new ArrayList<>();
	static ArrayList<int[]> cl = new ArrayList<>();
	static ArrayList<int[]> dl = new ArrayList<>();
	
	static boolean tf;
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		input = new int[N+N/3];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
			sum += input[i];
		}
		maxN = Integer.parseInt(br.readLine());
		dp = new int[N+1][100*3*maxN+1];
		visit = new int[N+1][100*3*maxN+1];
		matrix = new int[mini][maxN];
		dfs(0, 0, 0, maxN);

		//System.out.println(dp[1][90]);
		//System.out.println(dp[2][165]);
		//System.out.println(dp[3][210]);
		for(int i=100*3*maxN;i>=0;i--) {
			if(dp[3][i]==1) {
				answer=i;
				break;
			}
		}
		System.out.println(answer);
		System.out.println("cnt "+cnt);
		long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("memory(mb) "+(float) memory/(1024*1024));
	}

	static void dfs(int layer, int idx,int sum,int localcnt) {


		if((layer>mini) || idx>N )return;
		dp[layer][sum]=1;
		visit[idx][sum]=1;
		//System.out.printf("\nlayer%d idx%d sum %d\n",layer, idx, sum);

		cnt++;
		
		
		if(localcnt<(maxN)) {
			//System.out.println("step1");
			dfs(layer ,idx+1,sum,localcnt+1);

		}else {
			//System.out.println("step2");

			dfs(layer+1 ,idx+maxN,funcSum(sum,idx,maxN),maxN);
//			dfs(layer+1 ,idx+1,funcSum(sum,idx,maxN),1);
			dfs(layer, idx+1,sum,maxN);

		}

	}
	
	static int funcSum(int sum, int idx, int maxN) {
		for(int i=0;i<maxN;i++) {
			sum = sum + input[idx+i];
			//System.out.println("sum"+sum);
		}
		
		//System.out.println("sum"+sum);
		return sum;
	}
}
