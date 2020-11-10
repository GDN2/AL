package swpackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class KOI1997_J1 {
	
	static int matrix[][];
	static int visit[][];
	
	static int N;
	static int cnt;
	
	static ArrayList<Integer> al = new ArrayList<Integer>();
	static ArrayList<Integer> ial = new ArrayList<>();
	static ArrayList<Integer> jal = new ArrayList<>();
	static ArrayList ijal = new ArrayList<>();
	static ArrayList<Integer> totali = new ArrayList<>();
	static ArrayList<Integer> totalj = new ArrayList<>();
	static ArrayList<Integer> val = new ArrayList<>();
	
	
	static int[] dx = {0,0,1,-1};
	static int[] dy = {-1,1,0,0};
	
	static int[] v = new int[2];
	static int[] v1 = new int[2];
	static int[] v2 = new int[2];
	static int[] v3 = new int[2];
	
	static boolean TF = false;
	static int CASE = 0;
	static boolean tf = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner =  new Scanner(System.in);
		N = 11;
		matrix = new int[N][N];
		for (int i=1; i<N; i++) {
			String line = scanner.nextLine();
			for (int j=1; j<N; j++) {
				matrix[i][j] = line.charAt(j-1) - '0';
			}
		}
		
		for (int i=1;i<N;i++) {
			for (int j=1;j<N;j++) {
				if(matrix[i][j]==1) {
					matrix[i][0]++;
					matrix[0][j]++;
				}
				
			}
		}
		
		for (int i=0;i<N;i++) {
			totali.add(matrix[i][0]);
			totalj.add(matrix[0][i]);
		}
		/*
		for (int i:totali) {
			System.out.println(i);
		}
		for (int j:totalj) {
			System.out.println(j);
		}
		*/
		/*

		for (int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		*/

		for (int i=1;i<N;i++) {
			for (int j=1;j<N;j++) {
				/*
				if(TF==false) {
					System.out.print(matrix[i][j]);
				}
				*/
				//System.out.print(matrix[i][j]);
				if(matrix[i][j]==1) {
					ial.add(i);
					jal.add(j);
					v[0] = i;
					v[1] = j;
					ijal.add(v);
					//System.out.print("+"+i+"-"+j);
					break;
				}
			}
			//System.out.println();
		}
		
		//tf = false;
		//System.out.println("tf"+tf);
		if (Collections.max(totalj)>=Collections.max(totali)) { // 수직선
			int maxj = totalj.indexOf(Collections.max(totalj));
			int maxi = totali.indexOf(Collections.max(totali));
			int i = totali.indexOf(1);
			int lasti = totali.lastIndexOf(1);
			//System.out.println("i "+i);
			//System.out.println("lasti "+lasti);

			if (i<lasti) { // <l이런 모양
				
				for (int m=i;m<=lasti;m++) {
					if (totalj.indexOf(1)<totalj.indexOf(Collections.max(totalj))) {
						//System.out.println("totalj.indexOf(Collections.min(totalj)) "+totalj.indexOf(1));
						//System.out.println("totalj.indexOf(Collections.max(totalj))"+totalj.indexOf(Collections.max(totalj)));
						CASE = 1;
						if(matrix[m][maxj] ==1) {
							cnt = 1;
						}

						findleft(m, maxj);
						if (cnt == totali.get(m))  {
							
							//System.out.println(cnt);
							//System.out.println(totali.get(m));
						}else {
							//System.out.println(cnt);
							//System.out.println(totali.get(m));
							tf = false;
							CASE = 0;
							val.clear();
							break;
						}
						if(tf=true) {
							val.clear();
							CASE=1;
							val.add(i);
							val.add(maxj);
							val.add(maxi);
							val.add(totalj.indexOf(1));
							val.add(lasti);
							val.add(maxj);
						}
					} else { // l> 이런 모양
						CASE = 2;
						if(matrix[m][maxj] ==1) {
							cnt = 1;
						}
						findRight(m, maxj);
						if (cnt == totali.get(m))  {
							
							//System.out.println(cnt);
							//System.out.println(totali.get(m));
						}else {
							tf = false;
							CASE = 0;
							val.clear();
							break;
							//System.out.println(cnt);
							//System.out.println(totali.get(m));
						}
						if(tf=true) {
							val.clear();
							CASE=2;
							val.add(i);
							val.add(maxj);
							val.add(maxi);
							val.add(totalj.indexOf(1));
							val.add(lasti);
							val.add(maxj);
						}
					}
				}
				
			}else if (i == lasti && i!=-1) { 
				if (i < maxi) { // 정상적인 모양 /_l
					
					for (int m=i;m<=totali.indexOf(Collections.max(totali));m++) {
						if (totalj.indexOf(1)<totalj.indexOf(Collections.max(totalj))) {
							//System.out.println("totalj.indexOf(Collections.min(totalj)) "+totalj.indexOf(1));
							//System.out.println("totalj.indexOf(Collections.max(totalj))"+totalj.indexOf(Collections.max(totalj)));
							//System.out.println("CASE3");
							CASE = 3;
							if(matrix[m][maxj] ==1) {
								cnt = 1;
							}

							findleft(m, maxj);
							if (cnt == totali.get(m))  {
								
								//System.out.println(cnt);
								//System.out.println(totali.get(m));
							}else {
								//System.out.println(cnt);
								//System.out.println(totali.get(m));
								tf = false;
								CASE = 0;
								val.clear();
								break;
							}
							if(tf=true) {
								val.clear();
								CASE=3;
								val.add(i);
								val.add(maxj);
								val.add(maxi);
								val.add(totalj.indexOf(1));
								val.add(maxi);
								val.add(maxj);
							}
						} else { // l_\ 이런 모양
							CASE = 4;
							if(matrix[m][maxj] ==1) {
								cnt = 1;
							}
							findRight(m, maxj);
							if (cnt == totali.get(m))  {
								
								//System.out.println(cnt);
								//System.out.println(totali.get(m));
							}else {
								tf = false;
								CASE = 0;
								val.clear();
								break;
								//System.out.println(cnt);
								//System.out.println(totali.get(m));
							}
							if(tf=true) {
								val.clear();
								CASE=4;
								val.add(i);
								val.add(maxj);
								val.add(maxi);
								val.add(maxj);
								val.add(maxi);
								val.add(totalj.indexOf(1));

							}
						}
					}
					
				}else if (maxi < i) { // 뒤집힌 모양 \-
					for (int m=maxi;m<=i;m++) {
						if (totalj.indexOf(1)<totalj.indexOf(Collections.max(totalj))) {
							//System.out.println("totalj.indexOf(Collections.min(totalj)) "+totalj.indexOf(1));
							//System.out.println("totalj.indexOf(Collections.max(totalj))"+totalj.indexOf(Collections.max(totalj)));
							CASE = 5;
							if(matrix[m][maxj] ==1) {
								cnt = 1;
							}

							findleft(m, maxj);
							if (cnt == totali.get(m))  {
								
								//System.out.println(cnt);
								//System.out.println(totali.get(m));
							}else {
								//System.out.println(cnt);
								//System.out.println(totali.get(m));
								tf = false;
								CASE = 0;
								val.clear();
								break;
							}
							if(tf=true) {
								val.clear();
								CASE=5;
								val.add(maxi);
								val.add(totalj.indexOf(1));
								val.add(maxi);
								val.add(maxj);
								val.add(i);
								val.add(maxj);

							}
						} else { // 뒤집힌 모양 l-/
							CASE = 6;
							if(matrix[m][maxj] ==1) {
								cnt = 1;
							}
							findRight(m, maxj);
							if (cnt == totali.get(m))  {
								
								//System.out.println(cnt);
								//System.out.println(totali.get(m));
							}else {
								tf = false;
								CASE = 0;
								val.clear();
								break;
								//System.out.println(cnt);
								//System.out.println(totali.get(m));
							}
							if(tf=true) {
								val.clear();
								CASE=6;
								val.add(maxi);
								val.add(maxj);
								val.add(maxi);
								val.add(totalj.indexOf(1));
								val.add(i);
								val.add(maxj);

							}
						}
					}
				}
			}
			
					
		}else if(Collections.max(totalj)<Collections.max(totali)) {
			int maxj = totalj.indexOf(Collections.max(totalj));
			int maxi = totali.indexOf(Collections.max(totali));
			int j = totalj.indexOf(1);
			int lastj = totalj.lastIndexOf(1);
			//System.out.println("j "+j);
			//System.out.println("lastj "+lastj);

			if (j!=-1 && lastj!=-1) { 
				
				for (int m=j;m<=lastj;m++) {
					if (totali.indexOf(1)<totali.indexOf(Collections.max(totali))) {// 스이런 모양
						//System.out.println("totali.indexOf(Collections.min(totali)) "+totali.indexOf(1));
						//System.out.println("totali.indexOf(Collections.max(totali))"+totali.indexOf(Collections.max(totali)));
						CASE = 7;
						if(matrix[maxi][m] ==1) {
							cnt = 1;
						}

						findUp(maxi, m);
						//System.out.println(cnt);
						//System.out.println(totalj.get(m));

						if (cnt == totalj.get(m))  {
							//System.out.println(tf);

						}else{
							tf = false;
							CASE = 0;
							val.clear();
							break;
							//System.out.println(tf);


						}
						if(tf=true) {
							val.clear();
							CASE=7;
							val.add(totali.indexOf(1));
							val.add(maxj);
							val.add(maxi);
							val.add(j);
							val.add(maxi);
							val.add(lastj);

						}
					} else { // V 이런 모양
						CASE = 8;
						if(matrix[maxi][m] ==1) {
							cnt = 1;
						}
						findDown(maxi, m);
						if (cnt == totalj.get(m))  {
							
							//System.out.println(cnt);
							//System.out.println(totalj.get(m));
						}else {
							tf = false;
							CASE = 0;
							val.clear();
							break;
							//System.out.println(cnt);
							//System.out.println(totalj.get(m));
						}
						if(tf=true) {
							val.clear();
							CASE=8;
							val.add(maxi);
							val.add(j);
							val.add(maxi);
							val.add(lastj);
							val.add(totali.indexOf(1));
							val.add(maxj);

						}
					}
				}
				
			}
			
			
		} // 수평선
		
		
/*
		for (int i=1;i<N;i++) {
			for (int j=1;j<N;j++) {
				
				if(TF==false) {
					System.out.print(matrix[i][j]);
				}
				
	
				if(matrix[i][j]==1 && TF==false) {
					TF = true;
					//System.out.print("i:"+i+"j:"+j);
					if(case1(i,j)) {
						CASE=1;
						break;
					}
					if(case2(i,j)) {
						CASE=2;
						break;
					}
					if(case3(i,j)) {
						CASE=3;
						break;
					}
					if(case4(i,j)) {
						CASE=4;
						break;
					}
					if(case5(i,j)) {
						CASE=5;
						break;
					}
					break;
				}
				
			}

		}
*/
/*
		switch(CASE) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				break;
			default:
				System.out.println(0);
		}
*/

		if (CASE == 0) {
			System.out.println(0);
		}else {
			//System.out.println("CASE"+CASE);
			for (int i=0; i<3; i++) {
				for (int j=0; j<2; j++) {
					System.out.print(val.get(i*2+j)+" ");
				}
				System.out.println();

			}
		}
		

	}
	
	public static void findleft(int x, int y) {
		int nx = x; //x-1
		int ny = y-1; //y+0
		
		if (nx>=1&&ny>=1&&nx<=10&&ny<=10 &&matrix[nx][ny] ==1) {
			findleft(nx,ny);

			cnt++;
		}
		
	}
	public static void findRight(int x, int y) {
		int nx = x; 
		int ny = y+1; 
		
		if (nx>=1&&ny>=1&&nx<=10&&ny<=10 &&matrix[nx][ny] ==1) {
			findRight(nx,ny);
			//System.out.println("nx "+nx+" ny "+ny);
			cnt++;
		}
		
	}
	public static void findUp(int x, int y) {
		
		int nx = x-1; 
		int ny = y; 
		

		
		if (nx>=1&&ny>=1&&nx<=10&&ny<=10 &&matrix[nx][ny] ==1) {
			findUp(nx,ny);
			//System.out.println("nx "+nx+" ny "+ny);
			//System.out.println("matrix "+matrix[nx][ny]);
			cnt++;
		}
		
	}
	public static void findDown(int x, int y) {
		int nx = x+1; 
		int ny = y; 
		
		if (nx>=1&&ny>=1&&nx<=10&&ny<=10 &&matrix[nx][ny] ==1) {
			findDown(nx,ny);
			//System.out.println("nx "+nx+" ny "+ny);
			cnt++;
		}
		
	}
	
	public static boolean case1(int x, int y) {
		
		
		return false;
	}
	public static boolean case2(int x, int y) {
		
		return false;
	}
	public static boolean case3(int x, int y) {
		if( ial.size()>=1) {
			int s = ial.size();
			v1[0] = ial.get(0);
			v1[1] = jal.get(0);
			int half = ((int)s/2)+1;
			if (jal.get(half)<jal.get(0)) {
				v2[0] = ial.get(half);
				v2[1] = jal.get(half);
			}else {
				v2[0] = ial.get(half);
				v2[1] = jal.get(half)+matrix[ial.get(half)][0]-1;
			}
			v3[0] = ial.get(s-1);
			v3[1] = jal.get(s-1);
			return true;
		}
		
		
		
		
		return false;
	}
	public static boolean case4(int x, int y) {
		
		return false;
	}
	public static boolean case5(int x, int y) {
		
		return false;
	}

}