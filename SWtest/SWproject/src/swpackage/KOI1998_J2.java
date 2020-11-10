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
			
		//������ȹ ���� ä���� �� �ִ� ��(�Ÿ� 140����)�� �� ä����, i=j�� ���� i=j-1�� ���� �̹� ä���� ������ ��
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
						//m[i][j] = m[i][k] + m[k][j]; ���� �ּ� ���� ��� �ڵ�� �� ������ �� ��/ ������ ���� if���� {}�� ������!
						//�׷��Ƿ�  {}�� ������ ���� �ش� ���ǿ��� m[i][j] = m[i][k] + m[k][i];�� {}���� if �ٷ� �ڿ� ������ ����� ��
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
		for (int diagonal=1;diagonal<N+2;diagonal++) { //diagonal limit�� ���鼭 ��� 1���� ����, 0�밢�� 1�밢���� �̸� ä���� �ִ� ����
			for (int i=0;i<N+2-diagonal;i++) { // i�� ���鼭 ���-diagonal�� �߿� 0�̳� 1���� ����, 0�밢�� 1�밢���� �̸� ä���� �ִ� ����
				int j = i + diagonal; // j�� 2�밢�� ���� ����
				for (int k=i;k<=j;k++) { // k�� i���� �����ؼ� j������ �ؾ� ������ �ε��� ���̿��� ����, diagonal=1�� 2�밢���� �Ϻ��ϰ� ä��� 3,4,5,6,7�밢���� ������ ä��
										//diagonal=2�̸� 3�밢������ ä��� �����ϸ� 3�밢���� �Ϻ��ϰ� ä��� 4,5,6 �밢���� ���� ä��
										//diagonal=3�̸� 4�밢������ ä��� �����ϸ� 4�밢���� �Ϻ��ϰ� ä��� 5,6�밢���� ���� ä��
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
