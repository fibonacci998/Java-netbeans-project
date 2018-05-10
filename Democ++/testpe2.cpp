#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

//note: int &n means that the variable n is passed to the function, not it's copy.
void input(int a[], int &n) {
    printf("Enter number of elements n = ");
    scanf("%d",&n);
    printf("Enter %d elements:\n",n);
    for(int i=0;i<n;i++)
      {printf("a[%d] = ",i);
        scanf("%d",&a[i]);
      }
   }

void display(int a[], int n) {
    for(int i=0;i<n;i++) printf("%d ",a[i]);
     printf("\n");
   }
   // x^n / n!
double cal1(double x, double n){
	double d = 1;
	double i;
	for( i = 1;i<=n;i++){
		d *= x/i;
	}
	return d;
}
double cal(double x,int n)
{
    double d=1;
    int i;
    for (i=1;i<=n;i++)
    {
        if (i%2==0)
            d*=x/i;
        else
            d*=x;
    }
    return d;
}
//----------------------------------------------------------------------
double fen(double x, int n) { // You should complete this function
  // Write your statements here
    double s=0;
    int i;
    for (i=2;i<=n;i+=2)
    {
        double tg=cal(x,i);
        s+=tg;
    }


   return(s); //This statement must be changed
 }


void fun(int a[], int &n) { // You should complete this function
  // Write your statements here
    int i,pos=0,minn=a[0];
    for (i=n-1;i>=0;i--)
    {
        if (a[i]<=minn)
        {
            minn=a[i];
            pos=i;
        }
    }
    if (n%2!=0)
        a[pos]=-99;
    else
    {
        for (i=pos;i<n;i++)
            a[i]=a[i+1];
        if (n!=0) n--;
    }
 }
int main() {  // Do not edit this function
  system("cls");
  printf("\nTEST Q2 (4 marks):\n");
  printf("1. Run TC 1 (fen) \n");
  printf("2. Run TC 2 (fun) \n");
  //tc holds the test case number of test
  int tc;
  printf("Enter TC (0 to exit): "); scanf("%d",&tc);
  if(tc==0) return(0);
  //============================================================
  switch(tc) {
    case 1: { // Start of TC 1
         double x, s; int n;
         printf("Enter x = "); scanf("%lf",&x);
         printf("Enter n = "); scanf("%d",&n);
         s = fen(x,n);
         printf("fen(%.1f,%d) = %.4f\n",x,n,s);
         printf("\nOUTPUT:\n");
         printf("%.4f\n",s);

        }  break; // end of TC 1

    case 2: { // Start of TC 2

         int a[100]; int n;
         input(a,n);
         printf("\nThe original array:\n");
         display(a,n);
         fun(a,n);
         printf("\nThe array after processing:\n");
         display(a,n);
         // OUTPUT for marking:
         printf("\nOUTPUT:\n");
         display(a,n);
         printf("\n");

        };  break; // The end of TC2
    }
  printf("\n\n");
  system ("pause");
  return(0);
}

