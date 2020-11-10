package swpackage;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class KOI2002_J2 {
	
	static int input[];
	static int matrix[];
	static int visit[];
	static int weight[];
	static int dp1[];
	static int dp2[];
	static int dp3[];
	static int dp[][];
	
	static int N;
	static int cnt;
	static int sum;
	static int rest;
	static int half;
	
	static ArrayList<int[]> wl = new ArrayList<>();
	static ArrayList<Integer> bl = new ArrayList<>();
	static ArrayList<Integer> suml = new ArrayList<>();
	static ArrayList<Integer> weightl = new ArrayList<>();
	
	static boolean tf = false;
	static boolean even = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		if(N%2 == 0) {
			half = N/2;
			even = true;
		}else{
			half = N/2;
		}
		
		if(even) {
			//System.out.println("0 ");
			find2();
			System.out.println(cnt);
		}else{
			find2();
			System.out.println(cnt);
		}
		
		/*
		for(int[] i:wl) {
			System.out.printf("%d %d %d\n",i[0], i[1], i[2]);
		}
		*/
		
		
		
	}
	
	static void find2 () {
		for(int i=1;i<=half;i++) {

			for(int j=i;j<=half;j++) {
				/*
				weight = new int[3];
				weight[0] = i;
				weight[1] = j;
				weight[2] = N-i-j;
				Arrays.sort(weight);
				*/
				int k = N-i-j;
				if (j>k) break;
				if (i+j>k) cnt++;
				//int max = weight[weight.length-1];
				//System.out.printf("%d %d %d\n",weight[0], weight[1], weight[2]);
				/*
				if(dp[weight[0]][weight[1]]!=weight[2]&&weight[0]+weight[1]>weight[2] && weight[0]+weight[2]>weight[1] && weight[1]+weight[2]>weight[0]) {
					dp[weight[0]][weight[1]]=weight[2];
					wl.add(weight);
				}
				*/

				
			}
		}
		
	}
	
	static void find (int rest, int idx) {
		if(idx>2) {
			return;
		}
		if(idx==0) {
			for(int i=1;i<=half;i++) {
				rest = N;
				int localrest;
				weight = new int[3];
				weight[0] = i;
				localrest = rest-i;
				//System.out.printf("\nweight[0] %d rest %d ", weight[0], localrest);
				find(localrest, idx+1);

			}
		}
		if(idx==1) {
			for(int i=1;i<=half;i++) {
				int localrest;
				weight[idx] = i;
				localrest = rest-i;
				//System.out.printf("\nweight[1] %d rest %d ", weight[1], localrest);
				find(localrest,idx+1);

			}

		}
		if(idx==2) {
			weight[idx] = rest;
			//System.out.printf("\nweight[2] %d rest %d ", weight[2], 0);
			//sortWeight(weight);
			int[] w = new int[3];
			for(int i=0;i<weight.length;i++) {
				w[i] = weight[i];
			}
			
			if(wl.indexOf(weight)==-1) {
				if(w[0]+w[1]>w[2] && w[0]+w[2]>w[1] && w[1]+w[2]>w[0]) {
					wl.add(w);
				}

			}
		}

	}
	
	static void sortWeight(int w[]) {
		w = new int[3];
		weightl.clear();
		for(int i=0;i<weight.length;i++) {
			w[i] = weight[i];
		}
		
		//System.out.printf("\nbefore%d %d %d",w[0], w[1], w[2]);
		for(int i=0;i<weight.length;i++) {
			weightl.add(w[i]);
		}
		Collections.sort(weightl);
		/*
		for(int i=0;i<weight.length;i++) {
			w[i] = weightl.get(i);
		}
		*/
		
		


		//System.out.printf("\nafter%d %d %d",w[0], w[1], w[2]);
	}
	

}
