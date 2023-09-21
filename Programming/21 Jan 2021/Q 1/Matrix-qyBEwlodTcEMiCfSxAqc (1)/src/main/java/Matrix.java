/**
 * Question:
 *
 * You are asked to implement the Matrix abstract data-type below
 *
 * Once it is done, copy-paste the complete class in Inginious also with the imports
 *
 *
 * Feel free to add inner-class, methods or fields in the class
 * but do not modify the signature of existing methods
 *
 */
public interface Matrix {

    /**
     * Factory: Creates a n x m integer matrix of zeros
     * @param n the number of row
     * @param m the number of columns
     */
    public static Matrix create(int n, int m) {
        // TODO
         return null;
    }

    /**
     * Set the value v at row r, column j
     * @param r the row
     * @param c the column
     */
    void set(int r, int c, int  v);


    /**
     * Get the value v at row r, column c
     * @param r the row
     * @param c the column
     */
    public int get(int r, int c);

    /**
     * Return a new version of the matrix with the specified row deleted
     * The current matrix is unchanged
     * @param r the row to delete
     */
    public Matrix deleteRow(int r);

    /**
     * Return a new version of the matrix with the specified column deleted
     * The current matrix is unchanged
     * @param c the column to delete
     */
    public Matrix deleteColumn(int c);

}




