package kruskal;
import java.util.Scanner;

public class Kruskal {
	
	int vertexNum;
	int edgeNum;
	Edge[] edge;
	Edge[] Fedge;
	DataStructure2 datastructure2;
	
	public void Kruskal(int vertexNum,int edgeNum) {
		this.vertexNum = vertexNum;
		this.edgeNum = edgeNum;
		edge = new Edge[edgeNum];
		Fedge = new Edge[vertexNum];
		datastructure2 = new DataStructure2();
		datastructure2.DataStructure2(vertexNum);
		
		for(int i=0;i<edgeNum;i++) {
			edge[i] = new Edge();
		}
		for(int i=0;i<vertexNum-1;i++) {
			Fedge[i] = new Edge();
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
	}
	
		public void quicksort(int low, int high) {
			if(high>low) {
				int pivotpoint = partition(low, high);
				quicksort(low, pivotpoint-1);
				quicksort(pivotpoint+1, high);
			}
		}
	
		public int partition(int low, int high) {
			int i,j;
			int pivotitem = edge[low].distance;
			j=low;
			for(i=low+1;i<=high;i++) {
				if(edge[i].distance < pivotitem) {
					j++;
					edge[0].AddEdge(edge[i].start, edge[i].end, edge[i].distance);
					edge[i].AddEdge(edge[j].start, edge[j].end, edge[j].distance);
					edge[j].AddEdge(edge[0].start, edge[0].end, edge[0].distance);					
				}
			}
			edge[0].AddEdge(edge[low].start, edge[low].end, edge[low].distance);
			edge[low].AddEdge(edge[j].start, edge[j].end, edge[j].distance);
			edge[j].AddEdge(edge[0].start, edge[0].end, edge[0].distance);
			return j;
		}
		
	public class DataStructure2{
		int n;
		Structure_u[] U;
		
		public class Structure_u{
			int parent;
			int depth;
		}
		public void DataStructure2(int n) {
			this.n = n;
			U = new Structure_u[n];
			for(int i=0;i<n;i++) {
				U[i] = new Structure_u();
			}
		}
		
		void makeset(int i) {
			U[i].parent = i;
			U[i].depth = 0;
		}
		int find(int i) {
			int j;
			j = i;
			while(U[j].parent!=j) {
				j = U[j].parent;
			}
			return j;
		}
		void merge(int p, int q) {
			if(U[p].depth == U[q].depth) {
				U[p].depth = U[p].depth+1;
				U[q].parent = p;
			}
			else if(U[p].depth < U[q].depth){
				U[p].parent = q;
			}
			else {
				U[q].parent = p;
			}
		}
		boolean equal(int p, int q) {
			if(p == q)
				return true;
			else
				return false;
		}
		void initial() {
			int i;
			for(i=1;i<n;i++) {
				makeset(i);
			}
		}
	}

	public void kruskal(){
		int count = 0;
		int k = 1;
		int i,j,r,p,q;
		quicksort(1, edgeNum-1);
		datastructure2.initial();
		while(count!=vertexNum-2) {
			r = edge[k].distance;
			i = edge[k].start;
			j = edge[k].end;
			p = datastructure2.find(i);
			q = datastructure2.find(j);
			if(!datastructure2.equal(p,q)) {
				datastructure2.merge(p,q);
				count++;
				Fedge[count].AddEdge(i, j, r);
			}
			k++;
		}
		
	}
		
	public static void main(String[] args) {
		int start, end, distance;
		Scanner scan = new Scanner(System.in);
		System.out.println("Kruskal Algorithm Test\n");
		Kruskal kruskal = new Kruskal();

		System.out.println("Enter VertexNumber n");
		int N = scan.nextInt()+1;
		System.out.println("Enter EdgeNumber n");
		int M = scan.nextInt()+1;
		kruskal.Kruskal(N,M);
		
		System.out.println("Enter All Edge <- Start, End, Distance");
		for(int i=1; i<M; i++) {
			start = scan.nextInt();
			end = scan.nextInt();
			distance = scan.nextInt();
			kruskal.edge[i].AddEdge(start, end, distance);
		}
		scan.close();
		
		
		for(int i=1;i<M;i++) {
			kruskal.edge[i].EdgePrint();
		}
		System.out.print("<- Edge 출력" );
		System.out.println();
					
		kruskal.kruskal();
		for(int i=1;i<M;i++) {
			kruskal.edge[i].EdgePrint();
		}
		System.out.print("<- quicksort 후 Edge 출력" );
		System.out.println();
		
		for(int i=1;i<N-1;i++) {
			kruskal.Fedge[i].EdgePrint();
		}
		System.out.print("<- Kruskal알고리즘 후 Edge 출력" );
	}
}
