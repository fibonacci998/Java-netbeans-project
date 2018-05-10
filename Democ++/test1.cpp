#include <stdio.h>
#include <stdlib.h>
#include <math.h>

double fmax(double a,double b)
{
    if (a>b) return a;
    return b;
}
double fmin(double a,double b)
{
    if (a<b) return a;
    return b;
}
int isPrime(int n)
{
    if (n==0 || n==1) return 1;
    int i,ok=0;
    for (i=2;i<=trunc(sqrt(n));i++)
        if (n%i==0) return 1;
    return 0;
}
int main() {
  system("cls");
  printf("\nTEST Q1 (4 marks):\n");
  printf("1. Run TC 1\n");
  printf("2. Run TC 2\n");
  //tc holds the test case number of test
  int tc;
  printf("Enter TC (0 to exit): "); scanf("%d",&tc);
  if(tc==0) return(0);
  //============================================================
  switch(tc) {
    case 1: { // Start of TC 1

         double a, b, c;
         printf("Enter a = "); scanf("%lf",&a);
         printf("Enter b = "); scanf("%lf",&b);
         printf("Enter c = "); scanf("%lf",&c);
         //-------------------------------------------------------
        //==FOR TC 1, WRITE YOUR STATEMENTS FROM HERE=========
        double maxx=fmax(a,fmax(b,c));
        double minn=fmin(a,fmin(b,c));
        double num=a+b+c-maxx-minn;
        a=minn;b=num;c=maxx;

        //=========TO HERE============
         printf("a = %.0f, b = %.0f, c =  %.0f\n",a,b,c);
         // OUTPUT for marking:
         printf("\nOUTPUT:\n");
         printf("%.0f  %.0f  %.0f\n",a,b,c);

        };  break; // The end of TC1

    case 2: { // Start of TC 2

         int n, s;
         printf("Enter n = "); scanf("%d",&n);

        //==FOR TC 2, WRITE YOUR STATEMENTS FROM HERE=========
        int tg=n;s=0;
        while (tg!=0)
        {
            int cs=tg%10;
            if (isPrime(cs)==0) s+=cs;
            tg=tg/10;
        }
         //=========TO HERE============
         printf("s = %d\n",s);
         // OUTPUT for marking:
         printf("\nOUTPUT:\n");
         printf("%d\n",s);

        };  break; // The end of TC2

  }

  printf("\n");
  system ("pause");
  return(0);
}

