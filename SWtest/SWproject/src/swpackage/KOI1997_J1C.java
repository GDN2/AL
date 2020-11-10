package swpackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;


public class KOI1997_J1C {
	
	static int matrix[][];
	
	static int N;
	static int cnt;

	static ArrayList<Integer> totali = new ArrayList<>();
	static ArrayList<Integer> totalj = new ArrayList<>();
	
	static ArrayList<Integer> val = new ArrayList<>();
	
	static int CASE = 0;
	static boolean tf = true;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner =  new Scanner(System.in);
		N = 11;
		matrix = new int[N][N];
		for (int i=1; i<N; i++) { // 전처리 1 - 행렬 받음
			String line = scanner.nextLine();
			for (int j=1; j<N; j++) {
				matrix[i][j] = line.charAt(j-1) - '0';
			}
		}
		
		for (int i=1;i<N;i++) { // 전처리 2 - i 축 j 축 총 합을 구한다.
			for (int j=1;j<N;j++) {
				if(matrix[i][j]==1) {
					matrix[i][0]++;
					matrix[0][j]++;
				}
				
			}
		}
		
		for (int i=0;i<N;i++) { // 전처리 3 - 전처리 2에서 받은 값을 ArrayList로 다시 받는다. ArrayList와 Collections가 유용한 함수가 많기 때문(max, min값 찾기(Collections), 해당값 index찾기(ArrayList))
			totali.add(matrix[i][0]);
			totalj.add(matrix[0][i]);
		}

		//참고로 삼각형이기만 하면 직각이등변 삼각형이다!
		//참고로 삼각형이기만 하면 직각이등변 삼각형이다!
		//참고로 삼각형이기만 하면 직각이등변 삼각형이다!
		//CASE는 8개 있음 <|, |>, /_|, |_\, \-|, |-/, 스, V
		if (Collections.max(totalj)>=Collections.max(totali)) { // 삼각형에 수직선이 존재할 경우 CASE 1~6(가로와 세로의 최대길이 중 세로가 길거나 같을 때)
			int maxj = totalj.indexOf(Collections.max(totalj)); // max값을 같는 j의 위치 수직선 위치
			int maxi = totali.indexOf(Collections.max(totali)); // max값을 같는 i의 위치 수평선일 수 도 있고 아닐 수 도 있음
			int i = totali.indexOf(1); // 1값을 같는 i 위치 꼭짓점
			int lasti = totali.lastIndexOf(1); // 1값을 같는 i 위치를 뒤에서부터 찾음

			if (i<lasti) { // 최솟값1을 갖는 것이 ArrayList중에 두 개 있음 그중에서 i가 lasti보다 작다면 <|이런 모양
				
				for (int m=i;m<=lasti;m++) { //수직선을 기준으로 훑는다
					if (totalj.indexOf(1)<totalj.indexOf(Collections.max(totalj))) {
						CASE = 1;
						if(matrix[m][maxj] ==1) {
							cnt = 1;
						}

						findleft(m, maxj); //왼쪽으로 가면서 1이 있으면 cnt(카운트)를 더해나감 cnt는 해당 행에서 i값의 총합인 totali.get(m)과 같아야함
						if (cnt != totali.get(m))  { // 한번이라도 다르면 전부 초기화하고  break;
							tf = false;
							CASE = 0;
							val.clear();
							break;
						}
						
						if(tf=true) { // tf가 true일 때마다 해당 삼각형 모양의 꼭짓점을 생각해서 꼭짓점리스트 val에 순서를 고려해서 넣어줌 나중에 정렬 필요없음
							val.clear(); // for문이라서 초기화 없어도 되긴함
							CASE=1;
							val.add(i);
							val.add(maxj);
							val.add(maxi);
							val.add(totalj.indexOf(1));
							val.add(lasti);
							val.add(maxj);
						}
					} else { // lasti가 i보다 크다는 것은 l> 이런 모양
						CASE = 2;
						if(matrix[m][maxj] ==1) {
							cnt = 1;
						}
						findRight(m, maxj); //오른쪽으로 가면서 1이 있으면 cnt(카운트)를 더해나감 cnt는 해당 행에서 i값의 총합인 totali.get(m)과 같아야함
						if (cnt != totali.get(m))  {
							tf = false;
							CASE = 0;
							val.clear();
							break;
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
				
			}else if (i == lasti && i!=-1) { // 최솟값1을 갖는 것이 ArrayList중에 하나 밖에 없음, 삼각형이 /_|, |_\, \-|, |-/ 모양 중 하나
				if (i < maxi) { // totali중에서 1을 갖는 위치가 max값을 갖는 위치보다 작다는 것은  /_|, |_\모양
					
					for (int m=i;m<=totali.indexOf(Collections.max(totali));m++) {
						if (totalj.indexOf(1)<totalj.indexOf(Collections.max(totalj))) { //totalj에서 1을 갖는 위치가 max값을 갖는 위치보다 작다면 /_|모양

							CASE = 3;
							if(matrix[m][maxj] ==1) {
								cnt = 1;
							}

							findleft(m, maxj);
							if (cnt != totali.get(m))  {
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
						} else { //totalj에서 max값을 갖는 위치가 1값을 갖는 위치보다 작다면 l_\ 이런 모양
							CASE = 4;
							if(matrix[m][maxj] ==1) {
								cnt = 1;
							}
							findRight(m, maxj);
							if (cnt != totali.get(m))  {
								tf = false;
								CASE = 0;
								val.clear();
								break;
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
					
				}else if (maxi < i) { // totali중에서 max값을 갖는 위치가 1값을 갖는 위치보다 작다는 것은  \-|, |-/ 모양 중 하나
					for (int m=maxi;m<=i;m++) {
						if (totalj.indexOf(1)<totalj.indexOf(Collections.max(totalj))) { //totalj에서 1을 갖는 위치가 max값을 갖는 위치보다 작다면 \-|모양
							CASE = 5;
							if(matrix[m][maxj] ==1) {
								cnt = 1;
							}

							findleft(m, maxj);
							if (cnt != totali.get(m))  {
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
						} else { //totalj에서 max값을 갖는 위치가 1값을 갖는 위치보다 작다면  l-/ 모양
							CASE = 6;
							if(matrix[m][maxj] ==1) {
								cnt = 1;
							}
							findRight(m, maxj);
							if (cnt != totali.get(m))  {
								tf = false;
								CASE = 0;
								val.clear();
								break;
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
			
					
		}else if(Collections.max(totalj)<Collections.max(totali)) { // 삼각형에 수평선이 존재할 경우 CASE 7~8(가로와 세로의 최대길이 중 가로가 길거나 같을 때)
			int maxj = totalj.indexOf(Collections.max(totalj));
			int maxi = totali.indexOf(Collections.max(totali));
			int j = totalj.indexOf(1);
			int lastj = totalj.lastIndexOf(1);

			if (j!=-1 && lastj!=-1) { //i랑 lasti랑 같은 CASE는 3~6에서 잡아주니까 여기서는 -1(1값을 갖는 경우가 없다는 의미)이 아닌지만 체크
				
				for (int m=j;m<=lastj;m++) {
					if (totali.indexOf(1)<totali.indexOf(Collections.max(totali))) {// totali의 1값을 갖는 위치가 max값을 갖는 위치보다 적을 때 '스' 모양

						CASE = 7;
						if(matrix[maxi][m] ==1) {
							cnt = 1;
						}

						findUp(maxi, m); //위로 가면서 바로 위에 1이 있으면 cnt(카운트)를 더해나감 cnt는 해당 행에서 j값의 총합인 totalj.get(m)과 같아야함

						if (cnt != totalj.get(m))  {
							tf = false;
							CASE = 0;
							val.clear();
							break;

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
					} else { // totali의 max값을 갖는 위치가 i값을 갖는 위치보다 적을 때  V 이런 모양
						CASE = 8;
						if(matrix[maxi][m] ==1) {
							cnt = 1;
						}
						findDown(maxi, m); //아래로 가면서 바로 아래에 1이 있으면 cnt(카운트)를 더해나감 cnt는 해당 행에서 j값의 총합인 totalj.get(m)과 같아야함
						if (cnt != totalj.get(m))  {
							tf = false;
							CASE = 0;
							val.clear();
							break;
							
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
			
			
		} 
		
		
		if (CASE == 0) { // CASE = 0이면 도중에 break해서 뛰쳐나간 경우
			System.out.println(0);
		}else { // CASE에 값이 있으면 처음부터 끝까지 tf=true를 받은 경우
			for (int i=0; i<3; i++) {
				for (int j=0; j<2; j++) {
					System.out.print(val.get(i*2+j)+" "); // 간단한 인덱스 조작, 꼭짓점을 넣은 val은 CASE에 따라 꼭짓점을 순서대로 입력해주었으니 마지막에 정렬해줄 필요는 없다
				}
				System.out.println();

			}
		}
		

	}
	
	public static void findleft(int x, int y) {
		int nx = x;
		int ny = y-1;
		
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
			cnt++;
		}
		
	}
	public static void findUp(int x, int y) {
		
		int nx = x-1; 
		int ny = y; 
		

		
		if (nx>=1&&ny>=1&&nx<=10&&ny<=10 &&matrix[nx][ny] ==1) {
			findUp(nx,ny);
			cnt++;
		}
		
	}
	public static void findDown(int x, int y) {
		int nx = x+1; 
		int ny = y; 
		
		if (nx>=1&&ny>=1&&nx<=10&&ny<=10 &&matrix[nx][ny] ==1) {
			findDown(nx,ny);
			cnt++;
		}
		
	}
	
}