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
int search(int a[], int n, int x)
 {
     int i=0;
    for (i=n-1;i>=0;i--)
    if (a[i]==x) return i;
  return(-1); // this statement must be changed
 }

int main()
{ system("cls");
  printf("\nTEST Q1 (2 marks):\n");
  int a[100]; int n, x, k;
  x=0;k=99;
  input(a,n);
  printf("Enter the value to be searched x = "); scanf("%d",&x);
  printf("The original array:\n");
  display(a,n);
  k = search(a,n,x);
  if(k>=0 && k<n)
     printf("The value %d is found at the index %d.\n",x,k);
      else
       printf("The value %d is not found in the array.\n",x);

  //====THE CONTENT AFTER THE WORD "OUTPUT" WILL BE USED TO MARK YOUR PROGRAM====
  printf("\nOUTPUT:\n");
  printf("%d\n",k);
  printf("\n");
  system ("pause");
  return(0);
}

