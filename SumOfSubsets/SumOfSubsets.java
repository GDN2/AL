package sumofsubsets;
import java.util.Scanner;

public class SumOfSubsets {
	int initTotal = 0;
	int W;
	int[] w;
	boolean[] include;
	int n;
	
	public void SumOfSubsets(int W, int[] w ) {
		this.W = W;
		this.w = w;		
		this.n= w.length;
		include = new boolean[n];
		for(int i=1;i<n;i++) {
			this.initTotal += w[i]; 
			include[i]= false;
		}
	}
	
	public void Algorithm(int index, int weight, int total ) {
		if(promising(index, weight, total)) {
			if(weight==W) {
				for(int i=1;i<n;i++) {
						System.out.print(include[i]+" ");
				}
				System.out.println();
				for(int i=1;i<n;i++) {
					if(include[i])
						System.out.print(w[i]+" ");
				}
				System.out.println();
				return;
			}
			else {
				include[index+1] = true;
				Algorithm(index+1,weight+w[index+1],total-w[index+1]);
				include[index+1] = false;
				Algorithm(index+1,weight,total-w[index+1]);
			}
		}
	}
	
	public boolean promising(int index, int weight, int total) {
		return (weight + total >= W)&&(weight == W||weight + w[index+1] <= W);
	}
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("SumOfSubsets Argorithm Test\n");
		SumOfSubsets sumofsubsets = new SumOfSubsets();
		
		System.out.println("Enter the number of Items");
		int n = scan.nextInt();
		
		System.out.println("Enter the each weight of Items by non descending order");
		int[] w = new int[n+1];
		for(int i=1; i<=n; i++)
				w[i] = scan.nextInt();
		
		System.out.println("Enter the your back to be able to endure weight");
		int W= scan.nextInt();
		scan.close();

		sumofsubsets.SumOfSubsets(W, w);
		
		sumofsubsets.Algorithm(0, 0, sumofsubsets.initTotal);
		
	}

}
