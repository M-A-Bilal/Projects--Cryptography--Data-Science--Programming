#include <stdio.h>
int main(){
    int n,i=1,f=1; 	//declare variables and initialize f & i with 1
    printf("Enter a Number to Find Factorial: ");	//print input message
    scanf("%d",&n);	//get input from user
    while(i<=n){	//start while loop with condition
        f*=i;		//multiply and store f with i
        i++;		//increment i by 1
    }				//end of while loop
    printf("The Factorial of %d is : %d",n,f);	//print the result
    return 0;
}

