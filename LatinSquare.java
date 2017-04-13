
import java.io.*;

public class LatinSquare 
{
    // Matrix that will be used to hold the Latin square matrix data
    Matrix M;
    
    /*
     * Read a file as a square matrix
     */
    public LatinSquare(String filename) throws IOException
    {
        // Open the file
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        
        // Read a row of text
        String line;
        int i = 0;
        while ((line = reader.readLine()) != null) 
        {
            // Split the text by tab
            String[] parts = line.split("\t");
            
            // Create the matrix if we haven't from the number of parts
            if (M == null)
            {
                M = new Matrix(parts.length, parts.length);
            }
            
            // Set the matrix from the line
            for (int j=0; j<parts.length; j++)
            {
                int value = Integer.parseInt(parts[j]);
                M.setMatrixValue(i, j, value);
            }
            
            // Increment the line number
            i++;
        }
        
        reader.close();
    }
    
    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString()
    {
        return M.toString();
    }
    
    /*
     * Find the value in the row. 
     * Return the column where found or -1 otherwise
     */
    public int findInRow(int i, int val)
    {

        int[] matrix_size = M.getSize();
        int m =  matrix_size[0];
        int n = matrix_size[1];
        
        

        for(int j=0;j<n;j++)
        {
            if(val == M.getMatrixValue(i,j))
            {
                return j;
               }
           }

        return -1;
        
    }
    
    /*
     * Find the value in the column
     * Return the row where found or -1 otherwise
     */
    public int findInColumn(int j, int val)
    {

        int[] matrix_size = M.getSize();
        int m =  matrix_size[0];
        int n = matrix_size[1];
        
        

        for(int i=0;i<m;i++)
        {
            if(val == M.getMatrixValue(i,j))
            {
                return i;
               }
           }

        return -1;
        
    }
    
    /*
     * Check if the row is a valid for a Latin square
     */
    public boolean isRowLatin(int row)
    {
        
        int[] matrix_size = M.getSize();
        int m =  matrix_size[0];
        int n = matrix_size[1];
        int sum =  0;
        int W = 0;
        int testsum =  0;

        
        for(int g=1; g<=n; g++)
        {
            sum = sum + g;
        }

        
        for(int j=0;j<n;j++)
        {
            W = M.getMatrixValue(row,j);
            testsum= testsum + W;
        }
            if(sum == testsum)
            return true;
            else
        return false;
    }
    
    
    /*
     * Check if the column is valid for a Latin square
     */
    public boolean isColumnLatin(int col)
    {
        
        int[] matrix_size = M.getSize();
        int m =  matrix_size[0];
        int n = matrix_size[1];
        int sum =  0;
        int W = 0;
        int testsum =  0;

        
        for(int g=1; g<=m; g++)
        {
            sum = sum + g;
        }

        
        for(int j=0;j<m;j++)
        {
            W = M.getMatrixValue(j,col);
            testsum= testsum + W;
        }
            if(sum == testsum)
            return true;
            else
        return false;
    }
    
    /*
     * Check if the matrix is a Latin square
     */
    public boolean isLatin()
   {
       int[] matrix_size = M.getSize();
        int m = matrix_size[0];
        int n = matrix_size[1];
        
        for (int i=0; i < m; i++)
        {
            if (this.isColumnLatin(i) == false )
                return false;
        }
        for (int j=0; j < n; j++)
        {
            if (this.isRowLatin(j) == false )
                return false;
        }
        return true;
    }
}
