/* File: OrderedList.java
 * Date: 07 April 2020
 * Author: Tyler D Clark
 * Description: An unchecked exception which is to be thrown when incorrect syntax is passed to the Polynomial
 * constructor. */

package wk4.project2;

public class InvalidPolynomialSyntax extends RuntimeException {
    InvalidPolynomialSyntax(String msg){super(msg);
    }
}
