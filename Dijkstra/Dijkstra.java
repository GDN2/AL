package dijkstra;
import java.util.Scanner;

public class Dijkstra {

	int n;
	int touch[];
	int length[];
	int W[][];
	Edge F[];
	
	public void Dijkstra(int[][] W) {

		this.n = W.length;
		this.W = new int[n][n];
		this.W = W;
		
		this.touch = new int[n];
		this.length = new int[n];
		this.F = new Edge[n-1];
		for(int i=0;i<n-1;i++) {
			F[i] = new Edge();
		}
	}
	
	public class Edge{
		int start;
		int end;
		int distance;
		
		public void AddEdge(int start,int end, int distance) {
			this.start=start;
			this.end=end;
			this.distance=distance;
		}
		public void EdgePrint() {
			System.out.print("("+start+" "+end+" "+distance+") ");
		}
		public void EdgePrint2() {
			System.out.print("("+start+", "+end+", "+distance+") ");
		}
	}
	
	public void dijkstra() {
		int count = 0;
		for(int i=2;i<=n-1;i++) {
			touch[i]=1;
			length[i]=W[1][i];
		}
		while(count!=n-2) {
			int min = 999;
			int vnear = 0;
			for(int i=2;i<=n-1;i++) {
				if(0<=length[i]&&length[i]<min) {
					min = length[i];
					vnear = i;
				}
			}
			count++;
			F[count].AddEdge(touch[vnear], vnear, length[vnear]);
			for(int i=2;i<=n-1;i++) {
				if(length[vnear]+W[vnear][i]<length[i]) {
					length[i] = length[vnear] + W[vnear][i];
					touch[i] = vnear;
				}
			}
			length[vnear]=-1;
		}
	}
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Dijkstra Algorithm Test\n");
		Dijkstra dijkstra = new Dijkstra();
		
		System.out.println("Enter order n of W of Distance");
		int N = scan.nextInt()+1;
		
		System.out.println("Enter n order matrix W of Distance");
		int[][] W = new int[N][N];
		for(int i=1; i<=N-1; i++)
			for(int j=1; j<=N-1; j++)
				W[i][j] = scan.nextInt();
		scan.close();
				
		dijkstra.Dijkstra(W);
		dijkstra.dijkstra();
		
		System.out.println("Shorteast Faths");
		System.out.println("(start, end, Shortest Distance from Vertex 1 to end)");
	
		for(int i=1;i<=N-2;i++) {
			dijkstra.F[i].EdgePrint2();
		}
	}

}
