#include <stdio.h>
#include <stdlib.h>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int main(int argc, char *argv[]) { //main method header
	int int1, int2, int3; // 3 integers declared to store values
	printf("Enter three integers:\n"); // initial message
	printf("1st integer = "); // message to input first integer
	scanf("%d", &int1); // storing the first integer value from user
	printf("2nd integer = "); // message to input second integer
	scanf("%d", &int2); // storing the second integer value from user
	printf("3rd integer = "); // message to input third integer
	scanf("%d", &int3); // storing the third integer value from user
	
	printf("Sum is %d\n", sum(int1,int2,int3)); // printing the sum of integers
	
	float avg=sum(int1,int2,int3)/3; // calculating average and storing it in float variable
	printf("Average is %.2f\n", avg); // printing the average of integers
	printf("Smallest is %d\n", smallest(int1,int2,int3)); // printing the smallest of all three integers
	printf("Largest is %d\n", largest(int1,int2,int3)); // printing the largest of all three integers
	return 0;
}

int sum(int a, int b, int c){ // function header to calculate sum 
	return a+b+c; // returning sum of integers
}

int largest(int a, int b, int c){ // function header to find maximum value 
	int max=a; // max variable declared and initialized with value of first variable
	if (max<b) // condition to check if value of max initial value which is first variable is smaller than second variable or not
		max=b; // if above condition is true which means second variable is larger then max variable will get the value of second variable
	if (max<c) // condition to check if value of max is smaller than third variable or not
		max=c; // if above condition is true which means third variable is larger then max variable will get the value of third variable
	return max; // finally max will have the largest value which will be returned in the caller function
}

int smallest(int a, int b, int c){ // function header to find minimum value 
	int min=a; // min variable declared and initialized with value of first variable
	if (min>b) // condition to check if value of min initial value which is first variable is greater than second variable or not
		min=b; // if above condition is true which means second variable is smaller then min variable will get the value of second variable
	if (min>c) // condition to check if value of min is larger than third variable or not
		min=c; // if above condition is true which means third variable is smaller then min variable will get the value of third variable
	return min; // finally min will have the smallest value which will be returned in the caller function
}
