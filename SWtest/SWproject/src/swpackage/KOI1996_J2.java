package swpackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class KOI1996_J2 {
	
	static int matrix[];
	static int visit[];
	
	static int N;
	static int cnt;
	static int num=0;
	
	static ArrayList al = new ArrayList();
	static ArrayList<Integer> indexAl = new ArrayList<Integer>();
	static ArrayList<Integer> valueAl = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		matrix = new int[N+1];
		visit = new int[N+1];
		
		for (int i=1;i<=N;i++) {
			matrix[i] = scanner.nextInt();
		}
		
		for (int i=1;i<=N;i++) {
			
			if(matrix[i] == i) {
				visit[i] = 1;
				al.add(i);
				num++;
			}else if(visit[i]==0) {
				cnt = 1;
				indexAl.clear();
				valueAl.clear();
				
				find(i);
				
				if (valueAl.containsAll(indexAl)){
					num += cnt;
					al.addAll(indexAl);
				}else {
					/*
					for (int j=0;j<indexAl.size();j++) {
						System.out.print("+"+indexAl.get(j)+"+");
						System.out.print("-"+valueAl.get(j)+"-");
					}
					System.out.println("out");
					*/
					for (int j=0;j<indexAl.size();j++) {
						visit[indexAl.get(j)]=0;
					}
				}

				
			}
			
		}
		Collections.sort(al);
		System.out.println(al.size());
		for(int i=0;i<al.size();i++) {
			System.out.println(al.get(i));
		}

	}
	
	public static void find(int x) {
		visit[x] = 1;
		indexAl.add(x);
		valueAl.add(matrix[x]);
		cnt++;
		
		if (visit[matrix[x]]==0) {
			find(matrix[x]);
		}
		
		
	}

}
