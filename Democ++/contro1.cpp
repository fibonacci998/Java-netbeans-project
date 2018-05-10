#include <stdio.h>
int *findmax(int a[],int n)
{
    int *max=a;
    for(int i=1;i<n;i++)
    if (*max<*(max+i)) *max=*(max+i);
    return max;
}
void dc(int *a1,int *a2)
{
    int tg=*a1;*a1=*a2;*a2=tg;
}
int main()
{
    int i,n;scanf("%d",&n);
    int a[n],b[n];
    for (i=0;i<n;i++)
        scanf("%d",&a[i]);
    int *p;p=findmax(a,n);printf("\nMax=%d\n",*p);
    //dc(a,a+1);for (i=0;i<n;i++)printf("%d ",a[i]);
    for (i=0;i<n;i++) printf("%d ",*(a+i));
    return 0;
}

