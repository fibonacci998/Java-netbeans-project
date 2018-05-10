#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

//remove redundant spaces in a string s
void removeRedSpaces(char s[])
 {int n,low, up, i, j; char x[100];
  n = strlen(s);
  i=0; j=n-1;
  while(i<n && s[i]==' ') i++;
  low = i;
  while(j>0 && s[j]==' ') j--;
  up = j;
  if(low>up) {strcpy(s,""); return;}
  strcpy(x,"");
  i = low; j=0;
  while(i<=up)
   {while(i<up && s[i]==' ') i++;
    while(i<=up && s[i]!=' ') x[j++] = s[i++];
    if(i<=up) x[j++] = ' ';
   }
  x[j] = '\0';
  strcpy(s,x);
 }

//Enter data for a string s
void input(char s[])
 {printf("Enter a string s = ");
  fflush(stdin);
  gets(s);
  removeRedSpaces(s);
 }

//Display a string s
void display(char s[])
 {printf("%s\n",s);
 }

void sortWords(char s[])
 {
     int n=strlen(s);
     char t[n+10][20];
     int i,j=0,k=0;
     char tg[n];
     for (i=0;i<=n;i++)
        if (s[i]!=' ' && s[i]!='\0')
     {
         tg[j++]=s[i];
     }
     else
     {
        tg[j]='\0';
        strcpy(t[k++],tg);
        j=0;
     }

    for (i=0;i<k-1;i++)
    for (j=i+1;j<k;j++)
    if (strcmp(t[i],t[j]) > 0)
    {
        strcpy(tg,t[i]);
        strcpy(t[i],t[j]);
        strcpy(t[j],tg);
    }
    int jj=0;
    for (i=0;i<k;i++)
     {
        int sizet=strlen(t[i]);
        for (j=0;j<sizet;j++)
            s[jj++]=t[i][j];
        if (i==k-1) s[jj++]='\0';
        else s[jj++]=' ';
     }
 }

int main()
{ system("cls");
  printf("\nTEST Q4 (2 marks):\n");
  char s[100];
  char x[30]; char c;
  input(s);
  printf("\nThe original string:\n");
  display(s);
  printf("The string after processing:\n");
  sortWords(s);
  display(s);
  //====THE CONTENT AFTER THE WORD "OUTPUT" WILL BE USED TO MARK YOUR PROGRAM====
  printf("\nOUTPUT:\n");
  display(s);
  printf("\n");
  system ("pause");
  return(0);
}

