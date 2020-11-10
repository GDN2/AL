package swpackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KOI2003_J1 {
	
	static int input[][];
	static int matrix[][];
	static int weight[];
	static int visit[][];
	static int dp[][];
	static int answer[];
	
	static int N;
	static int cntLR[] = new int[3];
	static int cntUD[] = new int[3];
	static int cntDI[] = new int[3];
	
	static int b = 1;
	static int w = 2;
	
	static ArrayList<Integer> al = new ArrayList<>();
	static ArrayList<Integer> bl = new ArrayList<>();
	static ArrayList<Integer> cl = new ArrayList<>();
	static ArrayList<Integer> dl = new ArrayList<>();
	
	static boolean LRtf = false;
	static boolean UDtf = false;
	static boolean DItf = false;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = 20;
		input = new int[N][N];
		answer = new int[2];
		for(int i=1;i<N;i++) {
			for(int j=1;j<N;j++) {
				input[i][j] = sc.nextInt();
			}
		}
		for(int i=1;i<N;i++) {
			for(int j=1;j<N;j++) {
				Arrays.fill(cntLR, 0);
				Arrays.fill(cntUD, 0);
				Arrays.fill(cntDI, 0);

				
				if(input[i][j]==b) {
					cntLR[b]++;
					cntUD[b]++;
					cntDI[b]++;
					findLR(i,j);
					Arrays.fill(visit, 0);
					findUD(i,j);
					Arrays.fill(visit, 0);
					findDI(i,j);
					Arrays.fill(visit, 0);
				}else if(input[i][j]==w) {
					cntLR[w]++;
					cntUD[w]++;
					cntDI[w]++;
					Arrays.fill(visit, 0);
					findUD(i,j);
					Arrays.fill(visit, 0);
					findDI(i,j);
					Arrays.fill(visit, 0);
				}
			}
		}
		
		
	}
	
	
	static void findLR(int m, int n) {
		visit[m][n]=1;
		int mm;
		int nn;
		for(int i=0;i<2;i++) {
			if(i==0) {
				mm = m;
				nn = n-1;
			}else {
				mm = m;
				nn = n+1;
			}

			
			if(mm<N&&mm>=0&&nn<N&&nn>=0) {
				if(visit[mm][nn]!=1) {
					if(input[mm][nn]==b) {
						cntLR[b]++;
						findLR(i,j);
					}else if(input[i][j]==w) {
						cntLR[w]++;
						cntUD[w]++;
						cntDI[w]++;
						Arrays.fill(visit, 0);
						findUD(i,j);
						Arrays.fill(visit, 0);
						findDI(i,j);
						Arrays.fill(visit, 0);
					}
					cntR++;
					findR(m,n+1);
				}

			}
		}

	}
	
	static void findUD(int m, int n) {
		if(m<N&&m>=0&&n<N&&n>=0) {
			
			cntD++;
			findR(m+1,n);
		}
	}
	
	static void findDI(int m, int n) {
		
		if(m<N&&m>=0&&n<N&&n>=0) {
			cntdi++;
			findR(m+1,n+1);
		}
	}

}
