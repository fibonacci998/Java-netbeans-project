#include <stdio.h>
#include <string.h>
#include <ctype.h>

/**
	@param source: the String to remove redundant spaces
	@return a new string without redundant spaces
*/
char *no_more_spaces(char *source){
	char *ptr = NULL;
	ptr = strstr(source,"  "); //2 spaces
	while(ptr){
		strcpy(ptr, ptr + 1);
		ptr = strstr(source,"  "); //2 spaces
	}
	if(source[0] == ' '){ //checking if the 1st char is space ' '
		strcpy(source,source + 1);
	}
	if(source[strlen(source)-1] == ' '){ //checking if the last char is space ' '
		source[strlen(source)-1] = '\0';
	}
	return source;
}

/**
    @param source: the String need to split to array of word
    @param array: the array to store words, each element of this array is a word
    @param delim: the delimiter for spliting
    @param n: the size (or length) of @param array
*/
void string_split(const char *source,char array[][50],const char *delim,int *n) {
	*n = 0;
	char _source[1000];
	char _delim[100];
	strcpy(_source,source);
	strcpy(_delim,delim);
	char *token = NULL;
	token = strtok(_source,_delim);
	while(token) {
		strcpy(array[(*n)++], token);
		token = strtok(NULL, _delim);
	}
}
/**
    @param dest: string to store
    @param source: array to merge
    @param size: size of @param source
    @param delim: the delimeter to merge each word
*/
char *rebuild_string_from_array(char *dest,char source[][50] , int size,const char *delim) {
	char _delim[100];
	strcpy(_delim,delim);
	strcpy(dest,source[0]);
	int i;
	for(i = 1; i< size; i++) {
		strcat(dest,_delim);
		strcat(dest,source[i]);
	}
	return dest;
}

void fun(char *str){
	//sort the string ascending
	char array[100][50];
	int size;
	string_split(str,array," ",&size); //split string str to array of words
	
	printf("\n-----------------------------------\nArray of words: \n");
	int i;
	for(i = 0;i< size;i++){
		printf("%s\n",array[i]);
	}
	
	//sort the array, the same way as we sort int array
	for(i = 0;i<size;i++){
		int j;
		for(j = i+1; j < size;j++){
			if(strcmp(array[i],array[j])>0){  // change '>' to '<' for sort ascending
				char temp[100];
				strcpy(temp,array[i]);
				strcpy(array[i],array[j]);
				strcpy(array[j],temp);
			}
		}
	}
	//the array has been sorted
	//now link each element of the array with " " <- space, and store it into the original string str
	rebuild_string_from_array(str,array,size," ");
}

//make only 1st letter of each word Uppercase (using ctype.h)
void fen(char *str){
	char array[100][50];
	int size;
	string_split(str,array," ",&size); //split string str to array of words
	
	printf("\n-----------------------------------\nArray of words: \n");
	int i;
	for(i = 0;i< size;i++){
		printf("%s\n",array[i]);
	}
	
	//make only the 1st letter is Uppercase
	for(i = 0;i<size;i++){
		array[i][0] = toupper(array[i][0]); //make the 1st letter to Uppercase
		int j; 
		for(j = 1;j < strlen(array[i]);j++){ //loop through each other letter of word
			array[i][j] = tolower(array[i][j]);
		}
	}
	
	//now link each element of the array with " " <- space, and store it into the original string str
	rebuild_string_from_array(str,array,size," ");
}

int main(void){
	char str[1000];
	strcpy(str,"I am student from FPT University");
	
	printf("\n1) Original String: %s\n",str);
	
	printf("-----------------------------------\nSort String Ascending: ");
	fun(str);
	printf("\nString after sort: %s",str);
	
	//other example
	strcpy(str,"xIn chAO cAC BAN Bla bLA bLa");
	printf("\n\n2) Original String: %s\n",str);	
	printf("-----------------------------------\nOnly 1st of each word is uppercase: ");
	fen(str);
	printf("\nString after: %s",str);
	return 0;
}
