#include <stdio.h>
const int gh=1000;
int main()
{
    int i,j,n,a[gh],freq[gh];
    scanf("%d",&n);
    for (i=1;i<=n;i++) scanf("%d",&a[i]);
    for (i=1;i<n;i++) for (j=i+1;j<=n;j++)
    if (a[i]>a[j])
    {
        int tg=a[i];a[i]=a[j];a[j]=tg;
    }
    int freqm=1,cs=a[1];
    for (i=2;i<=n;i++)
    {
        if (a[i]==a[i-1]) freq[i]=freq[i-1]+1;
        else freq[i]=1;
        if (freq[i]>freqm)
        {
            freqm=freq[i];
            cs=a[i];
        }
    }
    printf("%d %d %d",a[1],a[n],cs);
    return 0;
}
