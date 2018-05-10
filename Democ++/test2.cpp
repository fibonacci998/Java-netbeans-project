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
double gt(int n)
{
    if (n==1) return 1;
    return (n*gt(n-1));
}
//----------------------------------------------------------------------
double fen(double x, double c) { // You should complete this function
  // Write your statements here
    int dau=1,i=0;
    double s=0;
    while (1)
    {
        double ts=pow(x,2*i+1);
        double ms=gt(2*i+1);
        s+=dau*ts/ms;
        if (fabs(ts/ms)<=c) break;
        dau*=(-1);
        i++;
    }

   return(s); //This statement must be changed
 }

void fun(int a[], int n) { // You should complete this function
  // Write your statements here
    if (n%2==1)
    {
        int i,j;
        for (i=0;i<n-1;i++)
        for (j=i+1;j<n;j++)
        if (a[i]>a[j])
        {
            int tg=a[i];a[i]=a[j];a[j]=tg;
        }
    }
    else
    {
        int i,j;
        for (i=0;i<n-1;i++)
        for (j=i+1;j<n;j++)
        if (a[i]<a[j])
        {
            int tg=a[i];a[i]=a[j];a[j]=tg;
        }
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
         double x, epsi, s;
         printf("Enter x = "); scanf("%lf",&x);
         printf("Enter epsi = "); scanf("%lf",&epsi);
         s = fen(x,epsi);
         printf("sin(%.1f) = %.4f\n",x,s);
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

         printf("\nOUTPUT:\n");
         display(a,n);
         printf("\n");

        };  break; // The end of TC2
    }
  printf("\n\n");
  system ("pause");
  return(0);
}

