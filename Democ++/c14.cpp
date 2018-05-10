#include <stdio.h>
void inse(float a[],int *n,float x,int pos)
{
    int i;
    for (i=(*n)-1;i>=pos;i--)
        a[i+1]=a[i];
    a[pos]=x;
    (*n)++;
}
int main()
{
    int n;float a[1000],x;
    printf("Nhap so phan tu: ");scanf("%d",&n);
    int i;
    for (i=0;i<n;i++)
    {   printf("Nhap a[%d] = ",i);
        scanf("%f",&a[i]);
    }
    printf("Nhap x = ");scanf("%f",&x);
    int pos=-1;
    for (i=0;i<n;i++)
        if (x>a[i]) pos=i+1;
    inse(a,&n,x,pos);
    printf("\nDay sau khi chen: ");
    for (i=0;i<n;i++)
    printf("%.0f ",a[i]);
}

