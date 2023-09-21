#pragma warning(disable:4996)
#include<stdio.h>
#include<stdlib.h>

struct String{
    int length;
    char str[50];
    char charAtIndex;
};

int charAt(struct String* s, int index) {
    
}

struct String* concat(struct String* s1, struct String* s2) {

}

unsigned int strSearch(struct String* s1, struct String* s2) {

}

unsigned int findScore(struct String* s1) {

}




#define MAXCHAR 1000
int main() {
    FILE* fp;
    char str[MAXCHAR];
    char* filename = "C:\\Misc\\Freelance\\6 Jan 2021\\Hw3\\input.txt";

    fp = fopen(filename, "r");
    if (fp == NULL) {
        printf("Could not open file %s", filename);
        return 1;
    }
    while (fgets(str, MAXCHAR, fp) != NULL) {
        printf("%s", str);
        int choice;
        for (int i = 0; i < strlen(str); i++) {
            if (str[i] == ':') {
                choice = str[i + 1];
            }
        }
    }

    fclose(fp);
    return 0;
}