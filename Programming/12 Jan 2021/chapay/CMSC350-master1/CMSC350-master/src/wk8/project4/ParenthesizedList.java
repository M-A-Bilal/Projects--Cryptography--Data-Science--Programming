/* File: ParenthesizedList.java
 * Date: 09 May 2020
 * Author: Tyler D Clark
 * Description: Implements DFSActions and defines the methods to print allow an overridden toString method to display
 * a graph it is passed. */

package wk8.project4;

public class ParenthesizedList<E> implements DFSActions<E> {

    private final StringBuilder toPrint = new StringBuilder();

    @Override
    public void cycleDetected() {
        toPrint.append(" * ");
    }

    @Override
    public void processVertex(E content) {
        toPrint.append(content);
    }

    @Override
    public void descend() {
        toPrint.append(" ( ");
    }

    @Override
    public void ascend() {
        toPrint.append(" ) ");
    }

    @Override
    public String toString() {
        String replaceString = toPrint.toString();
        return replaceString.replace(" (  )", "").replace("(  *  )", " * ");
    }

}
