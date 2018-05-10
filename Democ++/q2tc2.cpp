#include <stdio.h>
void sapxep(int a[],int start,int finish)
{
    int i,j;
    for (i=start;i<finish;i++)
    for (j=i+1;j<=finish;j++)
    if (a[i]>a[j])
    {
        int tg=a[i];
        a[i]=a[j];
        a[j]=tg;
    }
}
void daonguoc(int a[],int start,int finish)
{
    int i=start,j=finish;
    while (i<=j)
    {
        int tg=a[i];a[i]=a[j];a[j]=tg;
        i++;j--;
    }
}
void dfun(int a[],int n)
{
    if (n%2==0)
    {
        if (n>=5) sapxep(a,n-5,n-1);
        if (n>=4) daonguoc(a,0,3);
    }
    else
    {
        if (n>=4) daonguoc(a,n-5,n-1);
        if (n>=5) sapxep(a,0,4);
    }
}
int main()
{
    int a[100],n,i;
    scanf("%d",&n);
    for (i=0;i<n;i++) scanf("%d",&a[i]);
    printf("Day: \n");
    for (i=0;i<n;i++) printf("%d\t",a[i]);
    printf("\n--------------------\n");
    dfun(a,n);
    for (i=0;i<n;i++) printf("%d\t",a[i]);
    return 0;
}

