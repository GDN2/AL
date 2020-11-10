package swpackage;

import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class KOI2000_J3 {
	
	public static int[][] input;
	public static int[][] visit;
	
	public static int[] matrix;
	
	public static int N;
	public static int height;
	public static int width;
	public static int cnt;
	public static int zerocnt;
	public static int c = -1;
	public static int time;
	public static int decaycnt;
	
	public static ArrayList<int[][]> al = new ArrayList<>();
	public static ArrayList<int[][]> bl = new ArrayList<>();
	public static ArrayList<Integer> decayl = new ArrayList<>();
	
	public static int[] di = {0,1,0,-1};
	public static int[] dj = {1,0,-1,0};
	
	public static boolean notAllZero = true;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		height = scanner.nextInt();
		width = scanner.nextInt();
		input = new int[height][width];
		visit = new int[height][width];
		for (int i=0;i<height;i++) {
			for (int j=0;j<width;j++) {
				input[i][j] = scanner.nextInt();
			}
		}
		
		possibleVisitZone(0,0);
		
		/*
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				System.out.printf("%2d ", input[i][j]);
			}
			System.out.println();
		}
		
		
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				System.out.print(visit[i][j]+" ");
			}
			System.out.println();
		}
		*/
		
		
		while(notAllZero) {
			
			decay();
			visitClear();
			possibleVisitZone(0, 0);
			
			notAllZero = notAllZeroCheck();
			/*
			for(int i=0;i<height;i++) {
				for(int j=0;j<width;j++) {
					System.out.printf("%2d ", input[i][j]);
				}
				System.out.println();
			}
			*/
		}
		System.out.println(time);
		System.out.println(decayl.get(decayl.size()-1));
		
		
		
		// TODO Auto-generated method stub

	}

	public static void possibleVisitZone(int m, int n) {
		visit[m][n] = 1;
		
		for(int i=0;i<4;i++) {
			int mm = m+di[i];
			int nn = n+dj[i];
			
			if(mm>=0&&mm<height&&nn>=0&&nn<width) {
				if(visit[mm][nn]==0) {
					if(input[mm][nn]==0) {
						possibleVisitZone(mm,nn);
					}else if(input[mm][nn]==1) {
						input[mm][nn]=c;
					}

				}
			}
		}
		
	}
	
	public static void visitClear() {
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				visit[i][j]=0;
			}
		}
	}
	
	public static boolean notAllZeroCheck() {
		zerocnt = 0;
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				if(input[i][j]==0) {
					zerocnt++;
				}
			}
		}
		
		if(zerocnt==height*width) {
			return  false;
		}else {
			return  true;
		}
		
	}
	
	public static void decay() {
		decaycnt=0;
		for(int i=0;i<height;i++) {
			for(int j=0;j<width;j++) {
				if(input[i][j]==c) {
					input[i][j]=0;
					decaycnt++;
				}
			}
		}
		time++;
		decayl.add(decaycnt);
	}

}
