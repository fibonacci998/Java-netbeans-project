#include<stdio.h>
#include<string.h>
void input(char *a)
{
    printf("enter string \n");
    gets (a);
}
void sol(char a[], int b[], int n)
{
    for (int i=0;i<=n;i++) b[i]=0;
    for(int i=0; i<n; i++)
        for(int j=0; j<n; j++)
            if(a[i]==a[j]) b[i]=b[i]+1;
}
void apear (char a[], int b[], int n)
{
    printf("%s",a);
    
    printf("\n----------------\n");
    for (int i=0; i<n; i++)
        if(b[i]!=0) printf("%c", a[i]);
    printf("\n----------------\n");
    for(int i=0; i<n; i++)
        if(b[i]!=0) printf("%d", b[i]);
     printf("\n----------------\n");
     for (int i=0;i<n;i++) printf("%d ",b[i]);
}
void moapear (char a[], int b[], int n)
{
    printf("-----t2------\n\n");
    for (int i=0;i<n;i++) printf("%d ",b[i]);
     printf("-----t2------\n\n");
    int max=0;
    for(int i=0; i<n; i++)
        if (b[i] >= max) max=b[i];
    printf("%d",max);
    printf("\n----------------\n");
    for(int i=0; i<n; i++)
        if (b[i] = max) printf("%d", b[i]);
    printf("\n----------------\n");
     for(int i=0; i<n; i++)
        if (b[i] = max) printf("%c", a[i]);
}
int main()
{
    char a[100];
    int b[100];
    
    input(a);
    int n=strlen (a);
    sol(a,b,n);
    apear(a,b,n);
    moapear(a,b,n);
    return 0;
}