/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   main.c
 * Author: tuans
 *
 * Created on August 7, 2017, 1:16 PM
 */

#include <stdio.h>
#include <string.h>
#include <time.h>
const int sizeString=30;
const int numString=100;
void fileAddress(char data[][sizeString],int *n);
void readFile(char data[][sizeString],int n);
int askPlay();
void creatPuzzle(char data[][sizeString],int n,char *ans,char *yourAns,int *chosen);
void playGame(char *ans,char *yourAns,char *miss,int *chosen);
int checkComplete(char *ans,char *yourAns);
int main()
{
    char data[numString][sizeString];
    int n=0;
    fileAddress(data,&n);
    //readFile(data,n);
    int i=0;
    while (askPlay()==1)
    {
        int chosen[sizeString];
        char ans[sizeString];
        char yourAns[sizeString];
        creatPuzzle(data,n,ans,yourAns,chosen);
        printf("%s  %s\n",ans,yourAns);
        //i++;printf("%d\n",i);
        int miss=0;
        while (miss<5)
        {
            printf("You currently have %d incorrect guesses.\n",miss);
            printf("Here is your puzzle:\n");
            //printf("%s\n",yourAns);
            int i=0;
            for (i=0;i<strlen(yourAns);i++)
                printf("%c ",yourAns[i]);
            printf("\n");
            playGame(ans,yourAns,&miss,&chosen);
            if (miss==5)
            {
                printf("Sorry, you have made 5 incorrect guesses,you lose.\n");
                printf("The correct word was %s",ans);
                break;
            }
            if (checkComplete(ans,yourAns)==1)
            {
                printf("Congratulation! You got the correct word, %s\n",yourAns);
                break;
            }
        }
    }
    printf("Thanks for playing!");
    return 0;
}
void fileAddress(char data[][sizeString],int *n)
{
    FILE *doc;
    char myString[sizeString];
    printf("What file stores the puzzle words?\n");
    char fName[sizeString];
    //gets(fName);
    doc=fopen("words.txt","r");
    *n=0;
    while (fgets(myString,sizeString,doc)!=NULL)
    {
        //puts(myString);
        strtok(myString,"\n");
        strcpy(data[*n],myString);
        (*n)++;
    }
    fclose(doc);
}
void readFile(char data[][sizeString],int n)
{
    int i=0;
    for (i=0;i<n;i++)
        printf("%s %zd\n",data[i],strlen(data[i]));
}
int askPlay()
{
    fflush(stdin);
    printf("\nWould you like to play hangman (yes,no)?\n");
    char ans[3];
    while (1)
    {
        gets(ans);
        if (strcmp(ans,"yes")==0) return 1;
        if (strcmp(ans,"no")==0) return 0;
        printf("Invalid request, just yes or no\n");
    }
}
void creatPuzzle(char data[][sizeString],int n,char *ans,char *yourAns,int *chosen)
{
    srand(time(NULL));
    strcpy(ans,data[rand()%n]);
    int i=0,size=strlen(ans);
    for (i=0;i<size;i++)
        yourAns[i]='_';
    yourAns[size]='\0';
    for (i=0;i<sizeString;i++)
        chosen[i]=0;
}
void playGame(char *ans,char *yourAns,char *miss,int *chosen)
{
    printf("Please enter your guess.\n");

    char letter;
    while (1)
    {
        fflush(stdin);
        scanf("%c",&letter);
        fflush(stdin);
        if (isupper(letter)) break;
        printf("Just enter an upper letter[A-Z]\n");
    }
    int n=strlen(ans),i,checkMiss=1;
    if (chosen[letter-'A']!=0)
    {
        printf("Sorry, you have guessed that letter already.\n");
    }
    else
    {
        for (i=0;i<n;i++)
        if (letter==ans[i])
        {
            yourAns[i]=ans[i];
            chosen[ans[i]-'A']++;
            checkMiss=0;
        }
        if (checkMiss==0 && !(checkComplete(ans,yourAns)==1)) printf("Congratulations, you guessed a letter in the puzzle!\n");
        else printf("Sorry, that letter is NOT in the puzzle.\n");
    }
    *miss+=checkMiss;
}
int checkComplete(char *ans,char *yourAns)
{
    int n=strlen(ans),i;
    for (i=0;i<n;i++)
        if (ans[i]!=yourAns[i]) return 0;
    return 1;
}



