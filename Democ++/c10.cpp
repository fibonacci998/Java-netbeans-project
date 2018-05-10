#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main()
{
    char s[1000];
    printf("Nhap xau s:");
    gets(s);
    int type;
    printf("\nNhap kieu:\n1.Phan biet chu hoa/thuong\n2.Khong phan biet\n");
    scanf("%d",&type);
    int a=0,b=0,c=0,i,n=strlen(s);
    if (type==1)
    {
        for (i=0;i<n;i++)
        {
            if (s[i]=='A') a++;
            else if (s[i]=='B') b++;
            else if (s[i]=='C') c++;
        }
    }
    else
    {
        for (i=0;i<n;i++)
        {
            if (s[i]=='A' || s[i]=='a') a++;
            else if (s[i]=='B' || s[i]=='b') b++;
            else if (s[i]=='C' || s[i]=='c') c++;
        }
    }
    printf("So ki tu A:%d\n",a);
    printf("So ki tu B:%d\n",b);
    printf("So ki tu C:%d\n",c);

}

