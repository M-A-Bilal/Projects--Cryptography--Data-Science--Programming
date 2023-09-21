/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Comp251Assignment2;

import java.util.Arrays;

public class greedy {
public static void main(String[] args) {

//This is the typical kind of input you will be tested with. The format will always be the same
//Each index represents a single homework. For example, homework zero has weight 23 and deadline t=3.
int[] weights = new int[] {60, 6, 14, 25, 70};
int[] deadlines = new int[] {3, 1, 2, 1, 3};
int m = weights.length;

//This is the declaration of a schedule of the appropriate size
HW_Sched schedule = new HW_Sched(weights, deadlines, m);

//This call organizes the assignments and outputs homeworkPlan
int[] res = schedule.SelectAssignments();
System.out.println(Arrays.toString(res));
}

}