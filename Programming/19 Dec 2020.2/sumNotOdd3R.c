#include<stdio.h>
#include<stdlib.h>

void main() {
	int arr[] = { 1,4,5,3,2}; // array initialization
	int n = 5; // # of elements to be check 
	int sum = sumOddNot3R(arr, n); // calling the function
	printf("%d", sum); // printing the sum
}

int sumOddNot3R(int arr[], int n) { // the function
	n--;
	int sum = 0; // variable to store the result
	if (n >= 0) { // checking if the remaining elements to be checked are 0
		if (arr[n] % 3 == 0 || arr[n] % 2 == 0) { // checking the condition if the element is odd and is divisible by 3
			sum = sumOddNot3R(arr, n - 1); // recursive call 
		}
		else {
			sum = arr[n] + sumOddNot3R(arr, n - 1); // if the above condition is failed then the current element is added with the return value
		}
	}
	return sum; // returned value
}