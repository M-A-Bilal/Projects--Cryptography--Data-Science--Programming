
/* File: SyntaxError.java
 * Date: 20 March 2020
 * Author: Tyler D Clark
 * Description: This file creates an exception which is to be thrown when operations are attempted on empty stacks or
 * when the stack has elements left after.
 */
package wk2;

public class SyntaxError extends Exception {
    public SyntaxError() { super(); }
    public SyntaxError(String message){ super(message); }
}
