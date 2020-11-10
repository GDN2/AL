package swpackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;



public class KOI2001_J1 {
	
	static int input[][];
	static int visit[][];
	static int matrix[][];
	
	static int N;
	static int cnt;
	static int height;
	static int width;
	static int horizon = 0;
	static int vertical = 1;
	
	static ArrayList<Integer> al = new ArrayList<>();
	static ArrayList<Integer> areal = new ArrayList<>();
	static ArrayList<Integer> hl = new ArrayList<>();
	static ArrayList<Integer> vl = new ArrayList<>();


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		width = scanner.nextInt();
		height = scanner.nextInt();
		N = scanner.nextInt();
		input = new int[N][2];
		matrix = new int[height+1][width+1];
		visit = new int[height+1][width+1];
		for(int i=0;i<N;i++) {
			for(int j=0;j<2;j++) {
				input[i][j] = scanner.nextInt();
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<2;j++) {
				if(input[i][0]==horizon) {
					hl.add(input[i][1]);
				}else {
					vl.add(input[i][1]);
				}
			}
		}
		Collections.sort(hl);
		Collections.sort(vl);
		areaCalculation(0,0);
		/*
		for (int i: areal) {
			System.out.println(i);
		}
		*/
		System.out.println(Collections.max(areal));
	}
	
	public static void areaCalculation(int m, int n) {
		visit[m][n] = 1;
		int mm = height;
		int nn = width;
		int area;
		boolean htf = false;
		boolean vtf = false;
		
		for(int i=0;i<hl.size();i++) {
			if(hl.get(i)>m) {
				htf = true;
				mm = hl.get(i); 
				break;
			}else {
				mm = height;
			}
		}
		for(int i=0;i<vl.size();i++) {
			if(vl.get(i)>n) {
				vtf = true;
				nn = vl.get(i); 
				break;
			}else {
				nn = width;
			}
		}
		//System.out.printf("m %d n %d mm %d nn %d\n", m,n,mm,nn);
		
		area = (mm-m) * (nn - n);
		areal.add(area);
		
		if(htf&&visit[mm][n]==0) {
			areaCalculation(mm, n);
		}
		
		if(vtf&&visit[m][nn]==0) {
			areaCalculation(m,nn);
		}
		
		
		
	}

}
