package swpackage;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class KOI1997_J3 {
	
	static int matrix[][];
	
	static int rmatrix[][];
	static int visit[][];
	
	static int max[];
	
	static int N;
	static int cnt;
	static int tempcnt;
	
	static int left;
	static int right;
	
	
	static ArrayList<Integer> al = new ArrayList<>();
	static ArrayList<Integer> bl = new ArrayList<>();
	static ArrayList<Integer> cl = new ArrayList<>();
	static ArrayList<Integer> maxlist = new ArrayList<>();
	static ArrayList<Integer> leftlist = new ArrayList<>();
	static ArrayList<Integer> rightlist = new ArrayList<>();
	static ArrayList<Integer> cheflist = new ArrayList<>();
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		rmatrix = new int[N+1][N+1];
		visit = new int[N+1][N+1];
		max = new int[N+1];
		do {
			left = scanner.nextInt();
			right = scanner.nextInt();
			
			if(left !=-1 && right!=-1) {
				leftlist.add(left);
				rightlist.add(right);
				
			}
			
		}	while(left != -1 && right != -1);

		matrix = new int[leftlist.size()][2];
		for (int i=0;i<leftlist.size();i++) {
			matrix[i][0] = leftlist.get(i);
			matrix[i][1] = rightlist.get(i);
		}
		
		/*
		for (int i=0;i<matrix.length;i++) {
			System.out.println(matrix[i][0]+" "+matrix[i][1]);
		}
		
		*/
		for (int i=0;i<matrix.length;i++) {
			rmatrix[matrix[i][0]][matrix[i][1]] = 1;
			rmatrix[matrix[i][1]][matrix[i][0]] = 1;
		}
		
		for (int i=1;i<=N;i++) {
			for (int j=1;j<=N;j++) {
				if(i==j) {
					rmatrix[i][i]=1;
				}
			}
		}
		
		
		for (int i=1;i<=N;i++) {
			for (int j=1;j<=N;j++) {
				System.out.print(rmatrix[i][j]);
			}
			System.out.println();
		}
		
		
		for (int i=1;i<=N;i++) {
			for (int j=1;j<=N;j++) {
				cnt = 0;
				visitInitialize(); // visit초기화
				if (rmatrix[i][j] == 0) {
					find(i,j,0);
					tempcnt = cnt;
					find(j,i,0);
					if (tempcnt<cnt) {
						rmatrix[i][j] = tempcnt;
						rmatrix[j][i] = tempcnt;
					}else {
						rmatrix[i][j] = cnt;
						rmatrix[j][i] = cnt; // find()가 i<한 방향으로만 가능하도록 하기 때문에 대각선 기준으로 나머지는 0으로 되버리기 때문에 대칭으로 만들어 줌
					}

				}
			}
		}
		
		System.out.println();
		
		for (int i=1;i<=N;i++) {
			for (int j=1;j<=N;j++) {
				System.out.print(rmatrix[i][j]);
			}
			System.out.println();
		}
		
		
		for (int i=1;i<=N;i++) {
			for (int j=1;j<=N;j++) {
				if (rmatrix[i][j] > max[i]) {
					max[i] = rmatrix[i][j];
				}
			}
			//System.out.println(max[i]);
			maxlist.add(max[i]);
		}
		
		for (int i=0;i<maxlist.size();i++) {
			if (maxlist.get(i) == Collections.min(maxlist)) {
				cheflist.add(i+1);
			};
		}
		
		//출력
		System.out.print(Collections.min(maxlist)+" ");
		System.out.println(cheflist.size());
		for (int i: cheflist) {
			System.out.print(i+" ");
		}
		
		
		
	
	}
	
	public static void find(int x, int y, int localcnt) {
		
		visit[x][y] = 1;
		visit[y][x] = 1;//반복해서 재방문할 필요가 있음 그래서 visit[]는 필요없음
			
		if(rmatrix[x][y] == 1) {
			if ((cnt == 0) || (cnt > localcnt+1)) {
				cnt = localcnt+1;
			}
			
			//visit[x][y] = 0; // 재방문할 필요가 있는 곳은 0으로 해줌 //근데 이거 별로 쓸모 없음
			//visit[y][x] = 0;
			
		}else{
			for(int i=1;i<=N;i++) {
				if(rmatrix[x][i]==1&&x!=i&&visit[y][i]==0) { //visit[]를 없앴으니 무한루프가 발생한다 여기서 x<i일 때만 루프를 돌도록 해서 자동으로 끊기게 만들어 놓음 관계는 양방향으로 이어져 있으니 순서는 상관없고 한 방향으로만 뽑아서 해도 됨
					find(i,y,localcnt+1);
					//if (x==3) {
					//	System.out.println(x+" "+y+" "+i);
					//}
				}

			}
			/*
			for(int i=N;i>=1;i--) {
				if(rmatrix[x][i]==1&&x!=i&&visit[i][y]==0) {
					find(i,y,localcnt+1);
					//if (x==3) {
					//	System.out.println(x+" "+y+" "+i);
					//}
				}

			}
			*/
		}
		
	}
	
	public static void visitInitialize() {
		for(int i=1;i<=N;i++) {
			for (int j=1;j<=N;j++) {
				visit[i][j] = 0;
				visit[j][i] = 0;
			}
		}
	}
	
	
	
	
}
