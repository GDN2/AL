package swpackage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KOI2003_J1C {
	
	static int input[][];
	static int matrix[][];
	static int weight[];
	static int visit[][];
	static int dp[][];
	static int answer[];
	
	static int N;
	static int cntLR[] = new int[3];
	static int cntUD[] = new int[3];
	static int cntDI[] = new int[3];
	static int cntb;
	static int cntw;
	
	static int b = 1;
	static int w = 2;
	
	static ArrayList<Integer> al = new ArrayList<>();
	static ArrayList<Integer> bl = new ArrayList<>();
	static ArrayList<Integer> cl = new ArrayList<>();
	static ArrayList<Integer> dl = new ArrayList<>();
	
	static boolean LRtf = false;
	static boolean UDtf = false;
	static boolean DItf = false;
	static boolean btf = false;
	static boolean wtf = false;
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = 20;
		input = new int[N][N];
		answer = new int[3];
		for(int i=1;i<N;i++) {
			for(int j=1;j<N;j++) {
				input[i][j] = sc.nextInt();
			}
		}

		for(int i=1;i<N;i++) {
			for(int j=1;j<N;j++) {
				cntb=0;
				cntw=0;
				if(input[i][j]==b) {
					cntb=0;
					cntw=0;
					wblr(i,j);
					btf = false;
					cntb=0;
					cntw=0;
					wbud(i,j);
					cntb=0;
					cntw=0;
					btf = false;
					wbdr(i,j);
					cntb=0;
					cntw=0;
					btf = false;
					wbdl(i,j);
					cntb=0;
					cntw=0;
					btf = false;
					
				}else if(input[i][j]==w) {
					cntb=0;
					cntw=0;
					wblr(i,j);
					cntb=0;
					cntw=0;
					wtf = false;
					wbud(i,j);
					cntb=0;
					cntw=0;
					wtf = false;
					wbdr(i,j);
					cntb=0;
					cntw=0;
					wtf = false;
					wbdl(i,j);
					cntb=0;
					cntw=0;
					wtf = false;
				}
				
			}
		}

		//System.out.println();
		System.out.println(answer[0]);
		if(answer[0]!=0) {
			System.out.printf("%d %d",answer[1], answer[2]);
		}

		//System.out.println();
		//cntb=1;
		wblr(15,7);
		
	}
	
	static void wblr(int m, int n) {
		int mm;
		int nn;
		
		mm = m;
		nn = n+4;
		if(mm>=0&&mm<N&&nn>=0&&nn<N) {
			for(int i=n;i<=nn;i++) {
				if(input[mm][i]==b) {
					cntb++;
				}else if(input[mm][i]==w) {
					cntw++;
				}
			}
			if(cntb==5) {
				btf = true;
				if(n-1>=0&&input[mm][n-1]==b) {
					btf = false;
				}else if(n+5<N&&input[mm][n+5]==b) {
					btf = false;
				}
			}else if(cntw==5) {
				wtf = true;
				if(n-1>=0&&input[mm][n-1]==w) {
					wtf = false;
				}else if(n+5<N&&input[mm][n+5]==w) {
					wtf = false;
				}
			}
			
			
		}
		//if(m==15) {
		//	System.out.printf("\ncntb %d cntw %d\n", cntb, cntw);
		//	System.out.println(btf);
		//}
		if(cntb==5 &&btf == true) {
			answer[0] = b;
			answer[1] = m;
			answer[2] = n;
			//System.out.println();
			//System.out.println("Answer1 : "+answer[0]);
			//System.out.printf("%d %d",answer[1], answer[2]);
		}else if(cntw==5 && wtf == true) {
			answer[0] = w;
			answer[1] = m;
			answer[2] = n;
		}
	}
	
	static void wbud(int m, int n) {
		int mm;
		int nn;
		
		mm = m+4;
		nn = n;
		if(mm>=0&&mm<N&&nn>=0&&nn<N) {
			for(int i=m;i<=mm;i++) {
				if(input[i][nn]==b) {
					cntb++;
				}else if(input[i][nn]==w) {
					cntw++;
				}
			}
			if(cntb==5) {
				btf = true;
				if(m-1>=0&&input[m-1][n]==b) {
					btf = false;
				}else if(m+5<N&&input[m+5][n]==b) {
					btf = false;
				}
			}else if(cntw==5) {
				wtf = true;
				if(m-1>=0&&input[m-1][n]==w) {
					wtf = false;
				}else if(m+5<N&&input[m+5][n]==w) {
					wtf = false;
				}
			}
			
			
		}
		
		if(cntb==5 &&btf == true) {
			answer[0] = b;
			answer[1] = m;
			answer[2] = n;
//			System.out.println();
//			System.out.println("Answer2 : "+answer[0]);
//			System.out.printf("%d %d\n",answer[1], answer[2]);
		}else if(cntw==5 && wtf == true) {
			answer[0] = w;
			answer[1] = m;
			answer[2] = n;
//			System.out.println();
//			System.out.println("Answer2 : "+answer[0]);
//			System.out.printf("%d %d\n",answer[1], answer[2]);
		}
	}
	
	static void wbdr(int m, int n) {
		int mm;
		int nn;
		
		mm = m+4;
		nn = n+4;
		//System.out.println(m+" "+n);
		if(mm>=0&&mm<N&&nn>=0&&nn<N) {
			for(int i=0;i<=4;i++) {

				if(input[m+i][n+i]==b) {
					cntb++;
				}else if(input[m+i][n+i]==w) {
					cntw++;
				}


			}
			//System.out.printf("cntb %d\n",cntb);
			//System.out.printf("cntw %d\n",cntw);
			if(cntb==5) {
				btf = true;
				if(m-1>=0&&n-1>=0&&input[m-1][n-1]==b) {
					btf = false;
				}else if(m+5<N&&n+5<N) {
					if(input[m+5][n+5]==b) {
						btf = false;
					}
				}
			}else if(cntw==5) {
				wtf = true;
				if(m-1>=0&&n-1>=0&&input[m-1][n-1]==w) {
					wtf = false;
				}else if(n+5<N&&m+5<N) {
					if(input[m+5][n+5]==w) {
						wtf = false;
					}

				}
			}
			

			
		}
		//System.out.println(m+" "+n);
		if(cntb==5 &&btf == true) {
			answer[0] = b;
			answer[1] = m;
			answer[2] = n;
			//System.out.println();
			//System.out.println("Answer3 : "+answer[0]);
			//System.out.printf("%d %d",answer[1], answer[2]);
		}else if(cntw==5 && wtf == true) {
			answer[0] = w;
			answer[1] = m;
			answer[2] = n;
		}
	}
	
	static void wbdl(int m, int n) {
		int mm=0;
		int nn=0;
		//System.out.println(mm+" "+nn);
		//System.out.println(m+" "+n);
		mm = m+4;
		nn = n-4;
		if(mm>=0&&mm<N&&nn>=0) {
			//System.out.printf("\nm %d n %d\n",m,n);
			for(int i=0;i<=4;i++) {
				//System.out.println(mm+" "+nn);
				//System.out.println(m+" "+n);
				if(input[m+i][n-i]==b) {
					cntb++;
				}else if(input[m+i][n-i]==w) {
					cntw++;
				}


			}
			if(cntb==5) {
				btf = true;
				if(m-1>=0&&n+1<N-1) {
					if(input[m-1][n+1]==b) {
						btf = false;
					}

				}else if(m+5<N&&n-5>=0) {
					if(input[m+5][n-5]==b) {
						btf = false;
					}

				}
			}else if(cntw==5) {
				wtf = true;
				if(m-1>=0&&n+1<N-1) {
					if(input[m-1][n+1]==w) {
						wtf = false;
					}

				}else if(n-5>=0&&m+5<N-1) {
					if(input[m+5][n-5]==w) {
						wtf = false;
					}
				}
			}
			
			
		}
		
		if(cntb==5 &&btf == true) {
			answer[0] = b;
			answer[1] = m+4;
			answer[2] = n-4;
			//System.out.println();
			//System.out.println("Answer4 : "+answer[0]);
			//System.out.printf("%d %d",answer[1], answer[2]);
		}else if(cntw==5 && wtf == true) {
			answer[0] = w;
			answer[1] = m+4;
			answer[2] = n-4;
		}
	}
	
	


}
