package Floyd;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;

public class Floyd {

	int[][] D;
	int[][] P;
	int n;
	
	public void Floyd2(int[][] W){
		
		this.n = W.length;
		this.D = W;
		this.P = new int[n][n];
		for(int i=1; i<n; i++)
			for(int j=1; j<n; j++)
				P[i][j]=0;
		
		
		for(int k=1; k<n; k++) {
			for(int i=1; i<n; i++) {
				for(int j=1; j<n; j++) {
					if(D[i][k] + D[k][j] < D[i][j]) {
						P[i][j] = k;
						D[i][j] = D[i][k]+D[k][j];
						}
				}
			}
		}	
	}
	
	public void path(int q,int r){
		
		if(P[q][r]!=0) {
			path(q,P[q][r]);
			System.out.print("v"+P[q][r]+" ");
			path(P[q][r],r);
		}
	}

	
	public int[][] getD(){
		return D;
	}
	public int[][] getP(){
		return P;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Floyd Argorithm Test\n");
		Floyd floyd = new Floyd();
		
		System.out.println("Enter order n");
		int N = scan.nextInt();
		
		System.out.println("Enter n order matrix");
		int[][] W = new int[N+1][N+1];
		for(int i=1; i<=N; i++)
			for(int j=1; j<=N; j++)
				W[i][j] = scan.nextInt();
		
		floyd.Floyd2(W);
		int[][] D = floyd.getD();
		int[][] P = floyd.getP();
		
		System.out.println("D matrix");
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++)
				System.out.print(D[i][j] + " ");
			System.out.println();
		}
		System.out.println("P matrix");
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++)
				System.out.print(P[i][j] + " ");
			System.out.println();
		}
		
		System.out.println("Shortest Course q->r");
		System.out.println("Input q r");
		int q = scan.nextInt();
		int r = scan.nextInt();
		
		floyd.path(q, r);
		
		
		
	}

}
