#include <stdio.h>
#include <stdlib.h>

//note: int &n means that the variable n is passed to the function, not it's copy.
void input(int a[], int &n)
   {printf("Enter number of elements n = ");
    scanf("%d",&n);
    printf("Enter %d elements:\n",n);
    for(int i=0;i<n;i++)
     {printf("a[%d] = ",i);
      scanf("%d",&a[i]);
     }
    printf("Data input is completed!\n\n");
   }

void display(int a[], int n)
   {for(int i=0;i<n;i++) printf("%d ",a[i]);
     printf("\n");
   }
void dele(int a[], int &n, int k)
 {
    if (k>=n || k<0) return;
    int i=0;
    for (i=k;i<n-1;i++) a[i]=a[i+1];
    n--;
 }


int main()
{ system("cls");
  printf("\nTEST Q3 (2 marks):\n");
  int a[100]; int n, k;
  input(a,n);
  printf("Enter the index to be removed  k = "); scanf("%d",&k);
  printf("The original array:\n");
  display(a,n);
  dele(a,n,k);
  printf("The array after deletion:\n");
  display(a,n);
  //====THE CONTENT AFTER THE WORD "OUTPUT" WILL BE USED TO MARK YOUR PROGRAM====
  printf("\nOUTPUT:\n");
  display(a,n);
  printf("\n");
  system ("pause");
  return(0);
}

