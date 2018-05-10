#include<bits/stdc++.h>
using namespace std;

int coins[10] = {0};
int v;
int m=4;
/*int t[100000+10]={0};
int pre[100000+10]={-1};
int use[100000+10]={-1};*/
vector<int>t;
vector<int>pre;
vector<int>use;
map<int,int> mp;
int minCoins()
{
    /*t[0]=0;t[coins[1]]=1;
    for (int i=2;i<=v+1;i++) t[i]=INT_MAX;*/
    t.push_back(INT_MAX);
    for (int i=0;i<=v+1;i++)
    {
        t.push_back(INT_MAX);
        pre.push_back(-1);
        use.push_back(-1);
    }
    t[0]=0;t[coins[1]]=1;
    for (int j=2;j<=v;j++){
        int min=INT_MAX;
        int pos=-1;
        for (int i=1;i<=m;i++){
            if (j>=coins[i]){
                if (t[j-coins[i]]+1<min)
                    min=t[j-coins[i]]+1;
                    pos=j-coins[i];
            }
        }
        pre[j]=pos;
        t[j]=min;
    }
    cout<<"-------------------------"<<endl;
    cout<<t[v]<<endl;
    for (int i=1;i<=m;i++){
        mp[coins[i]]=0;
    }
    int pos=v;

    while (pos!=-1 && pos!=0){
        //if (pos==0) break;
        mp[pos-pre[pos]]++;
        pos=pre[pos];
    }
    int num=0;//=mp[coins[1]]+mp[coins[2]]+mp[coins[3]]+mp[coins[4]];
    for (int i=1;i<=4;i++) {
            num+=mp[coins[i]];
            cout<<mp[coins[i]]<<endl;
    }
    int first=0;
    cout<<v<<" = ";
    for (int i=1;i<=m;i++){
        if (mp[coins[i]]!=0){
            if (first!=0) cout<<" + ";
            else first++;
            cout<<mp[coins[i]]<<" * "<<coins[i];
        }
    }
    cout<<endl;
    if (t[v]!=0)
        cout << "Minimum coins required is "<<num;
    else cout<<"No solution";
}
bool ok=false;
int a[5]={0};
bool check()
{
    int sum=0;
    for (int i=1;i<=m;i++)
        sum+=a[i]*coins[i];
    if (sum==v) return true;
    return false;
}
void thu(int pos)
{
    if (ok) return;
    if (pos==m+1){
        ok=check();
        return;
    }
    for (int i=0;i<=100;i++)
    {
        a[pos]=i;
        thu(pos+1);
        if (ok) return;
    }
}
void minCoins1()
{
    cout<<endl<<"----------------"<<endl;
    //thu(1);
    a[1]=2;
    a[2]=0;
    a[3]=2;
    a[4]=5;
    ok=check();
    if (ok){
        for (int i=1;i<=4;i++)
        {
            cout<<a[i]<<' ';
        }
    }
}
int main()
{
    for (int i=1;i<=4;i++){
        cout<<"Enter coin "<<i<<": ";
        cin>>coins[i];
    }
    sort(coins+1,coins+5);
    cout<< "Enter money you want to change: ";
    cin>>v;
    minCoins();
    //minCoins1();
    return 0;
}

