#include <iostream>
#include <cstdio>
#include <queue>
#include <vector>
using namespace std;
const int gh=100;
struct dsc{int u,v,w;};
bool operator < (dsc x, dsc y)
{
return x.w>y.w;
}
priority_queue<dsc>heap;
vector<int>root;
vector<dsc> tree;
int n,m,count,sum;
void nhap()
{
//freopen("kruskal.inp","r",stdin);
//freopen("kruskal.out","w",stdout);
cin>>n>>m;
dsc c;
root.resize(gh);
for (int i=0;i<m;i++)
{
cin>>c.u>>c.v>>c.w;
heap.push(c);
}
}
int getroot(int r)
{
int i=r;
while (root[i]>0) i=root[i];
return i;
}
void hopnhat(int r1,int r2)
{
int tg=root[r1]+root[r2];
if (root[r1]>root[r2])
{
root[r1]=r2;
root[r2]=tg;
} else{
root[r1]=tg;
root[r2]=r1;
}
}
void kruskal()
{
for (int i=1;i<=n;i++) root[i]=-1;
for (int i=1;i<=m;i++)
{
if (tree.size()==n-1) break;
dsc c;
c=heap.top();heap.pop();
int u=c.u,v=c.v,w=c.w;
int r1=getroot(u);
int r2=getroot(v);
if (r1!=r2)
{
tree.push_back(c);
hopnhat(r1,r2);
}
}
}
void hien()
{
for (int i=0;i<tree.size();i++)
cout<<tree[i].u<<' '<<tree[i].v<<' '<<tree[i].w<<endl;
}
int main()
{
nhap();
kruskal();
hien();
return 0;
}
