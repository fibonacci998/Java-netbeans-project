#include <stdio.h>
#include <math.h>
int main()
{
   int m,n;
   printf("Nhap so tien gui: ");scanf("%d",&m);
   printf("Nhap so nam: ");scanf("%d",&n);
   double sum=m*pow(1+0.9/100,n);
   printf("Tien thu duoc sau %d nam: %f",n,sum);
   return 0;
}

