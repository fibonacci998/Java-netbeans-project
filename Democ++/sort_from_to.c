#include <stdio.h>

//param @a is the array
//param @n is number element of the array @a
//param @start is the index to start sort, 0 means start from the begining
//param @end is the index to end sort, n-1 means end at the end of array
void sort_from_to(int *a, int n,int start, int end){
	int i;
	for (i = start; i <= end; i++){
		int j;
		for(j = i+1; j<=end;j++){
			if(a[i] > a[j]){ //change to '<' to sort descending
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
	}
}

void display(int *a,int n){
	int i;
	for (i = 0; i < n; i++){
		printf("(%d) ",a[i]);
	}
}

int main(void)
{
	/* code */
	int a[] = {2,7,1,3,0,9,5,7}; //8 elements
	int n = 8;
	
	//sort first 4 element
	sort_from_to(a,n,0,3); 

//	//sort all the array
//	sort_from_to(a,n,0,n - 1);

//	//sort last 4 element
//	sort_from_to(a,n,n-4,n-1);

//	//sort from 2nd element to 5th element
//	sort_from_to(a,n,1,4);

	//print
	display(a,8);
	return 0;
}
