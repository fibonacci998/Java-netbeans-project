#include<bits/stdc++.h>
using namespace std;
int main()
{
    int x0,a,b,m,ii;
    cout<<"Xi=(a*X(i-1)+b) mod m"<<endl;
    cout<<"Enter x0=";cin>>x0;
    cout<<"Enter a=";cin>>a;
    cout<<"Enter b=";cin>>b;
    cout<<"Enter m=";cin>>m;
    cout<<"Enter i=";cin>>ii;
    for (int i=1;i<=ii;i++)
        x0=(a*x0+b)%m;
    cout<<"X(i)="<<x0;
    return 0;
}
