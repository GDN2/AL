package swpackage;

import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;

public class KOI2002_J1 {
	
	static int input[][];
	static int matrix[][];
	static int weight[];
	static int visit[];
	
	static int N;
	static int cnt;
	static int R = 1;
	static int G = 2;
	static int B = 3;
	static int Y = 4;
	static String line;
	static String[] stra;
	static String str;
	static int CASE = 0;
	static int answer = 0;
	static int numcnt;
	static int max;
	static int doublecnt;
	
	static ArrayList<Integer> colorl = new ArrayList<>();
	static ArrayList<Integer> numberl = new ArrayList<>();
	static ArrayList<Integer> samenum = new ArrayList<>();
	static ArrayList<int[]> el = new ArrayList<>();
	static ArrayList<int[]> dl = new ArrayList<>();
	
	static boolean colorsame = false;
	static boolean straight = false;
	static boolean doublecheck = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		N = 5;
		input = new int[N][2];
		for (int i=0;i<N;i++) {
			
			for (int j=0;j<2;j++) {
				if(j==0) {
					str = scanner.next();
					input[i][j] = str.charAt(0) -'0';
					colorl.add(input[i][j]);
				}else {
					input[i][j] = scanner.nextInt();
					numberl.add(input[i][j]);
				}
			}
		}
		
		Collections.sort(colorl);
		if((colorl.get(4)-colorl.get(0))==0) {
			colorsame = true;
		}
		Collections.sort(numberl);
		cnt = 0;
		straightcheck(0);
		if(cnt == 4) {
			straight = true;
		}
		for(int i=0;i<N;i++) {
			samenumbercheck(i);
		}
		max = Collections.max(samenum);

		check9();
		check8();
		check7();
		check6();
		check5();
		check4();
		check3();
		check2();
		check1();
		System.out.println(answer);
		
	}
	

	
	static void samenumbercheck(int idx) {
		numcnt = 0;
		for(int i=0;i<N;i++) {
			if(numberl.get(idx)==numberl.get(i)) {
				numcnt++;
			}
		}
		samenum.add(numcnt);
	}
	
	static void straightcheck(int a) {
		if(a<N-1) {
			if(numberl.get(a+1)-numberl.get(a)==1) {
				cnt++;
				straightcheck(a+1);
			}
		}
	}
	
	static void check9() {
		if(colorsame==true && straight == true && CASE == 0) {
			CASE = 9;
			answer = CASE*100 + numberl.get(4);
		}
	}
	
	static void check8() {
		if(max==4&& CASE == 0) {
			CASE =8;
			int idx = samenum.indexOf(max);
			answer = CASE*100 + numberl.get(idx);
		}
	}
	
	static void check7() {
		if(max==3&& CASE == 0) {
			if(samenum.indexOf(2)!=-1) {
				CASE = 7;
				int idx = samenum.indexOf(max);
				int idx2 = samenum.indexOf(2);
				answer = CASE*100 + numberl.get(idx)*10 + numberl.get(idx2);
			}
		}
	}
	
	static void check6() {
		if (colorsame == true && CASE == 0) {
			CASE = 6;
			answer = CASE*100 + numberl.get(4);
		}
	}
	
	static void check5() {
		if(straight == true && CASE == 0) {
			CASE = 5;
			answer = CASE*100 + numberl.get(4);
		}
	}
	
	static void check4() {
		if(max==3 && CASE==0) {
			if(samenum.indexOf(2)==-1) {
				CASE = 4;
				int idx = samenum.indexOf(max);
				answer = CASE*100 + numberl.get(idx);
			}
		}
	}
	
	static void check3() {
		doublecnt=0;
		if(max==2 && CASE==0) {
			for(int i=0;i<N;i++) {
				if(samenum.get(i)==2) {
					doublecnt++;
				}
			}
			if(doublecnt==4) {
				CASE = 3;
				int idx = 3;
				int idx2 = 1;
				answer = CASE*100 + numberl.get(idx)*10+numberl.get(idx2);
			}
		}
	}
	
	static void check2() {
		if(max==2 && CASE==0) {
			CASE = 2;
			int idx = samenum.indexOf(max);
			answer = CASE*100 + numberl.get(idx);
		}
	}
	
	static void check1() {
		if(CASE==0) {
			CASE = 1;
			answer = CASE*100 + numberl.get(4);
		}
	}

}
