#include <bits/stdc++.h>
using namespace std;
long long int a,b,m,p,fp;
int input()
{
    cout<<"f(p)=a*p + b (mod m)"<<endl;
    do{
        cout<<"Enter a: ";cin>>a;
        cout<<"Enter b: ";cin>>b;
        cout<<"Enter m: ";cin>>m;
    } while (__gcd(a,m)!=1);
}
long long int afterEncrypt(long long int temp){
    return ((a*p+b)%m);
}
void encrypt(){
    cout<<"Enter origin p: ";cin>>p;
    cout<<"Number after encrypt: "<<afterEncrypt(p);
}

vector<long long int> coefficient;
void extend_euclid(long long int a,long long int b)
{
    long long int s=0,old_s=1;
    long long int t=1,old_t=0;
    long long int r=b,old_r=a;
    while (r!=0){
        long long int quotient=old_r/r;
        long long int temp=r;
        r=old_r-quotient*r;
        old_r=temp;
        temp=s;
        s=old_s-quotient*s;
        old_s=temp;
        temp=t;
        t=old_t-quotient*t;
        old_t=temp;
    }
    coefficient.push_back(old_r);
    coefficient.push_back(old_s);
    coefficient.push_back(old_t);
}
void decrypt(){
    cout<<"Enter f(p):";cin>>fp;
    fp=fp-b;
    extend_euclid(a,m);
    long long int temp=coefficient[1]*fp;
    long long int ans=((temp%m)+m)%m;
    cout<<"Origin number before encrypt: "<<ans;
}
int main()
{
    input();
    cout<<"Enter 1 to encrypt, 2 to decrypt: ";
    int choose=0;cin>>choose;
    if (choose==1) encrypt();
    else decrypt();
    return 0;
}
