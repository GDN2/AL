package swpackage;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class KOI1998_J2 {

	static int[][] m;
	static int[][] d;
	static int[][] v;
	static int[][] visitV;
	static int[][] mm;
	
	static int limit;
	static int N;
	static int cnt;
	static int temp;
	
	static ArrayList<Integer> route = new ArrayList<>();
	static ArrayList<Integer> bl = new ArrayList<>();
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		limit = scanner.nextInt();
		N = scanner.nextInt();
		m = new int[N+2][N+2];
		d = new int[N+2][N+2];
		v = new int[N+2][N+2];
		mm = new int[N+2][N+2];
		
		for (int i=0;i<N+1;i++) {
			d[i][i+1] = scanner.nextInt();
		}
		
		for (int i=0;i<N;i++) {
			m[i][i+1] = scanner.nextInt();
			mm[i][i+1] = m[i][i+1];
		}
		
		
		for (int i=0;i<N+2;i++) {
			for (int j=0;j<N+2;j++) {
				if (i!=j && d[i][j] ==0) {
					d[i][j] = 999;
				}
			}
		}
		
		for (int k=0;k<N+2;k++) {
			for (int i=0;i<N+2;i++) {
				for (int j=0;j<N+2;j++) {
					if (d[i][k]+d[k][j] < d[i][j])
						d[i][j] = d[i][k]+d[k][j];
				}
			}
		}
		
		/*
		System.out.println();
		System.out.println();
		
		for (int i=0;i<N+2;i++) {
			for (int j=0;j<N+2;j++) {
				System.out.print(d[i][j]+" ");
			}
			System.out.println();
		}
		*/

		for (int i=0;i<N+2;i++) {
			for (int j=0;j<N+2;j++) {
				if (i!=j && m[i][j] == 0) {
					m[i][j] = 999;
					mm[i][j] = m[i][j];
				}
			}
		}
		m[N][N+1] = 0;
			
		//동적계획 전에 채워줄 수 있는 곳(거리 140이하)을 더 채워줌, i=j인 경우와 i=j-1인 경우는 이미 채워져 있으니 뺌
		for (int i=0;i<N+2;i++) { 
			for (int j=0;j<N+2;j++) {
				if (j>i+1 &&d[i][j]<=limit) {
					//System.out.println("i "+i+" j "+j);
					m[i][j] = m[j-1][j];
					//mm[i][j] = m[i][j];
				}
			}
		}

		
		//System.out.println();
		
		/*
		for (int i=0;i<N+2;i++) {
			for (int j=0;j<N+2;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
		*/
		for (int i=0;i<v.length;i++) {
			for (int j=0;j<v.length;j++) {
				v[i][j] = -1;
			}
		}

	
		for (int k=0;k<N+2;k++) {
			for (int i=0;i<N+2;i++) {
				for (int j=0;j<N+2;j++) {
					if ( m[i][k]+m[k][j] < m[i][j]) {
						//m[i][j] = m[i][k] + m[k][j]; 위에 주석 빼고 어떠한 코드라도 들어가 있으면 맛 감/ 이유는 위에 if문에 {}가 없었다!
						//그러므로  {}가 없었을 때는 해당 조건에서 m[i][j] = m[i][k] + m[k][i];가 {}없는 if 바로 뒤에 있으면 실행된 것
						m[i][j] = m[i][k]+m[k][j];
						v[i][j] = k;
						//System.out.println("i "+i+" j "+j);
						//System.out.println(m[i][j]);
						//System.out.println("After m[i][j]"+m[i][j]);
						//System.out.println("k "+k);
					}

					
				}
			}
		}
		/*
		for (int k=0;k<N+2;k++) {
			for (int i=0;i<N+2;i++) {
				for (int j=0;j<N+2;j++) {
					if ( m[i][k]+m[k][j] == m[i][j])
						System.out.println(m[i][j]);
						m[i][j] = m[i][k]+m[k][j];
						v[i][j] = k;
				}
			}
		}
		*/
		/*
		for (int diagonal=1;diagonal<N+2;diagonal++) { //diagonal limit는 보면서 계산 1부터 시작, 0대각선 1대각선은 미리 채워져 있는 상태
			for (int i=0;i<N+2-diagonal;i++) { // i도 보면서 계산-diagonal이 중요 0이나 1부터 시작, 0대각선 1대각선은 미리 채워져 있는 상태
				int j = i + diagonal; // j는 2대각선 부터 시작
				for (int k=i;k<=j;k++) { // k는 i부터 시작해서 j까지로 해야 가능한 인덱스 사이에서 성립, diagonal=1면 2대각선은 완벽하게 채우고 3,4,5,6,7대각선은 적당히 채움
										//diagonal=2이면 3대각선부터 채우기 시작하며 3대각선은 완벽하게 채우고 4,5,6 대각선은 대충 채움
										//diagonal=3이면 4대각선부터 채우기 시작하며 4대각선은 완벽하게 채우고 5,6대각선은 대충 채움
					if ( m[i][k]+m[k][j] < m[i][j])
						//System.out.println(d[0][0]);
						System.out.println("i "+i+" j "+j);
						System.out.println("before"+m[i][j]);
						System.out.println("m[i][k]+m[k][j] "+(m[i][k]+m[k][j]));
						//System.out.println("k "+k);
						m[i][j] = m[i][k]+m[k][j];
						//System.out.println("i "+i+" j "+j);
						//System.out.println(m[i][j]);
						System.out.println("After m[i][j]"+m[i][j]);
						//System.out.println("k "+k);
						v[i][j] = k;

						
				}
			}
		}
		*/

		
		/*
		System.out.println();
		System.out.println();
		
		for (int i=0;i<N+2;i++) {
			for (int j=0;j<N+2;j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
		*/
		/*
		
		for (int i=0;i<N+2;i++) {
			for (int j=0;j<N+2;j++) {
				System.out.print(v[i][j]+" ");
			}
			System.out.println();
		}
		
		*/
		System.out.println(m[0][N+1]);
		if (m[0][N+1]!=0) {
			printRouteV(0,N+1);
		}

		
		
	}
	
	public static void forfor() {
		
	}
	
	public static void printRouteV(int i, int j){
		if (v[i][j] !=-1 ) {
			printRouteV(i,v[i][j]);
			System.out.print(v[i][j]+" ");
			printRouteV(v[i][j],j);
		}
	}

}
