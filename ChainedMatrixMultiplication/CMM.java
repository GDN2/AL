package CMM;
import java.util.Scanner;

public class CMM {
	
	int[][] M;
	int[][] P;

	public int MM(int[] d) {		
		int n = d.length-1; //n=��� ����, d�� 0���� �����ϹǷ� d���� 1����
		int[][] M = new int[n+1][n+1];//index 1���� �����ҰŶ� �ϳ� ũ�� �������
		int[][] P = new int[n+1][n+1];//index 1���� �����ҰŶ� �ϳ� ũ�� �������
		this.M = M;
		this.P = P;
		int i,j,k,diagonal;
		
		for(i=1; i<=n; i++) {
			M[i][i]=0;
		}
		for(diagonal=1; diagonal<=n-1; diagonal++) {
			for(i=1; i<=n-diagonal; i++) {
				j = i+diagonal;
				for(k=i;k<=j-1;k++) {
					if((M[i][j]==0)||(M[i][k]+M[k+1][j]+d[i-1]*d[k]*d[j]<M[i][j])) {
						/*Floyd Algorithm�� �޸� �ʱⰪ�� 0���� �����Ǿ� �ֱ⶧���� 0�� ���� ���� ���� �ȴ� ����
						 *0�� ��쿡�� �����ϰ� ������ ���� �ٲ�ġ�쵵�� �Ѵ�.*/
						M[i][j]=M[i][k]+M[k+1][j]+d[i-1]*d[k]*d[j];
						P[i][j]=k;
					}
				}
			}
		}
		return M[1][n];
	}

	public int[][] getM(){
		return M;
	}
	public int[][] getP(){
		return P;
	}
	
	public void order(int i, int j) {
		if(i==j)
			System.out.print("A"+i);
		else {
			int k = this.P[i][j];
			System.out.print("(");
			order(i,k);
			order(k+1,j);
			System.out.print(")");
		}
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Minimum Chained Matrix Multiplication");
		CMM cmm = new CMM();
		
		System.out.println("Input Length of Array d");
		int n = scan.nextInt()-1;
		
		System.out.println("Input Element of Array d");
		int[][] M = new int[n+1][n+1];
		int[][] P = new int[n+1][n+1];
				
		int[] d = new int[n+1];
		for(int i=0; i<=n; i++) {
			d[i]=scan.nextInt();
		}
		
		
		int Answer = cmm.MM(d);
		System.out.println("Minimum CMM is " + Answer);
		M = cmm.getM();
		P = cmm.getP();
		
		System.out.println("Matrix M - Minimum Chained Matrix Multiplication");
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(M[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("Matrix P - For order of Minimum CMM ");
		for(int i=1; i<=n-1; i++) {
			for(int j=1; j<=n; j++) {
				System.out.print(P[i][j]+" ");
			}
			System.out.println();
		}
		
		cmm.order(1,n);
	}

}
