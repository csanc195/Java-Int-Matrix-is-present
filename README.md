# Java-Int-Matrix-is-present
The following java file contains a method that allows to determine if a given number is present in an matrix of primitive integer numbers.

This program includes a simple class with a main algorithm that proposes 
a solution of linear complexity <b>(O(n))</b> to find a certain number/element of the primitive 
type int in an ordered matrix of integer numbers.This matrix is a matrix on which each row 
and column is ordered in descending order.

<b>The algorithm:</b><br>
The main idea behind the functionality of the included algorithm is to use the fact that
the matrix is ordered by row and column in descending order to our advantage. By choosing 
carefully a starting point for the search and choosing the right checks the program can
easily find the desired target (if present) or traverse the matrix and return false quickly
if the target is not present.<br>
In this case, I chose to start at the top right corner, starting at this point allows for the 
assumption that at any given position in the matrix,<b> matrix[xi][yj]</b>, there will always be a larger
element to the left of: <b>matrix[xi][yj]</b> and a smaller element directly under: <b>matrix[xi][yj]</b>; unless
the current tuple is located at the edge, in which case nature of this matrix will ensure that while 
making the right comparisons between the target and the current tuple, the program will traverse
the matrix without the risk of trying to access out of bounds indexes. 
The program will return true if the target is ever found, or false if the matrix is null/empty or if the element is either greater than the greatest element present(I) or smaller than the smallest element present(II). 
Statements (I) and (II) are inductive assumptions that are a result of the ordering of the  given 
matrix, which as a side effect of the ordering will have the largest element located at <b>position[0][0]</b> and
the smallest element at <b>position [m][n]</b>. Where m and n are the values of the rows and columns of the matrix.
