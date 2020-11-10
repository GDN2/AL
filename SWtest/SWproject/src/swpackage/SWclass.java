package swpackage;
import java.util.Scanner;


public class SWclass {
	
	int[][]matrix;
	int matrixSize;
	int[] group;
	int groupNum;
	int pivotpoint;

	
	public void setSWclass() {
		Scanner scanner = new Scanner(System.in);
		matrixSize = scanner.nextInt();
		matrix = new int[matrixSize][matrixSize];
		//group = new int[matrixSize*matrixSize];
		groupNum = 1;
		
		for (int i=0; i<matrixSize; i++) {
			String line = scanner.next();
			char[] lineArray = line.toCharArray();
			
			for (int j=0; j<matrixSize; j++) {
				matrix[i][j] = Character.getNumericValue(lineArray[j]);
			}
		}
		
	}
	
	public void getMatrix() {
		for (int i=0; i<matrixSize; i++) {
			for (int j=0; j<matrixSize; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public void groupMatrix() {
		for (int i=0; i<matrixSize; i++) {
			
			for (int j=0; j<matrixSize; j++ ) {
				

				if (matrix[i][j] == 1) {
					tailRecursion(i,j);
				}

			

			}
		}
		
		for (int i=0; i<matrixSize; i++) {
			
			for (int j=0; j<matrixSize; j++ ) {
				

				if (matrix[i][j] == 1) {
					tailRecursion(i,j);
				}

			

			}
		}
	}

	public void tailRecursion(int i, int j) {
		
		if (matrix[i][j] == 1) {
			
			if (j != (matrixSize-1) && matrix[i][j+1] > matrix[i][j]) {
				matrix[i][j] = matrix[i][j+1];
				
			} else if (i != (matrixSize-1) && matrix[i+1][j] > matrix[i][j]) {
				
				matrix[i][j] = matrix[i+1][j];
				
			} else if (j != 0 && matrix[i][j-1] > matrix[i][j]) {
				
				matrix[i][j] = matrix[i][j-1];
				
			} else if (i != 0 && matrix[i-1][j] > matrix[i][j]) {
				
				matrix[i][j] = matrix[i-1][j];
			} else {
				groupNum = groupNum + 1;
				matrix[i][j] = groupNum;
			}
			
			
		}
		
		if (j != (matrixSize-1) && matrix[i][j+1] ==1 && matrix[i][j] > matrix[i][j+1]) {
			matrix[i][j+1] = matrix[i][j];
			tailRecursion(i, j+1);
			
		} else if (i != (matrixSize-1) && matrix[i+1][j] ==1 && matrix[i][j] > matrix[i+1][j]) {
			
			matrix[i+1][j] = matrix[i][j];
			tailRecursion(i+1, j);
			
		} else if (j != 0 && matrix[i][j-1] ==1 && matrix[i][j] > matrix[i][j-1]) {
			
			matrix[i][j-1] = matrix[i][j];
			tailRecursion(i,j-1);
			
		} else if (i != 0 && matrix[i-1][j] ==1 && matrix[i][j] > matrix[i-1][j]) {
			
			matrix[i-1][j] = matrix[i][j];
			tailRecursion(i-1,j);
		}

		

			
	}
	
	public int getGroupNum() {
		return this.groupNum-1;
	}
	
	public void getGroupHouseNum() {
		group = new int[groupNum-1];
		
		for (int i=0; i<matrixSize; i++) {
			for (int j=0; j<matrixSize; j++) {
				if (matrix[i][j]>=2) {
					group[matrix[i][j]-2]++;
				}
			}
		}
		

		
	}
	
	
	public void getGroup() {
		for(int i=0; i<group.length; i++) {
			System.out.println(group[i]);
		}
	}
	
	public void quicksort(int low, int high) { //pivotpoint, group[]은 class변수

		
		if(low< high) {
			int localpivotpoint = partition(low, high, pivotpoint);
			
			quicksort(low, localpivotpoint-1); // pivotpoint기준 나누어져 있으니 pivotpoint는 뺌
			quicksort(localpivotpoint+1, high);

		}

	}
	
	public int partition( int low, int high, int pivotpoint) {
		
		int j = low;
		int temp;
		int pivotitem = group[low];
		
		for (int i=low+1; i<=high; i++) {
			if (group[i] < pivotitem) {
				j++;
				temp = group[i];
				group[i] = group[j];
				group[j] = temp;
			}
			
		}
		temp = group[j];
		group[j] = pivotitem;
		group[low] = temp;
		
		pivotpoint = j;
		
		return pivotpoint;
	}
	
	
	

	public static void main(String[] args) {

		SWclass sw = new SWclass();
		sw.setSWclass();

		//
		sw.groupMatrix();
		
		/*
		for (int i=0; i<sw.matrixSize; i++) {
			for (int j=0; j<sw.matrixSize; j++) {
				System.out.print(sw.matrix[i][j]);
			}
			System.out.println();
		}
		*/
		//sw.getMatrix();
		
		//

		sw.getGroupHouseNum();
		sw.quicksort(0, sw.group.length-1);
		System.out.println(sw.getGroupNum());
		sw.getGroup();
		sw.getMatrix();
		
	}

}
/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
*/

/*
7
0110100
0110101
1000101
0000111
0100000
0111110
0111000
*/
/*
8
00101011
11101101
01110111
10011110
10010101
11101011
00101101
11110001

*/
