package swpackage;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class KOI1998_J3C {
	
	static int[][] input;
	static int[][] visit;
	
	static int[][] matrix;

	static int[][] ij = new int[4][2];
	static int[] components = new int[6];
	static int[][] figure1;
	static int[][] figure2;
	static int[][] figure3;
	static int[][] figure4;
	
	static int[] dx = {1,0,-1,0}; // j+dx;
	static int[] dy = {0,-1,0,1}; // i+dy;
	
	static int N;
	static int icnt;
	static int jcnt;
	static int temp;
	static int cnt;
	static int NN;
	
	static boolean match = false;
	
	static ArrayList<Integer> al = new ArrayList<>();
	static ArrayList<Integer> bl = new ArrayList<>();
	static ArrayList<int[][]> ijl = new ArrayList<>();
	static ArrayList<int[]> mnl = new ArrayList<>();
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
		components[5] = components[0]-components[2]-components[4];
		cl.add(components);
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				input[i][j] = scanner.nextInt();
			}
		}
		
		figure1 = make1(components);
		figure2 = make2(components);
		figure3 = make3(components);
		figure4 = make4(components);
		
		/*
		for (int i=0;i<figure1.length;i++) {
			for (int j=0;j<figure1[0].length;j++) {
				System.out.print(figure1[i][j]+" ");
			}
			System.out.println();
		}
		
		for (int i=0;i<figure2.length;i++) {
			for (int j=0;j<figure2[0].length;j++) {
				System.out.print(figure2[i][j]+" ");
			}
			System.out.println();
		}
		
		for (int i=0;i<figure3.length;i++) {
			for (int j=0;j<figure3[0].length;j++) {
				System.out.print(figure3[i][j]+" ");
			}
			System.out.println();
		}
		for (int i=0;i<figure4.length;i++) {
			for (int j=0;j<figure4[0].length;j++) {
				System.out.print(figure4[i][j]+" ");
			}
			System.out.println();
		}
		
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
		}
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				
			}
		}
		*/
	
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				matching(i,j, figure1, 1);
				matching(i,j, figure2, 2);
				matching(i,j, figure3, 3);
				matching(i,j, figure4, 4);
			}
		}
		
		System.out.println(mnl.size());
		for(int[] i: mnl) {
			System.out.println(i[0]+" "+i[1]);
		}
		

	}
	
	public static boolean matching(int m, int n, int[][] figure, int figurenum) {
		boolean TF = true;
		boolean TF2 = true;
		int a = 1;
		cnt = 0;
		int mm;
		int nn;
		int mm2;
		int nn2;
		int area = figure.length * figure[0].length;
		for (int i=0;i<figure.length;i++) {
			for (int j=0;j<figure[0].length;j++) {
				mm = i+m;
				nn = j+n;
				
				if (mm>=0&&nn>=0&&mm<N&&nn<N) {
					a = (input[mm][nn]^figure[i][j]);
					if (a==0) {
						cnt++;
					}
				} else {

				}
			}
		}
		
		if(figurenum == 1) {
			mm = m;
			nn = n-1;
			mm2 = m;
			nn2 = n+components[0];
			if (mm>=0&&nn>=0&&mm<N&&nn<N) {
				if(input[mm][nn]==1) {
					TF=false;
				}else {
					TF = true;
				}
				
			}
			if(mm2>=0&&nn2>=0&&mm2<N&&nn2<N) {
				if(input[mm2][nn2]==1) {
					TF2 = false;
				}else {
					TF2 = true;
				}
			}

			
		}else if(figurenum == 2) {
			mm = m-1;
			nn = n;
			mm2 = m+components[0];
			nn2 = n;
			if (mm>=0&&nn>=0&&mm<N&&nn<N) {
				if(input[mm][nn]==1) {
					TF=false;
				}else {
					TF = true;
				}
				
			}
			if(mm2>=0&&nn2>=0&&mm2<N&&nn2<N) {
				if(input[mm2][nn2]==1) {
					TF2 = false;
				}else {
					TF2 = true;
				}
			}

		}else if(figurenum == 3) {
			mm = m+components[1];
			nn = n-1;
			mm2 = m+components[1];
			nn2 = n+components[0];
			if (mm>=0&&nn>=0&&mm<N&&nn<N) {
				if(input[mm][nn]==1) {
					TF=false;
				}else {
					TF = true;
				}
				
			}
			if(mm2>=0&&nn2>=0&&mm2<N&&nn2<N) {
				if(input[mm2][nn2]==1) {
					TF2 = false;
				}else {
					TF2 = true;
				}
			}

		}else if(figurenum == 4) {
			mm = m-1;
			nn = n+components[1];
			mm2 = m+components[0];
			nn2 = n+components[1];
			if (mm>=0&&nn>=0&&mm<N&&nn<N) {
				if(input[mm][nn]==1) {
					TF=false;
				}else {
					TF = true;
				}
				
			}
			if(mm2>=0&&nn2>=0&&mm2<N&&nn2<N) {
				if(input[mm2][nn2]==1) {
					TF2 = false;
				}else {
					TF2 = true;
				}
			}

		}
		


				
		
		if (cnt == area && TF == true && TF2 == true) {
			int[] mn = new int[2];
			
			switch (figurenum) {
				case 1:
					mn[0] = m+1;
					mn[1] = n+1;
					break;
				case 2:
					NN = n;
					simplemake2(m,NN);
					mn[0] = m+1;
					mn[1] = NN+1;
					break;
				case 3:
					mn[0] = m+1+components[1];
					mn[1] = n+1;
					break;
				case 4:
					mn[0] = m+1;
					mn[1] = n+1+components[1];
					break;
				default:
				
			}
			
			mnl.add(mn);
			//System.out.println(" mn[0] "+mn[0]+" mn[1] "+ mn[1] );
		}
		
		return TF;
	}
	public static void simplemake2(int m,int n) {
		int mm = m;
		int nn = n-1;
		if (nn>=0&&nn<N) {
			if(input[mm][nn]==1) {
				NN--;
				simplemake2(mm,NN);
			}
		}
		

	}
	
	public static int[][] make1(int[] c) {
		int width = c[0];
		int height = c[1] + c[3] + 1;
		int[][] figure1 = new int[height][width];
		int[] compare = new int[c[0]];
		
		for (int i=c[2];i<c[0]-c[5];i++) {
			compare[i] = 1;
		}
		
		for (int i=0;i<height;i++) { //1로 다채워주기
			for (int j=0;j<width;j++) {
				figure1[i][j] = 1;
			}
		}
		
		for (int i=height-1;i>c[3];i--) { // 밑변 비우기
			for (int j=0;j<width;j++) {
				figure1[i][j] = 0;
			}
		}
		
		for (int i=1;i<=c[3];i++) { // 중간 비우기 1 0 -> 1, 1 1 -> 0 ^&|
			for (int j=0;j<width;j++) {
				figure1[i][j] = (figure1[i][j]^compare[j])&(figure1[i][j]|compare[j]);
			}
		}
		
		return figure1;
	}
	
	public static int[][] make33(int[][] figure1){
		int[][] figure = new int[figure1.length][figure1[0].length];
		for (int i=0;i<figure1.length;i++) {
			for (int j=0;j<figure1[0].length;j++) {
				figure[i][j] = (figure1[i][j]==0) ? 1 : 0;

				
			}
		}
		
		return figure;
	}
	
	public static int[][] make2(int[] c) {
		int height = c[0];
		int width = c[1] + c[3] + 1;
		int[][] figure1 = new int[height][width];
		int[][] compare = new int[c[0]][1];
		
		for (int i=c[0]-1-c[2];i>=c[5];i--) {
			compare[i][0] = 1;
		}
		
		for (int i=0;i<height;i++) { //1로 다채워주기
			for (int j=0;j<width;j++) {
				figure1[i][j] = 1;
			}
		}
		
		for (int i=0;i<c[0];i++) { // 오른쪽변 비우기
			for (int j=width-1;j>c[3];j--) {
				figure1[i][j] = 0;
			}
		}
		
		for (int i=0;i<height;i++) { // 중간 비우기 1 0 -> 1, 1 1 -> 0 ^&|
			for (int j=c[3];j>=1;j--) {
				figure1[i][j] = (figure1[i][j]^compare[i][0])&(figure1[i][j]|compare[i][0]);

			}
		}
		
		return figure1;
	}
	
	public static int[][] make4(int[] c) {
		int height = c[0];
		int width = c[1] + c[3] + 1;
		int[][] figure1 = new int[height][width];
		int[][] compare = new int[c[0]][1];
		
		for (int i=c[2];i<c[0]-c[5];i++) {
			compare[i][0] = 1;
		}
		
		for (int i=0;i<height;i++) { //1로 다채워주기
			for (int j=0;j<width;j++) {
				figure1[i][j] = 1;
			}
		}
		
		for (int i=0;i<c[0];i++) { // 왼쪽변 비우기
			for (int j=0;j<c[1];j++) {
				figure1[i][j] = 0;
			}
		}
		
		for (int i=0;i<height;i++) { // 중간 비우기 1 0 -> 1, 1 1 -> 0 ^&|
			for (int j=c[1];j<width-1;j++) {
				figure1[i][j] = (figure1[i][j]^compare[i][0])&(figure1[i][j]|compare[i][0]);
			}
		}
		
		return figure1;
	}
	
	
	public static int[][] make3(int[] c) {
		int width = c[0];
		int height = c[1] + c[3] + 1;
		int[][] figure1 = new int[height][width];
		int[] compare = new int[c[0]];
		
		for (int i=c[0]-c[2]-1;i>=c[5];i--) {
			compare[i] = 1;
		}
		
		for (int i=0;i<height;i++) { //1로 다채워주기
			for (int j=0;j<width;j++) {
				figure1[i][j] = 1;
			}
		}
		
		for (int i=0;i<height-c[3]-1;i++) { // 윗변 비우기
			for (int j=0;j<width;j++) {
				figure1[i][j] = 0;
			}
		}
		
		for (int i=height-2;i>=c[1];i--) { // 중간 비우기 1 0 -> 1, 1 1 -> 0 ^&|
			for (int j=0;j<width;j++) {
				figure1[i][j] = (figure1[i][j]^compare[j])&(figure1[i][j]|compare[j]);
				//System.out.print("figure1[i][j]"+figure1[i][j]+" "+"compare[j]"+compare[j]);
			}
		}
		
		return figure1;
	}
	
	public static void find1(int m, int n, int[] c) {
		
		for (int i=0;i<=c[1]+c[3];i++) {
			for (int j=0;j<=c[0];j++) {
				if(m+i>=0&&n+j>=0&&m+i<N&&n+j<N) {
					if(i==0) {
						if(input[m][n+j]!=1);
					}
				}

			}
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
