#include <stdio.h>
int main()
{
    int n,a[1000];
    printf("Nhap so phan tu: ");scanf("%d",&n);
    int i,j;
    for (i=0;i<n;i++)
    {   printf("Nhap a[%d] = ",i);
        scanf("%d",&a[i]);
    }
    printf("Day sau sap xep:\n");
    for (i=0;i<n-1;i++)
    for (j=i+1;j<n;j++)
    if (a[i]>a[j])
    {
        int tg=a[i];a[i]=a[j];a[j]=tg;
    }
    for (i=0;i<n;i++)
    printf("%d ",a[i]);
}

