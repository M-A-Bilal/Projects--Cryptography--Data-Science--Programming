# CMSC 350 - Project 3

**Author:** Tyler D Clark  
**Date:** 26 April 2020

**Description** A program that allows the user to enter a binary tree in a parenthesized prefix format and then allows it to be categorized and allows various features of that tree to be displayed.
___

## UML chart

![diagram](diagram.png)

<br>

___

## Test cases

|Test Case |Input|Expected Output|Actual Output|Pass?|Notes
|---|---|---|---|---|---|
|1|(4(2(1)(3))(6(5)(7))); Make Tree|(4(2(1)(3))(6(5)(7)))|(4(2(1)(3))(6(5)(7))|Yes|Standard 3-level tree parenthesized correctly.|

![Screenshot1](img/ss1.png)

fig1. Binary tree constructed

<br>

|Test Case |Input|Expected Output|Actual Output|Pass?|Notes
|---|---|---|---|---|---|
|2a|(Following previous input) Is Balanced?|true|true|Yes|Showing proper identification of a balanced tree.|
|2b|(4(2(1)(3))); Is Balanced?|false|false|Yes|Showing proper identification of a un-balanced tree.|
![Screenshot2](img/ss2.png)

fig2. Balanced tree

![Screenshot3](img/ss3.png)

fig3. Unbalanced tree

<br>

|Test Case |Input|Expected Output|Actual Output|Pass?|Notes
|---|---|---|---|---|---|
|3a|(4(2(1)(3))(6(5)(7))); Is Full?|true|true|Yes|Showing proper identification of a full tree.|
|3b|(4(2(1)(3))(6(5))); Is Full?|false|false|Yes|Showing proper identification of a non-full tree.|
![Screenshot4](img/ss4.png)

fig4. Full tree

![Screenshot5](img/ss5.png)

fig5. Non-full tree

<br>

|Test Case |Input|Expected Output|Actual Output|Pass?|Notes
|---|---|---|---|---|---|
|4a|(4(2(1)(3))(6(5)(7))); Is Proper?|true|true|Yes|Showing proper identification of a proper tree.|
|4b|(4(2(1)(3))(6(5))); Is Proper?|false|false|Yes|Showing proper identification of a non-proper tree.|
![Screenshot6](img/ss6.png)

fig6. Proper tree

![Screenshot7](img/ss7.png)

fig7. Non-proper tree

<br>

|Test Case |Input|Expected Output|Actual Output|Pass?|Notes
|---|---|---|---|---|---|
|5a|(4(2(1)(3))(6(5)(7))); Height|2|2|Yes|Showing height of the previous example.|
|5b|(4); Height|0|0|Yes|Showing height of one node.|
![Screenshot8](img/ss8.png)

fig8. Two height tree

![Screenshot9](img/ss9.png)

fig9. One node tree height

<br>

|Test Case |Input|Expected Output|Actual Output|Pass?|Notes
|---|---|---|---|---|---|
|6a|(4(2(1)(3))(6(5)(7))); Nodes|7|7|Yes|Showing node count of the previous example.|
|6b|(4); Nodes|1|1|Yes|Showing node count of one node tree.|
![Screenshot10](img/ss10.png)

fig10. Seven node tree

![Screenshot11](img/ss11.png)

fig11. One node tree

<br>

|Test Case |Input|Expected Output|Actual Output|Pass?|Notes
|---|---|---|---|---|---|
|7|(4(2(1)(3))(6(5)(7))); In Order|(((1)2(3))4((5)6(7)))|(((1)2(3))4((5)6(7)))|Yes|Showing In order printing of tree.|

![Screenshot12](img/ss12.png)

fig12. In Order printed tree

<br>

|Test Case |Input|Expected Output|Actual Output|Pass?|Notes
|---|---|---|---|---|---|
|7a|(1; Make Tree|Error|JOptionPane|Yes|Showing JOptionPane warning against improper syntax|
|7b|(1)(; Make Tree|Error|JOptionPane|Yes|Showing JOptionPane warning against improper syntax|
|7c|(1(2)(3)(4)); Make Tree|Error|JOptionPane|Yes|Showing JOptionPane warning against too many children|
|7d|blank; Make Tree|Error|JOptionPane|Yes|Showing JOptionPane warning against no input|


![Screenshot13](img/ss13.png)

fig13. Incorrect syntax

![Screenshot14](img/ss14.png)

fig14. More incorrect syntax

![Screenshot15](img/ss15.png)

fig15. Even more incorrect syntax

![Screenshot16](img/ss16.png)

fig16. No input

<br>

|Test Case |Input|Expected Output|Actual Output|Pass?|Notes
|---|---|---|---|---|---|
|8a|(A(G(j)(1))(z(5))); Make Tree|(A(G(j)(1))(z(5)))|(A(G(j)(1))(z(5)))|Yes|Showing tree from instructions|
|8b|(previous example); In Order|(((j)G(1))A((5)z))|(((j)G(1))A((5)z))|Yes|Showing in order example from instructions|

![Screenshot17](img/ss17.png)

fig17. Instruction example

![Screenshot18](img/ss18.png)

fig18. Instruction example in order

<br>
<br>
___

## Lessons learned

I got a lot of reps in with recursion in this exercise. I definitely felt more comfortable with recursion through doing it. I also learned a lot about the nature of Binary Trees and feel much more comfortable implementing them. Even though I had difficulty creating nodes recursively in this exercise (due to the parentheses tripping me up), I definitely would look forward to implementing another in the future. I had a lot of fun figuring out how to get my code as concise as possible. I probably over-documented my code and used the conditional operator too much, but I had a good time doing it.
