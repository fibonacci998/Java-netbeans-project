#include <stdio.h>
void thu(int n)
{
    if (n==0) return;
    int du=n%11;
    thu(n/11);
    if (du==10) printf("a");
    else printf("%d",du);
}
int main()
{
    int n;scanf("%d",&n);
    printf("\ndoi sang co so 11: ");
    thu(n);
    return 0;
}
