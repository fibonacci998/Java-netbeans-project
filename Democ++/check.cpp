#include <stdio.h>
#include <iostream>
#include <vector>
using namespace std;
int main(){
    int testCase;
    cin>>testCase;

    while(testCase>0){
        testCase--;
        int n,k;
        cin>>n>>k;
        int temp,count=0;
        for (int i=0;i<n;i++){
            cin>>temp;
            if (temp<=0) count++;
        }
        if (count>=k) cout<<"NO"<<endl;
        else cout<<"YES"<<endl;
    }
    return 0;
}


