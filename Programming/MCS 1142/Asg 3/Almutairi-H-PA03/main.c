#include <stdio.h>

int main() {
  unsigned int x, y, i=1, power=1;	// define variables & initialize i and power
  scanf_s("%u", &x);               	// read value for x from user
  scanf_s("%u", &y);          		// read value for y from user
  while (i <= y) {          		// loop while i is less than or equal to y
    power *= x;               		// multiply power by x
    i++;                      		// increment i
  }                          		// end while
  printf("%u\n", power);      		// display power
  return 0;
}
