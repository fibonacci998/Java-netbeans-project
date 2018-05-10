#include <stdio.h>
int main()
{
    int n,s=0;
    scanf("%d",&n);
    while (n!=0)
    {
        int cs=n%10;
        if (cs==1) s++;
        n=n/10;
    }
    printf("%d",s);
    return 0;
}

