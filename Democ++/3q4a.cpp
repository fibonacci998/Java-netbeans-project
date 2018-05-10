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
void sort(int a[], int n)
 {
    int i=0,j=0;
    for (i=0;i<n-1;i++)
    for (j=i+1;j<n;j++)
    if (a[i]>a[j])
    {
        int tg=a[i];a[i]=a[j];a[j]=tg;
    }
 }


int main()
{ system("cls");
  printf("\nTEST Q4 (2 marks):\n");
  int a[100]; int n, k;
  input(a,n);
  printf("The original array:\n");
  display(a,n);
  sort(a,n);
  printf("The array after sorting:\n");
  display(a,n);
  //====THE CONTENT AFTER THE WORD "OUTPUT" WILL BE USED TO MARK YOUR PROGRAM====
  printf("\nOUTPUT:\n");
  display(a,n);
  printf("\n");
  system ("pause");
  return(0);
}

