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
		for (int i=1; i<N; i++) { // ��ó�� 1 - ��� ����
			String line = scanner.nextLine();
			for (int j=1; j<N; j++) {
				matrix[i][j] = line.charAt(j-1) - '0';
			}
		}
		
		for (int i=1;i<N;i++) { // ��ó�� 2 - i �� j �� �� ���� ���Ѵ�.
			for (int j=1;j<N;j++) {
				if(matrix[i][j]==1) {
					matrix[i][0]++;
					matrix[0][j]++;
				}
				
			}
		}
		
		for (int i=0;i<N;i++) { // ��ó�� 3 - ��ó�� 2���� ���� ���� ArrayList�� �ٽ� �޴´�. ArrayList�� Collections�� ������ �Լ��� ���� ����(max, min�� ã��(Collections), �ش簪 indexã��(ArrayList))
			totali.add(matrix[i][0]);
			totalj.add(matrix[0][i]);
		}

		//����� �ﰢ���̱⸸ �ϸ� �����̵ �ﰢ���̴�!
		//����� �ﰢ���̱⸸ �ϸ� �����̵ �ﰢ���̴�!
		//����� �ﰢ���̱⸸ �ϸ� �����̵ �ﰢ���̴�!
		//CASE�� 8�� ���� <|, |>, /_|, |_\, \-|, |-/, ��, V
		if (Collections.max(totalj)>=Collections.max(totali)) { // �ﰢ���� �������� ������ ��� CASE 1~6(���ο� ������ �ִ���� �� ���ΰ� ��ų� ���� ��)
			int maxj = totalj.indexOf(Collections.max(totalj)); // max���� ���� j�� ��ġ ������ ��ġ
			int maxi = totali.indexOf(Collections.max(totali)); // max���� ���� i�� ��ġ ������ �� �� �ְ� �ƴ� �� �� ����
			int i = totali.indexOf(1); // 1���� ���� i ��ġ ������
			int lasti = totali.lastIndexOf(1); // 1���� ���� i ��ġ�� �ڿ������� ã��

			if (i<lasti) { // �ּڰ�1�� ���� ���� ArrayList�߿� �� �� ���� ���߿��� i�� lasti���� �۴ٸ� <|�̷� ���
				
				for (int m=i;m<=lasti;m++) { //�������� �������� �ȴ´�
					if (totalj.indexOf(1)<totalj.indexOf(Collections.max(totalj))) {
						CASE = 1;
						if(matrix[m][maxj] ==1) {
							cnt = 1;
						}

						findleft(m, maxj); //�������� ���鼭 1�� ������ cnt(ī��Ʈ)�� ���س��� cnt�� �ش� �࿡�� i���� ������ totali.get(m)�� ���ƾ���
						if (cnt != totali.get(m))  { // �ѹ��̶� �ٸ��� ���� �ʱ�ȭ�ϰ�  break;
							tf = false;
							CASE = 0;
							val.clear();
							break;
						}
						
						if(tf=true) { // tf�� true�� ������ �ش� �ﰢ�� ����� �������� �����ؼ� ����������Ʈ val�� ������ ����ؼ� �־��� ���߿� ���� �ʿ����
							val.clear(); // for���̶� �ʱ�ȭ ��� �Ǳ���
							CASE=1;
							val.add(i);
							val.add(maxj);
							val.add(maxi);
							val.add(totalj.indexOf(1));
							val.add(lasti);
							val.add(maxj);
						}
					} else { // lasti�� i���� ũ�ٴ� ���� l> �̷� ���
						CASE = 2;
						if(matrix[m][maxj] ==1) {
							cnt = 1;
						}
						findRight(m, maxj); //���������� ���鼭 1�� ������ cnt(ī��Ʈ)�� ���س��� cnt�� �ش� �࿡�� i���� ������ totali.get(m)�� ���ƾ���
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
				
			}else if (i == lasti && i!=-1) { // �ּڰ�1�� ���� ���� ArrayList�߿� �ϳ� �ۿ� ����, �ﰢ���� /_|, |_\, \-|, |-/ ��� �� �ϳ�
				if (i < maxi) { // totali�߿��� 1�� ���� ��ġ�� max���� ���� ��ġ���� �۴ٴ� ����  /_|, |_\���
					
					for (int m=i;m<=totali.indexOf(Collections.max(totali));m++) {
						if (totalj.indexOf(1)<totalj.indexOf(Collections.max(totalj))) { //totalj���� 1�� ���� ��ġ�� max���� ���� ��ġ���� �۴ٸ� /_|���

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
						} else { //totalj���� max���� ���� ��ġ�� 1���� ���� ��ġ���� �۴ٸ� l_\ �̷� ���
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
					
				}else if (maxi < i) { // totali�߿��� max���� ���� ��ġ�� 1���� ���� ��ġ���� �۴ٴ� ����  \-|, |-/ ��� �� �ϳ�
					for (int m=maxi;m<=i;m++) {
						if (totalj.indexOf(1)<totalj.indexOf(Collections.max(totalj))) { //totalj���� 1�� ���� ��ġ�� max���� ���� ��ġ���� �۴ٸ� \-|���
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
						} else { //totalj���� max���� ���� ��ġ�� 1���� ���� ��ġ���� �۴ٸ�  l-/ ���
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
			
					
		}else if(Collections.max(totalj)<Collections.max(totali)) { // �ﰢ���� ������ ������ ��� CASE 7~8(���ο� ������ �ִ���� �� ���ΰ� ��ų� ���� ��)
			int maxj = totalj.indexOf(Collections.max(totalj));
			int maxi = totali.indexOf(Collections.max(totali));
			int j = totalj.indexOf(1);
			int lastj = totalj.lastIndexOf(1);

			if (j!=-1 && lastj!=-1) { //i�� lasti�� ���� CASE�� 3~6���� ����ִϱ� ���⼭�� -1(1���� ���� ��찡 ���ٴ� �ǹ�)�� �ƴ����� üũ
				
				for (int m=j;m<=lastj;m++) {
					if (totali.indexOf(1)<totali.indexOf(Collections.max(totali))) {// totali�� 1���� ���� ��ġ�� max���� ���� ��ġ���� ���� �� '��' ���

						CASE = 7;
						if(matrix[maxi][m] ==1) {
							cnt = 1;
						}

						findUp(maxi, m); //���� ���鼭 �ٷ� ���� 1�� ������ cnt(ī��Ʈ)�� ���س��� cnt�� �ش� �࿡�� j���� ������ totalj.get(m)�� ���ƾ���

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
					} else { // totali�� max���� ���� ��ġ�� i���� ���� ��ġ���� ���� ��  V �̷� ���
						CASE = 8;
						if(matrix[maxi][m] ==1) {
							cnt = 1;
						}
						findDown(maxi, m); //�Ʒ��� ���鼭 �ٷ� �Ʒ��� 1�� ������ cnt(ī��Ʈ)�� ���س��� cnt�� �ش� �࿡�� j���� ������ totalj.get(m)�� ���ƾ���
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
		
		
		if (CASE == 0) { // CASE = 0�̸� ���߿� break�ؼ� ���ĳ��� ���
			System.out.println(0);
		}else { // CASE�� ���� ������ ó������ ������ tf=true�� ���� ���
			for (int i=0; i<3; i++) {
				for (int j=0; j<2; j++) {
					System.out.print(val.get(i*2+j)+" "); // ������ �ε��� ����, �������� ���� val�� CASE�� ���� �������� ������� �Է����־����� �������� �������� �ʿ�� ����
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