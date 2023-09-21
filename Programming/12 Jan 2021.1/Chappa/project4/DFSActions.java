/* File: DFSActions.java
 * Date: 09 May 2020
 * Author: Tyler D Clark
 * Description: An interface that has method bodies for actions specific to locations in a Depth First Search. To be
 * implemented by ParenthesizedList and Hierarchy */

package wk8.project4;

public interface DFSActions<E> {
    void cycleDetected();

    void processVertex(E content);

    void descend();

    void ascend();
}
