package swpackage;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

public class KOI1999_J2 {
	
	static int[][] input;
	static int[][] matrix;
	static int[][] visit;
	static int[] ijvo;
	static int[] ij;
	
	static int N;
	static int cnt;
	static int vcnt;
	static int hcnt;
	
	static ArrayList<int[]> ijvol = new ArrayList<>();
	static ArrayList<int[]> bl = new ArrayList<>();
	static ArrayList<Integer> cl = new ArrayList<>();
	
	static boolean vf = false;
	static boolean hf = false;
	static boolean rf = false;
	static boolean lf = false;
	static boolean uf = false;
	static boolean df = false;
	static boolean sf = false;
	static int vhsf = 0;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		N = 6;
		input = new int[N][N];
		ij = new int[2];
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				input[i][j] = scanner.nextInt();
			}
		}
		/*
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				System.out.print(input[i][j]+" ");
			}
			System.out.println();
			
		}
		*/
		
		for (int i=0;i<N;i++) {
			for (int j=0;j<N;j++) {
				flagInitialize();
				cntInitialize();
				if(input[i][j]>=1) {
					horizonCheck(i, j);
					
					if (hcnt == 4) {
						hf = true;
					}
					
					if (hf == true && uf == true && df == true) {
						vhsf = 1;
						//System.out.println(i+" "+j);
						ij[0] = i;
						ij[1] = j;
					}
					
					verticalCheck(i, j);
					if (vcnt == 4) {
						vf = true;

					}
					
					if (vf == true && lf == true && rf == true) {
						vhsf = 2;
						//System.out.println(i+" "+j);
						ij[0] = i;
						ij[1] = j;
					}
					
					specialCheck(i, j);
					
				}
				
			}
		}

		int m;
		int n;
		int v;
		int matchv = 0;
		int u;
		int d;
		int r;
		int l;
		
		switch(vhsf) {
			
			case 1:
				m = ij[0];
				n = ij[1];

				for (int i=0;i<4;i++) {
					ijvo = new int[4];
					ijvo[0] = m;
					ijvo[1] = n+i;
					ijvo[2] = input[m][n+i];
					ijvo[3] = i+1;
					ijvol.add(ijvo);
					
					if (input[m-1][n+i]>=1) {
						ijvo = new int[4];
						ijvo[0] = m-1;
						ijvo[1] = n+i;
						ijvo[2] = input[m-1][n+i];
						ijvo[3] = 5;
						ijvol.add(ijvo);
					}
					if (input[m+1][n+i]>=1) {
						ijvo = new int[4];
						ijvo[0] = m+1;
						ijvo[1] = n+i;
						ijvo[2] = input[m+1][n+i];
						ijvo[3] = 6;
						ijvol.add(ijvo);
					}
				}
				Collections.sort(ijvol, new Comparator<int[]>() {
					@Override
					public int compare(int[] i1, int[] i2) {
						if(i1[3]<i2[3]) {
							return -1;
						}else if(i1[3]>i2[3]) {
							return 1;
						}else {
							return 0;
						}
					}
				});
				/*
				for (int[] i : ijvol ) {
					System.out.printf("%d %d %d %d \n", i[0],i[1],i[2],i[3]);
				}
				*/
				v = IndexOfv(ijvol,1,2);
				switch(v) {
					case 0:
						matchv = ijvol.get(2)[2];
						break;
					case 1:
						matchv = ijvol.get(3)[2];
						break;
					case 2:
						matchv = ijvol.get(0)[2];
						break;
					case 3:
						matchv = ijvol.get(1)[2];
						break;
					case 4:
						matchv = ijvol.get(5)[2];
						break;
					case 5:
						matchv = ijvol.get(4)[2];
						break;
				}
				System.out.println(matchv);
				
				break;
				
			case 2:
				m = ij[0];
				n = ij[1];

				for (int i=0;i<4;i++) {
					ijvo = new int[4];
					ijvo[0] = m+i;
					ijvo[1] = n;
					ijvo[2] = input[m+i][n];
					ijvo[3] = i+1;
					ijvol.add(ijvo);
					
					if (input[m+i][n-1]>=1) {
						ijvo = new int[4];
						ijvo[0] = m+i;
						ijvo[1] = n-1;
						ijvo[2] = input[m+i][n-1];
						ijvo[3] = 5;
						ijvol.add(ijvo);
					}
					if (input[m+i][n+1]>=1) {
						ijvo = new int[4];
						ijvo[0] = m+i;
						ijvo[1] = n+1;
						ijvo[2] = input[m+i][n+1];
						ijvo[3] = 6;
						ijvol.add(ijvo);
					}
				}
				Collections.sort(ijvol, new Comparator<int[]>() {
					@Override
					public int compare(int[] i1, int[] i2) {
						if(i1[3]<i2[3]) {
							return -1;
						}else if(i1[3]>i2[3]) {
							return 1;
						}else {
							return 0;
						}
					}
				});
				/*
				for (int[] i : ijvol ) {
					System.out.printf("%d %d %d %d \n", i[0],i[1],i[2],i[3]);
				}
				*/
				
				v = IndexOfv(ijvol,1,2);
				switch(v) {
					case 0:
						matchv = ijvol.get(2)[2];
						break;
					case 1:
						matchv = ijvol.get(3)[2];
						break;
					case 2:
						matchv = ijvol.get(0)[2];
						break;
					case 3:
						matchv = ijvol.get(1)[2];
						break;
					case 4:
						matchv = ijvol.get(5)[2];
						break;
					case 5:
						matchv = ijvol.get(4)[2];
						break;
				}
				System.out.println(matchv);
				break;
				
			//case 3:
				
			case 4:
				m = ij[0];
				n = ij[1];
				
				ijvo = new int[4];
				ijvo[0] = m;
				ijvo[1] = n;
				ijvo[2] = input[m][n];
				ijvo[3] = 1;
				ijvol.add(ijvo);
				r = 0;
				d = 0;
				
				for (int i=1; i<6;i++) {
					if (i%2 == 1) {
						r++;
					}else if (i%2 == 0) {
						d++;
					}
					
					ijvo = new int[4];
					ijvo[0] = m+d;
					ijvo[1] = n+r;
					ijvo[2] = input[m+d][n+r];
					ijvo[3] = i+1;
					ijvol.add(ijvo);
				}

				
				Collections.sort(ijvol, new Comparator<int[]>() {
					@Override
					public int compare(int[] i1, int[] i2) {
						if(i1[3]<i2[3]) {
							return -1;
						}else if(i1[3]>i2[3]) {
							return 1;
						}else {
							return 0;
						}
					}
				});
				/*
				for (int[] i : ijvol ) {
					System.out.printf("%d %d %d %d \n", i[0],i[1],i[2],i[3]);
				}
				*/
				
				v = IndexOfv(ijvol,1,2);
				switch(v) {
					case 0:
						matchv = ijvol.get(3)[2];
						break;
					case 1:
						matchv = ijvol.get(4)[2];
						break;
					case 2:
						matchv = ijvol.get(5)[2];
						break;
					case 3:
						matchv = ijvol.get(0)[2];
						break;
					case 4:
						matchv = ijvol.get(1)[2];
						break;
					case 5:
						matchv = ijvol.get(2)[2];
						break;
				}
				System.out.println(matchv);
				
				break;
			case 5:
				m = ij[0];
				n = ij[1];
				
				ijvo = new int[4];
				ijvo[0] = m;
				ijvo[1] = n;
				ijvo[2] = input[m][n];
				ijvo[3] = 1;
				ijvol.add(ijvo);
				d = 0;
				l = 0;
				
				for (int i=1; i<6;i++) {
					if (i%2 == 1) {
						d++;
					}else if (i%2 == 0) {
						l--;
					}
					
					ijvo = new int[4];
					ijvo[0] = m+d;
					ijvo[1] = n+l;
					ijvo[2] = input[m+d][n+l];
					ijvo[3] = i+1;
					ijvol.add(ijvo);
				}

				
				Collections.sort(ijvol, new Comparator<int[]>() {
					@Override
					public int compare(int[] i1, int[] i2) {
						if(i1[3]<i2[3]) {
							return -1;
						}else if(i1[3]>i2[3]) {
							return 1;
						}else {
							return 0;
						}
					}
				});
				/*
				for (int[] i : ijvol ) {
					System.out.printf("%d %d %d %d \n", i[0],i[1],i[2],i[3]);
				}
				*/
				
				v = IndexOfv(ijvol,1,2);
				switch(v) {
					case 0:
						matchv = ijvol.get(3)[2];
						break;
					case 1:
						matchv = ijvol.get(4)[2];
						break;
					case 2:
						matchv = ijvol.get(5)[2];
						break;
					case 3:
						matchv = ijvol.get(0)[2];
						break;
					case 4:
						matchv = ijvol.get(1)[2];
						break;
					case 5:
						matchv = ijvol.get(2)[2];
						break;
				}
				System.out.println(matchv);
				
				break;

			case 6:				
			m = ij[0];
			n = ij[1];
			
			ijvo = new int[4];
			ijvo[0] = m;
			ijvo[1] = n;
			ijvo[2] = input[m][n];
			ijvo[3] = 1;
			ijvol.add(ijvo);
			l = 0;
			d = 0;
			
			for (int i=1; i<6;i++) {
				if (i%2 == 1) {
					l--;
				}else if (i%2 == 0) {
					d++;
				}
				
				ijvo = new int[4];
				ijvo[0] = m+d;
				ijvo[1] = n+l;
				ijvo[2] = input[m+d][n+l];
				ijvo[3] = i+1;
				ijvol.add(ijvo);
			}

			
			Collections.sort(ijvol, new Comparator<int[]>() {
				@Override
				public int compare(int[] i1, int[] i2) {
					if(i1[3]<i2[3]) {
						return -1;
					}else if(i1[3]>i2[3]) {
						return 1;
					}else {
						return 0;
					}
				}
			});
			/*
			for (int[] i : ijvol ) {
				System.out.printf("%d %d %d %d \n", i[0],i[1],i[2],i[3]);
			}
			*/
			
			v = IndexOfv(ijvol,1,2);
			switch(v) {
				case 0:
					matchv = ijvol.get(3)[2];
					break;
				case 1:
					matchv = ijvol.get(4)[2];
					break;
				case 2:
					matchv = ijvol.get(5)[2];
					break;
				case 3:
					matchv = ijvol.get(0)[2];
					break;
				case 4:
					matchv = ijvol.get(1)[2];
					break;
				case 5:
					matchv = ijvol.get(2)[2];
					break;
			}
			System.out.println(matchv);
				
				break;
			case 7:
				m = ij[0];
				n = ij[1];
				
				ijvo = new int[4];
				ijvo[0] = m;
				ijvo[1] = n;
				ijvo[2] = input[m][n];
				ijvo[3] = 1;
				ijvol.add(ijvo);
				d = 0;
				r = 0;
				
				for (int i=1; i<6;i++) {
					if (i%2 == 1) {
						d++;
					}else if (i%2 == 0) {
						r++;
					}
					
					ijvo = new int[4];
					ijvo[0] = m+d;
					ijvo[1] = n+r;
					ijvo[2] = input[m+d][n+r];
					ijvo[3] = i+1;
					ijvol.add(ijvo);
				}

				
				Collections.sort(ijvol, new Comparator<int[]>() {
					@Override
					public int compare(int[] i1, int[] i2) {
						if(i1[3]<i2[3]) {
							return -1;
						}else if(i1[3]>i2[3]) {
							return 1;
						}else {
							return 0;
						}
					}
				});
				/*
				for (int[] i : ijvol ) {
					System.out.printf("%d %d %d %d \n", i[0],i[1],i[2],i[3]);
				}
				*/
				
				v = IndexOfv(ijvol,1,2);
				switch(v) {
					case 0:
						matchv = ijvol.get(3)[2];
						break;
					case 1:
						matchv = ijvol.get(4)[2];
						break;
					case 2:
						matchv = ijvol.get(5)[2];
						break;
					case 3:
						matchv = ijvol.get(0)[2];
						break;
					case 4:
						matchv = ijvol.get(1)[2];
						break;
					case 5:
						matchv = ijvol.get(2)[2];
						break;
				}
				System.out.println(matchv);
				break;
			default:
				System.out.println(vhsf); // case 0:
				break;
		}
		

	}
	public static void horizonCheck(int m, int n) {
		int mm = m+0;
		int nn = n+1;
		
		if (mm>0&&mm<N&&nn>0&&nn<N) {
			if (input[mm][nn]>=1) {
				hcnt++;
				horizonCheck(mm, nn);
			}

		}
		
		mm = m-1;
		nn = n;
		if (mm>0&&mm<N&&nn>0&&nn<N) {
			if (input[mm][nn]>=1) {
				uf = true;
			}
		}
		
		mm = m+1;
		nn = n;
		if (mm>0&&mm<N&&nn>0&&nn<N) {
			if (input[mm][nn]>=1) {
				df = true;
			}
		}
	}
	
	public static void verticalCheck(int m, int n) {
		int mm = m+1;
		int nn = n;
		
		if (mm>0&&mm<N&&nn>0&&nn<N) {
			if (input[mm][nn]>=1) {
				vcnt++;
				verticalCheck(mm, nn);
			}
		}
		
		mm = m;
		nn = n+1;
		if (mm>0&&mm<N&&nn>0&&nn<N) {
			if (input[mm][nn]>=1) {
				rf = true;
			}
		}
		
		mm = m;
		nn = n-1;
		if (mm>0&&mm<N&&nn>0&&nn<N) {
			if (input[mm][nn]>=1) {
				lf = true;
			}
		}
	}
	
	public static void specialCheck(int m, int n) {

		if (form1(m,n)>0) {
			vhsf = 4;
			ij[0] = m;
			ij[1] = n;
		}else if (form2(m,n)>0) {
			vhsf = 5;
			ij[0] = m;
			ij[1] = n;
		}else if (form3(m,n)>0) {
			vhsf = 6;
			ij[0] = m;
			ij[1] = n;
		}else if (form4(m,n)>0) {
			vhsf = 7;
			ij[0] = m;
			ij[1] = n;
		}
		
	}
	
	public static int form1(int m, int n) {
		int result = 0;
		int mm = m+2;
		int nn = n+3;
		if (mm>0&&mm<N&&nn>0&&nn<N) {
			if (input[m][n+1]>=1
					&&input[m+1][n+1]>=1&&input[m+1][n+2]>=1
					&&input[m+2][n+2]>=1&&input[m+2][n+3]>=1) {
				result = 4;
				//System.out.println(input[m][n+1]+" "+input[m+1][n+1]+" "+input[m+1][n+2]+" "+input[m+2][n+2]+" "+input[m+2][n+3]);
				return result;
			}
		}
		return result;
	}
	
	public static int form2(int m, int n) {
		int result = 0;
		int mm = m+3;
		int nn = n-2;
		if (mm>0&&mm<N&&nn>0&&nn<N) {
			if (input[m+1][n]>=1
					&&input[m+1][n-1]>=1&&input[m+2][n-1]>=1
					&&input[m+2][n-2]>=1&&input[m+3][n-2]>=1) {
				result = 5;
				return result;
			}
		}
		return result;
	}
	
	public static int form3(int m, int n) {
		int result = 0;
		int mm = m+2;
		int nn = n-3;
		if (mm>0&&mm<N&&nn>0&&nn<N) {
			if (input[m][n-1]>=1
					&&input[m+1][n-1]>=1&&input[m+1][n-2]>=1
					&&input[m+2][n-2]>=1&&input[m+2][n-3]>=1) {
				result = 6;
				return result;
			}
		}
		return result;
	}
	
	public static int form4(int m, int n) {
		int result = 0;
		int mm = m+3;
		int nn = n+2;
		if (mm>0&&mm<N&&nn>0&&nn<N) {
			if (input[m+1][n]>=1
					&&input[m+1][n+1]>=1&&input[m+2][n+1]>=1
					&&input[m+2][n+2]>=1&&input[m+3][n+2]>=1) {
				result = 7;
				return result;
			}
		}
		return result;
	}
	
	public static void flagInitialize() {
		vf = false;
		hf = false;
		rf = false;
		lf = false;
		uf = false;
		df = false;
		sf = false;
	}
	
	public static void cntInitialize() {
		cnt = 1;
		vcnt = 1;
		hcnt = 1;
	}
	
	public static int IndexOfv(ArrayList<int[]> al, int value, int index) {
		int point = -1;
		
		for (int i=0;i<al.size();i++) {
			if(al.get(i)[index] == value) {
				point = i;
				break;
			}
		}
		
		return point;

	}

}
