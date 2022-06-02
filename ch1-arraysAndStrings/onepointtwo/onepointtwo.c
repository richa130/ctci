/* 1.2 - Implement a function void reverse(char *str) in C/C++ which reverses a null terminated string */

#include <stdio.h>
#include <string.h>

void reverse(char *str){
    int len = strlen(str); // strlen does NOT include the null terminator

    for(int i = 0; i < len/2; i++){
	char tmp = str[i];
	str[i] = str[len - 1 - i];
	str[len - 1 - i] = tmp;
    }
}

// main takes CLAs, reverses them, then prints them 
int main(int argc, char **argv){
    while(*++argv){
	reverse(*argv);
	printf("%s ", *argv);
    }
    printf("\n");

    return 0;
}
