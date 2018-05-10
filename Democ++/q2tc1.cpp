#include <stdio.h>
#include <math.h>
double dfen(double x,int n)
{
    double s=0;
    if (n%2==0)
    {
        int dau=-1,i=0;s=1;
        for (i=1;i<=n;i++)
        {
            double lt=pow(x,i);
            s+=dau*(i*lt)/(i+1);
            dau*=(-1);
        }
    }
    else
    {
        int dau=1,i=0;s=1;
        for (i=2;i<=n;i++)
        {
            s+=dau*pow(i,i)*sqrt(i);
            dau*=(-1);
        }
    }
    return s;
}
int main()
{
    int n;
    double x;
    scanf("%d %f",&n,&x);
    printf("%f",dfen(x,n));
    return 0;
}

