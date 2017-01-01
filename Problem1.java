/********************************************************************* 
	Purpose/Description: 
		The following program includes a simple class with a main algorithm that proposes 
 	a solution of linear complexity (O(n)) to find a certain number/element of the primitive 
 	type int in an ordered matrix of integer numbers.This matrix is a matrix on which each row 
 	and column is ordered in descending order.
 		The algorithm:
 			The main idea behind the functionality of the included algorithm is to use the fact that
 		 the matrix is ordered by row and column in descending order to our advantage. By choosing 
 		 carefully a starting point for the search and choosing the right checks the program can
 		 easily find the desired target (if present) or traverse the matrix and return false quickly
	     if the target is not present.
	     In this case, I chose to start at the top right corner, starting at this point allows for the 
	     assumption that at any given position in the matrix, matrix[xi][yj], there will always be a larger
	     element to the left of: matrix[xi][yj] and a smaller element directly under: matrix[xi][yj]; unless
	     the current tuple is located at the edge, in which case nature of this matrix will ensure that while 
	     making the right comparisons between the target and the current tuple, the program will traverse
	     the matrix without the risk of trying to access out of bounds indexes. The program will return true
	     if the target is ever found, or false if the matrix is null/empty or if the element is either greater
	     than the greatest element present(I) or smaller than the smallest element present(II). 
	     Statements (I) and (II) are inductive assumptions that are a result of the ordering of the  given 
	     matrix, which as a side effect of the ordering will have the largest element located at position[0][0] and
	     the smallest element at position [m][n]. Where m and n are the values of the rows and columns of the matrix.
	Author’s Panther ID: <5446178>
	Certification:
	I hereby certify that this work is my own and none of it is the work of any other person.
 ********************************************************************/
/**
 * This is simple public class, class could be easily redefined to be final and
 * to take matrices of any types (ordered by row and column) and find a certain element.
 */
public class Problem1 {

	private int[][] matrix;
	private int m, n;

	// Simple default constructor with no  parameters for testing.  
	public Problem1(){
		m = 4;
		n =4;
		// This is the proposed matrix meant for testing, algorithm will work for 
		// any matrix(That follows the same ordering).
		matrix = new int[][]{{26,22,17,10},{19,16,12,9},{12,10,7,6},{5,4,3,2}};
	}
	// Simple constructor which enables to create any instance of the class with specified values.
	public Problem1(int [][] matrix, int m, int n){
		this.matrix = matrix;
		this.n=n;
		this.m=m;
	}

	// Simple method to view the matrix, meant for testing.
	public int [][] getMatrix(){
		return matrix;
	}

	// Simple method to set a matrix. 
	public void setMatrix(int [][] matrix){
		this.matrix = matrix;
	}

	/**
	 * This method searches for a given element in a matrix of the primitive type int
	 * and returns true of the element is present, returns false otherwise.
	 * @param element This is the only parameter, which indicates the element to search.
	 * @return true if element is present.
	 * @return false if element is not present.
	 */
	public boolean isPresent(int element){
		if((matrix == null) || (matrix.length==0) || (matrix[0][0]< element) || (matrix[m-1][n-1]> element)){
			return false;		    // Element is greater than greatest element/smaller than smallest element 
			// /matrix is empty or null.
		}
		else{
			int x= 0;   			// start at the top right corner of the matrix.
			int y =n-1;  	
			while(x< m && y>=0){
				if(matrix[x][y]== element){
					return true;    //element found.
				}
				if(matrix[x][y]< element){
					y--; 			//move left
				}
				else x++;			//move down
			}
			return false;
		}
	}
	// Simple toString method used for testing.
	public String toString(){
		String answer = "";
		if(matrix.length==0){
			return answer ="Empty";
		}else{
			for(int i =0; i<m ;i++){
				for(int j = 0; j< n; j++){
					answer+= matrix[i][j] + "    ";
				}
				answer +="\n";
			}
		}
		return answer;
	}

}