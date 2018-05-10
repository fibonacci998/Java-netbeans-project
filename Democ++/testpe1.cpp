#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

int squa(int n)
{
    int tg=trunc(sqrt(n));
    if (tg*tg==n) return 1;
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

         int n; double s;
         printf("Enter n = "); scanf("%d",&n);
        //== TC 1, WRITE YOUR STATEMENTS FROM HERE =========
        int i;
        if (n%3==0)
        {
            for (i=3;i<=n;i+=3)
                s+=i;
        }
        else
        {
            for (i=3;i<=n;i++)
                s+=(i-2)/(i*1.0);
        }
        //=========TO HERE============
         printf("s = %.3f\n",s);
         // OUTPUT for marking:
         printf("\nOUTPUT:\n");
         printf("%.3f\n",s);

        };  break; // The end of TC1

    case 2: { // Start of TC 2

         int m,n, a;
         printf("Enter m = "); scanf("%d",&m);
         printf("Enter n = "); scanf("%d",&n);
        //== TC 2, WRITE YOUR STATEMENTS FROM HERE =========
        int i;a=0;
        for (i=m;i<=n;i++)
        if (squa(i)==1)
            a++;

         //=========TO HERE============
         printf("a = %d\n",a);

         // OUTPUT for marking:
         printf("\nOUTPUT:\n");
         printf("%d\n",a);

        };  break; // The end of TC2

  }

  printf("\n");
  system ("pause");
  return(0);
}

