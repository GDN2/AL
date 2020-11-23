package optiamlseachtree;
import java.util.Scanner;

public class OptimalSearchTree {
	
	double minavg;
	int[][] R;
	double[][] A;
/*	
	public class Node {//tree를 만들기 위한 노드 용, 사용되지 않음
		Object data;
		Node left;
		Node right;		
	}
*/	
	void OST(double[] p) {
		int n = p.length-1;
		int i,j,k,m,diagonal;
		double sigmaP=0; //sigmaP는 p행렬 값 넣기 위함
		double[][] A= new double[n+2][n+2];//index [1~n+1][0~n]
		int[][] R= new int[n+2][n+2];//index [1~n+1][0~n]
		this.A = A;
		this.R = R;
		
		for(i=1;i<=n;i++){
			A[i][i-1]=0;
			A[i][i]=p[i];
			R[i][i-1]=0;
			R[i][i]=i;			
		}
		A[n+1][n]=0;
		R[n+1][n]=0;
		for(diagonal=1;diagonal<=n-1;diagonal++) {
			for(i=1;i<=n-diagonal;i++) {
				j = i+diagonal;
				for(m=i;m<=j;m++) {
					sigmaP += p[m];
				}
				for(k=i;k<=j;k++) {

					if((A[i][j]==0)||(A[i][k-1]+A[k+1][j]+sigmaP<A[i][j])) {
						A[i][j]=A[i][k-1]+A[k+1][j]+sigmaP;
						R[i][j]=k;
					}
				}
				sigmaP=0;
			}
		}
		
		this.minavg = A[1][n];
		
	}
		
		int[][] getR(){
			return R;
		}
		double[][] getA(){
			return A;
		}
		double getminavg() {
			return minavg;
		}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("OptimalSearchTree");
		
		System.out.println("Input the number of Items");
		int N = scan.nextInt();
		
		System.out.println("Input the percentage of each Item");
		double[] p = new double[N+1];
		for(int i=1;i<=N;i++) {
			p[i] = scan.nextDouble();
		}
		
		double[][] A = new double[N+2][N+2];
		int[][] R = new int[N+2][N+2];
		
		OptimalSearchTree Ost = new OptimalSearchTree();
		Ost.OST(p); 
		double minavg = Ost.getminavg();
		A = Ost.getA();
		R = Ost.getR();
		
		System.out.println("Minimum Search Time Matrix A");
		for(int i=1;i<=N+1;i++) {
			for(int j=0;j<=N;j++) {
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Root Matrix R");
		for(int i=1;i<=N+1;i++) {
			for(int j=0;j<=N;j++) {
				System.out.print(R[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("The minimum searchime avarage of All Trees is "
				+minavg);
		
	}

}
