package swpackage;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class JO1996_1 {
	
	static int matrix[][];
	static int visit[][];
	
	static int N;
	static int cnt;
	
	static int[] dx = {1,0,-1,0};
	static int[] dy = {0,-1,0,1};
	
	static ArrayList al = new ArrayList();
	

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		matrix = new int[N][N];
		visit = new int[N][N];
		
		for (int i=0;i<N;i++) {
			String line = scanner.next();
			for (int j=0;j<N;j++) {
				matrix[i][j] = line.charAt(j) - '0';
			}
		}
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				if (matrix[i][j] == 1 && visit[i][j] == 0) {
					cnt = 1;
					find(i,j);
					al.add(cnt);
				}

			}
		}
		Collections.sort(al);
		System.out.println(al.size());
		
		for (int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}
		
	}
	
	public static void find(int x, int y) {
		visit[x][y] = 1;
		for (int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if (nx>=0&&ny>=0&&nx<N&&ny<N) {
				if (matrix[nx][ny]==1 && visit[nx][ny]==0) {
					find(nx,ny);
					cnt++;
				}

			}
			
			
		}
		
	}

}
