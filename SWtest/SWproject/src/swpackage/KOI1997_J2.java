package swpackage;

import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class KOI1997_J2 {
	
	static int matrix[];
	static int visit[];
	
	static int N;
	static int cnt;
	static int clockNum;
	static int localClockNum;
	
	static ArrayList<Integer> al = new ArrayList<Integer>();
	static ArrayList<Integer> bl = new ArrayList<Integer>();
	static ArrayList<Integer> cl = new ArrayList<Integer>();
	static ArrayList<Integer> clockNumList = new ArrayList<Integer>();
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = 4;
		matrix = new int[N];
		for (int i=0;i<N;i++) {
			matrix[i] = scanner.nextInt();
			al.add(matrix[i]);
			//System.out.println(matrix[i]);
		}
		
		
		//System.out.println(al);
		clockNum = sort(al);
		//System.out.println(clockNum);

		for (int i=1;i<10;i++) {
			for (int j=1;j<10;j++) {
				for (int m=1; m<10; m++) {
					for (int n=1; n<10; n++) {
						bl.clear();
						bl.add(i);
						bl.add(j);
						bl.add(m);
						bl.add(n);
						
						
						localClockNum = sort(bl);
						//System.out.println(localClockNum);
						if (clockNumList.indexOf(localClockNum) == -1) {
							clockNumList.add(localClockNum);
						}
					}
				}
			}
		}
		/*
		for (int i : clockNumList) {
			System.out.println(i);
		}
		*/
		
		int index = clockNumList.indexOf(clockNum);
		System.out.println(index+1);
	
	
	
	
	
	
	
	}
	
	public static int sort(ArrayList<Integer> al) {
		
		cl.clear();
		
		int case1 = al.get(0)*1000 + al.get(1)*100 + al.get(2)*10 + al.get(3);
		int case2 = al.get(1)*1000 + al.get(2)*100 + al.get(3)*10 + al.get(0);
		int case3 = al.get(2)*1000 + al.get(3)*100 + al.get(0)*10 + al.get(1);
		int case4 = al.get(3)*1000 + al.get(0)*100 + al.get(1)*10 + al.get(2);

		cl.add(case1);
		cl.add(case2);
		cl.add(case3);
		cl.add(case4);
		
		Collections.sort(al);
		
		return Collections.min(cl);
	}
	

}
