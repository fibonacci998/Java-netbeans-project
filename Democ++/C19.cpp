#include <stdio.h>
int main()
{
    int sh,sm,fh,fm;
    printf("Enter start hour = ");scanf("%d",&sh);
    printf("Enter start minute = ");scanf("%d",&sm);
    printf("Enter ending hour = ");scanf("%d",&fh);
    printf("Enter ending minute = ");scanf("%d",&fm);
    //
    int sum=( (fh-sh-1)*60+(60-sm)+fm) *500;
    if (sum<0) sum=0;
    //
    printf("Calling charge = %d",sum);
    return 0;
}

