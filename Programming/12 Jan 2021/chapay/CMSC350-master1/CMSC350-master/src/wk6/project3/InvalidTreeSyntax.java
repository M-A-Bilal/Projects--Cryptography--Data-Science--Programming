/* File: InvalidTreeSyntax.java
 * Date: 24 April 2020
 * Author: Tyler D Clark
 * Description: This file creates an exception which is to be thrown when an invalid String is passed to the constructor
 * from the project3 GUI
 */
package wk6.project3;

public class InvalidTreeSyntax extends Exception{

    public InvalidTreeSyntax(){
        super();
    }
    public InvalidTreeSyntax(String message){
        super(message);
    }
}
