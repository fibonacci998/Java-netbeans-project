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
 {printf("Enter a string s:\n");
  fflush(stdin);
  gets(s);
  removeRedSpaces(s);
 }

//Display a string s
void display(char s[])
 {printf("%s\n",s);
 }

//--------------------------------------------------------
void fun(int tc, char s[])   // Complete this function
 {// Write your statements here
    int n=strlen(s);
     char ss[n+10];
     strcpy(ss,s);
     char t[n+10][100];
     int i,j=0,k=0;
     char *tg;
     char ans[n+10];ans[0]='\0';
     tg=strtok(ss," ");
     while (tg!=NULL)
     {
         strcpy(t[k++],tg);
         tg=strtok(NULL," ");
     }
    if (tc==1)
    {
        char defau[]="ABCD";
        strcpy(t[1],defau);
        for (i=0;i<k;i++)
        {
            strcat(ans,t[i]);
            if (i!=k-1) strcat(ans," ");
        }
    }
    else
    {
        int minn=strlen(t[0]),pos=0;
        for (i=1;i<k;i++)
        {
            int siz=strlen(t[i]);
            if (siz<minn)
            {
                pos=i;
                minn=siz;
            }
        }
        for (i=0;i<k;i++)
        if (i!=pos)
        {
            strcat(ans,t[i]);
            if (i!=k-1) strcat(ans," ");
        }
    }
    strcpy(s,ans);
 }

int main() {  // Do not edit this function
  // system("cls");
  printf("\nTEST Q3 (2 marks):\n");
  int tc;
  char s[100];
  printf("Enter tc (1 or 2) = ");
  scanf("%d",&tc);
  input(s);
  printf("\nThe original string:\n");
  display(s);
  printf("\nThe string after processing:\n");
  fun(tc,s);
  display(s);
 //OUTPUT for marking:
  printf("\nOUTPUT:\n");
  display(s);
  printf("\n");
  system ("pause");
  return(0);
}


