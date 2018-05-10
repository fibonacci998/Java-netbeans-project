#include <stdio.h>
int main()
{
    float a,b,c,d;
    scanf("%f %f %f %f",&a,&b,&c,&d);
    float sum=(a+b+c+d)/4;
    float t[4]={a,b,c,d};
    int i=0,j=0;
    for (i=0;i<3;i++)
    for (j=i+1;j<4;j++)
    if (t[i]>t[j])
    {
        int tg=t[i];t[i]=t[j];t[j]=tg;
    }
    a=sum;b=t[1];c=t[2];d=t[3];
    printf("a = %.2f,\tb = %.0f,\tc = %.0f,\td = %.0f",a,b,c,d);
    return 0;
}

