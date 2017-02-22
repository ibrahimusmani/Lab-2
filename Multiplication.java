
package lab2;
import java.util.Scanner;

public class Multiplication {
    Scanner scanf = new Scanner(System.in);
    int m, n, p, q, sum = 0, c, d, k;
    int y[][],z[][];
    //Execute method which will call all the functions
    //Test for this function will fail because User Input is required in it
    public void exec(){
    System.out.println("Matrix 1");
    System.out.println("Enter Rows and Columns of Matrix");
      m = scanf.nextInt();
      n = scanf.nextInt();
      for ( c = 0 ; c < m ; c++ )
         for ( d = 0 ; d < n ; d++ )
            y[c][d] = scanf.nextInt();
 
      int Matrix_1[][] = populate(m,n,y);
      
    System.out.println("Matrix 2");
    System.out.println("Enter Rows and Columns of Matrix");
      p = scanf.nextInt();
      q = scanf.nextInt();
      if ( n != p )
         System.out.println("Matrix order not compatible");     
      else
      {
         for ( c = 0 ; c < m ; c++ )
            for ( d = 0 ; d < n ; d++ )
                z[c][d] = scanf.nextInt();
         int Matrix_2[][] = populate(p,q,z);
 
         int prod[][] = iMultiply(Matrix_1,Matrix_2,m,q,p);
         System.out.println("Product with Iterative method is:");
         
         for ( c = 0 ; c < m ; c++ )
         {
            for ( d = 0 ; d < q ; d++ )
               System.out.print(prod[c][d]+"\t");
 
            System.out.print("\n");
         System.out.println("Product with Iterative method is:");
         int [][]Strassen= sMultiply(Matrix_1,Matrix_2);
         }
      }
    }
    //Multiplying using iterative method
    public int[][] iMultiply(int Matrix_1[][], int Matrix_2[][],int m,int q,int p)
    {
        int product[][] = new int[m][q];
        for ( c = 0 ; c < m ; c++ )
         {
            for ( d = 0 ; d < q ; d++ )
            {   
               for ( k = 0 ; k < p ; k++ )
               {
                  sum = sum + Matrix_1[c][k]*Matrix_2[k][d];
               }
 
               product[c][d] = sum;
               sum = 0;
            }
         }
        return product;
        
    }
    //Populating matrix
    public int[][] populate(int a,int b, int[][] z)
    {

        int Matrix[][] = new int[a][b];
        System.out.println("Now enter the elements");
        for ( c = 0 ; c < a ; c++ )
         for ( d = 0 ; d < b ; d++ )
            Matrix[c][d] = z[c][d];
        return Matrix;
    }
     public int[][] sub(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] - B[i][j];
        return C;
    }
    public int[][] sMultiply(int [][]A, int [][] B)
        {        
        int n = A.length;
        int[][] R = new int[n][n];
        /** base case **/
        if (n == 1)
            R[0][0] = A[0][0] * B[0][0];
        else
        {
            int[][] A11 = new int[n/2][n/2];
            int[][] A12 = new int[n/2][n/2];
            int[][] A21 = new int[n/2][n/2];
            int[][] A22 = new int[n/2][n/2];
            int[][] B11 = new int[n/2][n/2];
            int[][] B12 = new int[n/2][n/2];
            int[][] B21 = new int[n/2][n/2];
            int[][] B22 = new int[n/2][n/2];
 
            /** Dividing matrix A into 4 halves **/
            split(A, A11, 0 , 0);
            split(A, A12, 0 , n/2);
            split(A, A21, n/2, 0);
            split(A, A22, n/2, n/2);
            /** Dividing matrix B into 4 halves **/
            split(B, B11, 0 , 0);
            split(B, B12, 0 , n/2);
            split(B, B21, n/2, 0);
            split(B, B22, n/2, n/2);
 
            
 
            int [][] M1 = iMultiply(add(A11, A22), add(B11, B22),m,p,q);
            int [][] M2 = iMultiply(add(A21, A22), B11,m,p,q);
            int [][] M3 = iMultiply(A11, sub(B12, B22),m,p,q);
            int [][] M4 = iMultiply(A22, sub(B21, B11),m,p,q);
            int [][] M5 = iMultiply(add(A11, A12), B22,m,p,q);
            int [][] M6 = iMultiply(sub(A21, A11), add(B11, B12),m,p,q);
            int [][] M7 = iMultiply(sub(A12, A22), add(B21, B22),m,p,q);
 
            /**
              C11 = M1 + M4 - M5 + M7
              C12 = M3 + M5
              C21 = M2 + M4
              C22 = M1 - M2 + M3 + M6
            **/
            int [][] C11 = add(sub(add(M1, M4), M5), M7);
            int [][] C12 = add(M3, M5);
            int [][] C21 = add(M2, M4);
            int [][] C22 = add(sub(add(M1, M3), M2), M6);
 
            /** join 4 halves into one result matrix **/
            join(C11, R, 0 , 0);
            join(C12, R, 0 , n/2);
            join(C21, R, n/2, 0);
            join(C22, R, n/2, n/2);
        }
        /** return result **/    
        return R;
    
        }
    public int[][] add(int[][] A, int[][] B)
    {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                C[i][j] = A[i][j] + B[i][j];
        return C;
    }
     public void split(int[][] P, int[][] C, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                C[i1][j1] = P[i2][j2];
    }
     public void join(int[][] C, int[][] P, int iB, int jB) 
    {
        for(int i1 = 0, i2 = iB; i1 < C.length; i1++, i2++)
            for(int j1 = 0, j2 = jB; j1 < C.length; j1++, j2++)
                P[i2][j2] = C[i1][j1];
    }   
}

