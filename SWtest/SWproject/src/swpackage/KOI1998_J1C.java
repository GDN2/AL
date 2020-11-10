package swpackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class KOI1998_J1C {

	static int[][] matrix;
	static int[][] visit;
	
	static int max;
	static int cnt;
	static int N;
	static int half;
	
	static int a;
	static int b;
	static int c;
	static int d;
	
	//static String casecom;
	
	static ArrayList<Integer> al = new ArrayList<>();
	static ArrayList<Integer> caseArray = new ArrayList<>();
	static ArrayList<Integer> matchcase = new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		N = scanner.nextInt();
		half = N/2;
		
		matrix = new int[half][6];
		visit = new int[half][half];
		
		for (int i=0;i<half;i++) { //한칸씩 띄어서 받을 경우에는 nextInt로 받는 것이 제일 좋음 nextLine은 무조건 오류발생, 숫자가 붙어서 올 때는 next로 받고 String분리 
			for (int j=0;j<4;j++) {
				matrix[i][j] = scanner.nextInt();
			}
		}
		
		//시계방향으로 변의 숫자바꿔주기
		for (int i=0;i<half;i++) {
			if(matrix[i][0]==1) {
				matrix[i][0] = 1;
			}else if(matrix[i][0]==4) {
				matrix[i][0] = 2;
			}else if(matrix[i][0]==2) {
				matrix[i][0] = 3;
			}else if(matrix[i][0]==3) {
				matrix[i][0] = 4;
			}
			
			if(matrix[i][2]==1) {
				matrix[i][2] = 1;
			}else if(matrix[i][2]==4) {
				matrix[i][2] = 2;
			}else if(matrix[i][2]==2) {
				matrix[i][2] = 3;
			}else if(matrix[i][2]==3) {
				matrix[i][2] = 4;
			}
		}
		
		
		
		for (int i=0;i<N/2;i++) {
			for(int j=0;j<6;j++) {
				System.out.print
				(matrix[i][j]+" ");
			}
			System.out.println();
		}
		

		for (int i=0;i<half;i++) {
			for (int j=0;j<half;j++) {
				if (i != j && visit[i][j]!=1) {
					visit[i][j] = 1;
					visit[j][i] = 1;
					if(find2(matrix[i],matrix[j])) {
						matrix[i][5]++;
						matrix[j][5]++;
					};
				}
			}
		}
		
		
		for (int i=0;i<N/2;i++) {
			for(int j=0;j<6;j++) {
				System.out.print
				(matrix[i][j]+" ");
			}
			System.out.println();
		}
		
		for (int i=0;i<half;i++) {
			matchcase.add(matrix[i][5]);
		}

		for (int i: matchcase) {
			cnt = cnt +i;
		}
		System.out.println(cnt/2);
		System.out.println(Collections.max(matchcase));
		
		
	}
	
	public static boolean find2(int[] m, int[] n) {
		boolean result = false;
		
		if (m[0]*100+m[1]<m[2]*100+m[3]) {
			a = m[0]*100+m[1];
			b = m[2]*100+m[3];
		}else {
			b = m[0]*100+m[1];
			a = m[2]*100+m[3];
		}
		
		if (n[0]*100+n[1]<n[2]*100+n[3]) {
			c = n[0]*100+n[1];
			d = n[2]*100+n[3];
		}else {
			d = n[0]*100+n[1];
			c = n[2]*100+n[3];
		}
		
		if (a<c) {
			if ((a<c&&c<b) && (d>b)) {
				result = true;
			}else {
				result = false;
			}
		}else {
			if ((c<a&&a<d) && (b>d)) {
				result = true;
			}else {
				result = false;
			}
		}

		System.out.println("a "+a+", b "+b+", c "+c+", d"+d);

		
		return result;
	}
	
	public static boolean find(int[] m, int[] n) {
		
		boolean result = true;
		String casecom;
		int[] scase;
		int[] lcase;
		


		if (m[4]<=n[4]) {
			if(m[4]==n[4]) {
				if(m[1]<n[1]) {
					scase = m;
					lcase = n;
				}else {
					scase = n;
					lcase = m;
				}
			}else {
				scase = m;
				lcase = n;
			}

		}else {
			scase = n;
			lcase = m;
		}
		
		casecom = Integer.toString(scase[4])+Integer.toString(lcase[4]);
		//System.out.println(casecom);
		//System.out.println(scase[4]);
		//System.out.println(lcase[4]);
		
		//경우의 수는 10*10 = 100가지 중에 중복되는 것을 제외하고 63가지가 있으며 이중 만나지 못하는 경우의 수 28 가지를 제외하면 35가지 경우의 수가 있고 시계방향으로 같은 것 끼리 묶으면 4*8+1*1+2*1 = 35 -> 10케이스가 있음
		switch(Integer.parseInt(casecom)) {
			case 11:
				if((scase[1]<lcase[1] && lcase[1]<scase[3])&&(scase[3]<lcase[3])) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 55:
				if((scase[1]<lcase[1] && lcase[1]<scase[3])&&(scase[3]<lcase[3])) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 88:
				if((scase[1]<lcase[1] && lcase[1]<scase[3])&&(scase[3]<lcase[3])) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 1010:
				if((scase[1]<lcase[1] && lcase[1]<scase[3])&&(scase[3]<lcase[3])) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 12:
				if((scase[1]<lcase[1] && lcase[1]<scase[3])) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 56:
				if((scase[1]<lcase[3] && lcase[3]<scase[3])) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 89:
				if((scase[1]<lcase[1] && lcase[1]<scase[3])) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 410:
				if((lcase[1]<scase[3] && scase[3]<lcase[3])) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 13:
				if((scase[1]<lcase[1] && lcase[1]<scase[3])) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 57:
				if((scase[1]<lcase[3] && lcase[3]<scase[3])) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 38:
				if((lcase[1]<scase[3] && scase[3]<lcase[3])) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 710:
				if((lcase[1]<scase[1] && scase[1]<lcase[3])) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 14:
				if((scase[1]<lcase[1] && lcase[1]<scase[3])) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 25:
				if((lcase[1]<scase[3] && scase[3]<lcase[3])) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 68:
				if((lcase[1]<scase[1] && scase[1]<lcase[3])) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 910:
				if((lcase[1]<scase[3] && scase[3]<lcase[3])) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 22:
				if(scase[3]<lcase[3]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 66:
				if(scase[3]>lcase[3]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 99:
				if(scase[3]<lcase[3]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 44:
				if(scase[3]>lcase[3]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 23:
				if(scase[1]<lcase[1]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 67:
				if(scase[3]<lcase[3]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 39:
				if(lcase[1]>scase[3]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 47:
				if(scase[3]>lcase[1]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 24:
				if(scase[1]<lcase[1]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 26:
				if(lcase[3]<scase[3]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 69:
				if(lcase[1]>scase[1]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 49:
				if(scase[3]>lcase[3]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 27:
				if(scase[3]>lcase[3]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 36:
				if(lcase[1]<scase[3]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 79:
				if(lcase[3]<scase[1]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 34:
				if(lcase[1]>scase[1]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 33:
				if(scase[3]>lcase[3]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 77:
				if(scase[3]>lcase[3]) {
					result = true;
				}else {
					result = false;
				}
				break;
			case 37:
				result = true;
				break;
				
			default:
				result = false;
		}
		
		return result;
	}
	

}