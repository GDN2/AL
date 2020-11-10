package swpackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KOI2003_J3C2 {
	
	static int[][] matrix;
	static int[] input;
	static int[][] visit;
	static int[] dp;
	static int[] max;
	static int[][] dm;
	
	static int N;
	static int maxN;
	static int mini=3;
	static int cnt1;
	static int cnt2;
	static int cnt3;
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
		input = new int[N+1+N/3];

		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			input[i] = Integer.parseInt(st.nextToken());
			sum += input[i];
		}
		maxN = Integer.parseInt(br.readLine());

		//visit = new int[N+1][100*3*maxN+1];
		//matrix = new int[mini][maxN];
		max = new int[mini+1];
//		dp = new int[N+1][100*3*maxN+1];
		dp = new int[N+1];
		dm = new int[mini+1][N+1];
		//dfs(0, 0, 0, maxN);
		dinamic();
		/*
		for(int i=0;i<=3;i++) {
			for(int j=1;j<=N;j++) {
				System.out.printf("%4d ",dm[i][j]);
			}
			System.out.println();
		}
		*/
		System.out.println(dm[mini][N]);

		//System.out.println(dp[1][90]);
		//System.out.println(dp[2][165]);
		//System.out.println(dp[3][210]);
		/*
		for(int i=100*3*maxN;i>=0;i--) {
			if(dp[3]==1) {
				answer=i;
				break;
			}
		}
		*/
		

		/*
		System.out.println(dp[3]);
		System.out.println("cnt3 "+ cnt3);
		System.out.println("dp[1]"+dp[1]+" cnt1 "+cnt1);
		System.out.println("dp[2]"+dp[2]+" cnt2 "+cnt2);

		long memory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		System.out.println("memory(mb) "+(float) memory/(1024*1024));
		*/
	}
	
	
	static void dinamic() {
		
		for(int i=1;i<=3;i++) {
			for(int j=i*maxN;j<=N;j++) {

				dm[i][j] = Math.max(dm[i-1][j-maxN]+funcSum(0, j-maxN+1, maxN), dm[i][j-1]);


			}
		}
		
	}

	static void dfs(int layer, int idx,int sum,int localcnt) {


		if((layer>3) || idx>N )return;
		

		//visit[idx][sum]=1;
		max[layer] = (sum>max[layer]) ? sum : max[layer];


/*
		if(sum<max[layer]) return;
		if(layer>=1 && sum<max[layer-1]) return;
		if(layer>=2 && sum<max[layer-2]) return;
		if(layer>=3 && sum<max[layer-3]) return;
*/
		if(returnCheck(sum,layer)) return;
		System.out.printf("\nmax %d layer %d\n", max[layer], layer);
		dp[layer]=sum;
		
		
		//System.out.printf("\nlayer%d idx%d sum %d\n",layer, idx, sum);

		if(layer==1) {
			cnt1++;
		}else if(layer==2) {
			cnt2++;
		}else if(layer==3) {
			cnt3++;
		}

		
		
		if(localcnt<(maxN)) {
			//System.out.println("step1");
			dfs(layer ,idx+1,sum,localcnt+1);

		}else {
			//System.out.println("step2");
//			dfs(layer, idx+1,sum,maxN);
			dfs(layer+1 ,idx+maxN,funcSum(sum,idx,maxN),maxN);
//			dfs(layer+1 ,idx+1,funcSum(sum,idx,maxN),1);
			dfs(layer, idx+1,sum,maxN);


		}

	}
	
	static boolean returnCheck(int sum,int  layer) {
		tf = false;
		if(sum<max[layer]) tf=true;
		if(layer>=1 && sum<=max[layer-1]) tf=true;
		if(layer>=2 && sum<=max[layer-2]) tf=true;
		if(layer>=3 && sum<=max[layer-3]) tf=true;
		
		return tf;
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
