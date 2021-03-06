#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

//note: int &n means that the variable n is passed to the function, not it's copy.
void input(int a[], int &n) {
	printf("Enter number of elements n = ");
	scanf("%d",&n);
	printf("Enter %d elements:\n",n);
	for(int i=0; i<n; i++) {
		printf("a[%d] = ",i);
		scanf("%d",&a[i]);
	}
}

void display(int a[], int n) {
	for(int i=0; i<n; i++) printf("%d ",a[i]);
	printf("\n");
}
// x^n / n!
double cal(double x, double n){
	double d = 1;
	double i;
	for( i = 1;i<=n;i++){
		d *= x/i;
	}
	return d;
}

//----------------------------------------------------------------------
double fen(double x, double c) { // You should complete this function
	// Write your statements here
	int n = 0;
	//first finding n
	while(cal(x,n++)>=c);
	//
	double sin = 0;
	int i;
	for(i = 0;i<=n;i++){
		sin +=pow(-1,i) * cal(x,2*i + 1);
	}
	return(sin); //This statement must be changed
}

void fun(int a[], int n) { // You should complete this function
	// Write your statements here

}


int main() {  // Do not edit this function
	system("cls");
	printf("\nTEST Q2 (4 marks):\n");
	printf("1. Run TC 1 (fen) \n");
	printf("2. Run TC 2 (fun) \n");
	//tc holds the test case number of test
	int tc;
	printf("Enter TC (0 to exit): ");
	scanf("%d",&tc);
	if(tc==0) return(0);
	//============================================================
	switch(tc) {
		case 1: { // Start of TC 1
			double x, epsi, s;
			printf("Enter x = ");
			scanf("%lf",&x);
			printf("Enter epsi = ");
			scanf("%lf",&epsi);
			s = fen(x,epsi);
			printf("sin(%.1f) = %.4f\n",x,s);
			printf("\nOUTPUT:\n");
			printf("%.4f\n",s);

		}
		break; // end of TC 1

		case 2: { // Start of TC 2
			int a[100];
			int n;
			input(a,n);
			printf("\nThe original array:\n");
			display(a,n);
			fun(a,n);
			printf("\nThe array after processing:\n");
			display(a,n);

			printf("\nOUTPUT:\n");
			display(a,n);
			printf("\n");

		};
		break; // The end of TC2
	}
	printf("\n\n");
	system ("pause");
	return(0);
}
