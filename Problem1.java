
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
