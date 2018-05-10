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
 {
     printf("%s\n",s);
 }

void sortWords(char s[])
 {
     int n=strlen(s);
     char ss[n+10];
     strcpy(ss,s);
     char t[n+10][20];
     int i,j=0,k=0;
     char *tg,tt[n+10];
     tg=strtok(ss," ");
     while (tg!=NULL)
     {
         strcpy(t[k++],tg);
         tg=strtok(NULL," ");
     }

    for (i=0;i<=k-2;i++)
    for (j=i+1;j<=k-1;j++)
    if (strcmp(t[i],t[j]) > 0)
    {
        strcpy(tt,t[i]);
        strcpy(t[i],t[j]);
        strcpy(t[j],tt);
    }

    char ans[n+10];ans[0]='\0';
    for (i=0;i<k;i++)
    {
        strcat(ans,t[i]);
        if (i!=k-1) strcat(ans," ");
    }
    strcpy(s,ans);
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


