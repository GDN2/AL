package swpackage;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class KOI1998_J3 {
	
	static int[][] input;
	static int[][] visit;
	
	static int[][] matrix;

	static int[][] ij = new int[4][2];
	static int[] components = new int[5];
	
	static int[] dx = {1,0,-1,0}; // j+dx;
	static int[] dy = {0,-1,0,1}; // i+dy;
	
	static int N;
	static int icnt;
	static int jcnt;
	static int temp;
	static int cnt;
	
	static ArrayList<Integer> al = new ArrayList<>();
	static ArrayList<Integer> bl = new ArrayList<>();
	static ArrayList<int[][]> ijl = new ArrayList<>();
	static ArrayList<int[]> cl = new ArrayList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		input = new int[N][N];
		visit = new int[N][N];
		
		for (int i=0;i<5;i++) {
			 components[i] = scanner.nextInt();
		}
		cl.add(components);
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				input[i][j] = scanner.nextInt();
			}
		}
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}
	
		int[][] aa = {{1,1},{2,2},{3,3},{4,4}};
		ijl.add(aa);
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				if (input[i][j] == 1 && visit[i][j]==0 && cnt < 3) {
					//모양에 따라 4개 좌표 정확하게 다 구해줄 것
					cnt ++ ;
					icnt = 0;
					jcnt = 0;
					
					for(int mm=0;mm<4;mm++) {
						for (int nn=0;nn<2;nn++) {
							System.out.print(ij[mm][nn]+" ");
						}
					}
					
					ij[0][0] = i;
					ij[0][1] = j;
					
					findDown(i,j);
					ij[1][0] = i+icnt;
					ij[1][1] = j;
					icnt = 0;

					
					findRight(i,j);
					ij[2][0] = i;
					ij[2][1] = j+jcnt;
					temp = jcnt;
					jcnt = 0;
					
					findDown(i,j+temp);
					ij[3][0] = i+icnt;
					ij[3][1] = j+temp;
					

					System.out.println("CHECK");
					for(int mm=0;mm<4;mm++) {
						for (int nn=0;nn<2;nn++) {
							System.out.print(ij[mm][nn]+" ");
						}
						System.out.println();
					}
					System.out.println("CHECK");
					
					ijl.add(ij);
					for (int[][] m: ijl) {
						System.out.println(m[0][0]+" "+m[0][1]+" "+m[1][0]+" "+m[1][1]+" "+m[2][0]+" "+m[2][1]+" "+m[3][0]+" "+m[3][1]);

					}
					
					System.out.println(ijl.get(1)[0][0]);
					
					icnt = (ij[1][0] - ij[0][0] >= ij[3][0]-ij[2][0]) ? ij[1][0] - ij[0][0] : ij[3][0]-ij[2][0];
					temp = (ij[2][1]-ij[0][1] >= ij[3][1]-ij[1][1]) ? ij[2][1]-ij[0][1] : ij[3][1]-ij[1][1];
					visitsquare(i, j, icnt, temp);
					
				}
			}
		}
		
		
		for (int[][] i: ijl) {
			System.out.println(i[0][0]+" "+i[0][1]+" "+i[1][0]+" "+i[1][1]+" "+i[2][0]+" "+i[2][1]+" "+i[3][0]+" "+i[3][1]);

		}

	}
	
	public static void findij(int m, int n){
		visit[m][n] = 1;
		for (int i=0;i<4;i++) {
			int nm = m+dy[i];
			int nn = n+dx[i];
			//이걸 한 방향(아래, 오른쪽)으로만 하면 될 듯, 그 후에 좌표 잡고 해당 좌표 지역 전부 visit = 1로 만들어주세요!, 좌표는 ijl로 넘겨주세요!
			if(nm<0&&nn<0&&nm>=N&&nn>=N&&visit[m][n]!=1&&input[nm][nn]==1) {
				icnt++;
				findij(nm,nn);
			}
		}
	}
	
	public static void findDown(int m, int n){
		visit[m][n] = 1;
		
		int nm = m+1;
		int nn = n+0;
		if(nm>=0&&nn>=0&&nm<N&&nn<N&&visit[nm][nn]!=1&&input[nm][nn]==1) {
			icnt++;
			findDown(nm,nn);
		}
	}
	
	public static void findRight(int m, int n){
		visit[m][n] = 1;
		
		int nm = m+0;
		int nn = n+1;
		if(nm>=0&&nn>=0&&nm<N&&nn<N&&visit[nm][nn]!=1&&input[nm][nn]==1) {
			jcnt++;
			findRight(nm,nn);
		}
	}
	
	public static void visitsquare(int m, int n, int isize, int jsize) {
		for (int i=m;i<=m+isize;i++) {
			for (int j=n;j<=n+jsize;j++) {
				if(visit[i][j]!=1) {
					visit[i][j]=1;
				}
			}
		}
	}

}
