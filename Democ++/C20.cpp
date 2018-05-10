#include <stdio.h>
#include <string.h>
int main()
{
    int i,sum=0;
    char s[10000];
    gets(s);
    int n=strlen(s);
    for (i=0;i<n;i++) sum+=s[i]-'0';
    printf("Tong cac chu so = %d",sum);
    return 0;
}

